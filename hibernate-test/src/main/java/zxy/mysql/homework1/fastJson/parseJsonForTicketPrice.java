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
import zxy.mysql.homework1.dao.TicketPriceDao;
import zxy.mysql.homework1.dao.dao.impl.SeatTypeDaoImpl;
import zxy.mysql.homework1.dao.dao.impl.StationDaoImpl;
import zxy.mysql.homework1.dao.dao.impl.TicketPriceDaoImpl;
import zxy.mysql.homework1.dao.dao.impl.TrainNoDaoImpl;
import zxy.mysql.homework1.model.*;

import java.sql.Date;
import java.util.Scanner;

/**
 * Created by zxy on 2016/10/22.
 */
public class parseJsonForTicketPrice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(!str.contains("#")){
            String trainNoName = str.split(" ")[0];
            getJsonDate(trainNoName);
            str = sc.nextLine();
        }

    }
    public static String getJsonDate(String trainNoName){

        TrainNo trainNo = new TrainNoDaoImpl().getTrainNoByName(trainNoName);
        Route route = trainNo.getRoute();
        String routeStr = route.getRouteDesc();
        String[] routeSp = routeStr.split("-");
        if(trainNoName.equalsIgnoreCase("G95")||(trainNoName.equalsIgnoreCase("G98"))){
            trainNoName = "G95/G98";
        }else if(trainNoName.equalsIgnoreCase("G96")||(trainNoName.equalsIgnoreCase("G97"))){
            trainNoName = "G96/G97";
        }else if(trainNoName.equalsIgnoreCase("G182")||(trainNoName.equalsIgnoreCase("G472"))){
            trainNoName = "G182/G472";
        }
        TicketPriceDao ticketPriceDao = new TicketPriceDaoImpl();
        for(int i=0;i<routeSp.length;i++){
            String from = routeSp[i];
            for(int j=i+1;j<routeSp.length;j++){
                final Thread thread = new Thread();
                try {
                    thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String to = routeSp[j];
                String url = "http://train.qunar.com/qunar/checiPrice.jsp?from="+from+"&to="+to+"&q="+trainNoName+"&format=js&callback=XQScript_12";
                CloseableHttpClient httpclient = HttpClients.createDefault();
                try {
                    HttpGet httpGet = new HttpGet(url);
                    CloseableHttpResponse response = httpclient.execute(httpGet);
                    try {
                        HttpEntity entity = response.getEntity();
                        if (entity != null) {
                            String result = EntityUtils.toString(entity, HTTP.UTF_8);
                            result = result.substring(result.indexOf("ticketInfo")+14,result.indexOf("]"));
                            result = result.substring(result.indexOf(":")+1);
                            result = result+"]";//取出json数据
                            Station fromSt = new StationDaoImpl().getStationByHql("from Station station where station_name='"+from+"'").get(0);
                            Station toSt = new StationDaoImpl().getStationByHql("from Station station where station_name='"+to+"'").get(0);
                            JSONArray jo = JSON.parseArray(result);
                            for(int k=0;k<jo.size();k++){
                                JSONObject jsob = jo.getJSONObject(k);
                                String seatTypeName = jsob.getString("type");
                                String price = jsob.getString("pr");
                                TicketPrice ticketPrice = new TicketPrice();
                                ticketPrice.setEndStation(toSt);
                                ticketPrice.setStartStation(fromSt);
                                SeatType seatType = new SeatTypeDaoImpl().getSeatTypeByHql("from SeatType seatType where seat_type_name='"+seatTypeName+"'").get(0);
                                ticketPrice.setSeatType(seatType);
                                ticketPrice.setTicketPrice(price);
                                ticketPrice.setTicketPriceDes("定价时间："+new Date(System.currentTimeMillis()));
//                                System.out.println(ticketPrice.getTicketPriceDes());
                                ticketPrice.setTrainNo(trainNo);
//                                ticketPrice.toString();
                                ticketPriceDao.save(ticketPrice);
//                                <property name="show_sql">true</property>
                            }

                        }
                    } finally {
                        response.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return "";
    }
}
