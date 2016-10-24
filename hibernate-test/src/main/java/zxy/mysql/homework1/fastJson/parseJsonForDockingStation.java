package zxy.mysql.homework1.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import zxy.mysql.homework1.dao.DockingStationDao;
import zxy.mysql.homework1.dao.TrainNoDao;
import zxy.mysql.homework1.dao.dao.impl.DockingStationDaoImpl;
import zxy.mysql.homework1.dao.dao.impl.StationDaoImpl;
import zxy.mysql.homework1.dao.dao.impl.TrainNoDaoImpl;
import zxy.mysql.homework1.model.*;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zxy on 2016/10/20.
 */
public class parseJsonForDockingStation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(!str.contains("#")){
            String trainNoName = str.split(" ")[0];
            parseJson(trainNoName,getJsonDate(trainNoName));
            str = sc.nextLine();
        }

    }

    public static void parseJson(String trainNoName,String jsonString){
        JSONObject jo = JSON.parseObject(jsonString);
        JSONArray array = jo.getJSONArray("trainScheduleBody");
        TrainNoDao trainNoDao = new TrainNoDaoImpl();
        TrainNo trainNo = trainNoDao.getTrainNoByName(trainNoName);
        Route route = trainNo.getRoute();
        ArrayList<DockingStation> dockingStations = new ArrayList<DockingStation>();
        DockingStationDao dockingStationDao= new DockingStationDaoImpl();
        for(int i=0;i<array.size();i++){
            DockingStation dockingStation = new DockingStation();
            JSONObject jsonObj=array.getJSONObject(i);
            JSONArray jsonObject = jsonObj.getJSONArray("content");
            dockingStation.setDays(jsonObject.get(2).toString());
            dockingStation.setRoute(route);
            dockingStation.setArrivalTime(jsonObject.get(3).toString());
            dockingStation.setDepartureTime(jsonObject.get(4).toString());
            dockingStation.setStayTime(jsonObject.get(5).toString());
            dockingStation.setMileage(jsonObject.get(6).toString());
            dockingStation.setDockingStationId(new Random().nextInt()+1);
            dockingStation.setStation(new StationDaoImpl().getStationByHql("from Station station where station.stationName='"+jsonObject.get(1).toString()+"'").get(0));
            dockingStations.add(dockingStation);
        }
        int[] sorts = new int[dockingStations.size()];
        for(int i=0;i<sorts.length;i++){
            if(dockingStations.get(i).getMileage().contains("公里")){
                sorts[i] = Integer.parseInt(dockingStations.get(i).getMileage().split("公里")[0]);
            }else if(dockingStations.get(i).getArrivalTime().equalsIgnoreCase("起点站")){
                sorts[i]=0;
                dockingStations.get(i).setDockingstationOrderNo(1);
            }
        }
        for(int i=0;i<sorts.length;i++){
            if(sorts[i]==0){
            }else{
                int count=1;
                for (int j=0;j<sorts.length;j++){
                    if(i!=j&&sorts[i]>sorts[j])count++;
                }
                dockingStations.get(i).setDockingstationOrderNo(count);
            }
        }
        for(int i=0;i<dockingStations.size();i++){
            dockingStationDao.save(dockingStations.get(i));
        }


    }



    public static String getJsonDate(String trainNoId){
        if(trainNoId.equalsIgnoreCase("G95")||(trainNoId.equalsIgnoreCase("G98"))){
            trainNoId = "G95/G98";
        }else if(trainNoId.equalsIgnoreCase("G96")||(trainNoId.equalsIgnoreCase("G97"))){
            trainNoId = "G96/G97";
        }else if(trainNoId.equalsIgnoreCase("G182")||(trainNoId.equalsIgnoreCase("G472"))){
            trainNoId = "G182/G472";
        }
        String url = "http://train.qunar.com/qunar/checiInfo.jsp?method_name=buy&ex_track=&q="+trainNoId+"&format=json&cityname=123456&ver=1476977877846";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
//            System.out.println("executing request "+httpGet.getURI());
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
//                System.out.println("--------------------------------------");
                // 打印响应状态
//                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
//                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
//                    System.out.println("Response content: " + EntityUtils.toString(entity));
                    return EntityUtils.toString(entity,HTTP.UTF_8);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
