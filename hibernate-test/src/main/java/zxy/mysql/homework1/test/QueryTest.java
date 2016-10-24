package zxy.mysql.homework1.test;

import org.hibernate.Transaction;
import sun.security.krb5.internal.Ticket;
import zxy.mysql.homework1.dao.StationDao;
import zxy.mysql.homework1.dao.TicketPriceDao;
import zxy.mysql.homework1.dao.dao.impl.*;
import zxy.mysql.homework1.model.*;

import java.util.*;

/**
 * Created by zxy on 2016/10/22.
 */
public class QueryTest {
    public static void main(String[] args) {
        queryCarriagesByTrainId(5);

    }

    public static CarriageSeat queryCarriagesByTrainId(int trcId){
        Transaction ts = new BaseDaoImpl().getSession().getTransaction();
        ts.begin();
        List<TrainCarriages> trainCarriages = new TrainCarriagesDaoImpl().getTrainCarriageByHql("from TrainCarriages trc where trc.trainCarriagesId="+trcId);
//        List<TrainCarriages> trainCarriages2 = new TrainCarriagesDaoImpl().getTrainCarriageByHql("from TrainCarriages trc where trc.trainCarriagesId="+(trcId+1));
        if(trainCarriages.size()>0){

                TrainCarriages trainCarriages1 = trainCarriages.get(0);
                Set<CarriageSet> carriageSets = trainCarriages1.getCarriageSets();
//            Carriage carriage = carriageSets.getCarriage();
            int i=0;
                for(Iterator<CarriageSet> it = carriageSets.iterator();it.hasNext();){
                    i++;
                    Carriage carriage = it.next().getCarriage();
//                    System.out.println("车厢编号: "+carriage.getCarriageId()+"  车厢名称: "+carriage
//                    .getCarriageName());
                    CarriageSeat carriageSeat = carriage.getCarriageSeat();
                    Set<Seat> seats=carriageSeat.getSeats();
                    for(Iterator<Seat> its = seats.iterator();its.hasNext();){
                        Seat seat =its.next();
                        if(!seat.getSeatPosition().contains("无座位")){
                            System.out.println(String.format("%02d",i)+"车"+seat.getSeatPosition()+"号        "+seat.getSeatType().getSeatTypeNmae()
                            );
                        }

                    }
                    System.out.println("***************************");
//                    for(Seat seat:seats){
//                        System.out.println(seat.getSeatPosition());
//                    }
                }
        }else{
            System.out.println("未找到对应的列车-车厢");
        }
        ts.commit();
        return  null;
    }


    public static TrainNo queryTrainNoByName(String trainNoName) {
        TrainNo trainNo = new TrainNoDaoImpl().getTrainNoByName(trainNoName);
        System.out.println("trainNo name: " + trainNo.getTrainNoName());
        System.out.println("route: " + trainNo.getRoute().getRouteDesc());
        return trainNo;
    }

    public static List<TrainNo> queryTrainNoByFromTo(String from, String to) {
        //test
        /**
        List<TrainNo> trainNos = queryTrainNoByFromTo("南京南","上海虹桥");
        if(trainNos.size()>0){
            for(int i=0;i<trainNos.size();i++){
                TrainNo trainNo = trainNos.get(i);
                System.out.println(trainNo.getTrainNoName());
                System.out.println(trainNo.getRoute().getRouteDesc());
            }
        }else{
            System.out.println("未找到车次");
        }
         */

        //method 1
        /**
         Station fromSta = new StationDaoImpl().getStationByName(from);
         Station toSta = new StationDaoImpl().getStationByName(to);
         List<Route> routes = new RouteDaoImpl().getAllRouteByHql("select docs1.route from DockingStation docs1,DockingStation docs2 where docs1.station="+fromSta.getStationId()+"and docs2.station="+toSta.getStationId()+
         " and docs1.route=docs2.route and docs1.dockingstationOrderNo<docs2.dockingstationOrderNo");
         List<TrainNo> trainNos = new ArrayList<TrainNo>();
         System.out.println(routes.size());
         for(int i=0;i<routes.size();i++){
         Route route = routes.get(i);
         if(route.getRouteStatus()){
         TrainNo trainNo = new TrainNoDaoImpl().getTrainNoByHql("from TrainNo trainNo where trainNo.trainNoStatus=1 and trainNo.route="+route.getRouteId()).get(0);
         trainNos.add(trainNo);
         }
         }
         return trainNos;
         */
        //method 2
        /**
        Station fromSta = new StationDaoImpl().getStationByName(from);
        Station toSta = new StationDaoImpl().getStationByName(to);
        TicketPriceDao ticketPriceDao = new TicketPriceDaoImpl();
        List<TicketPrice> ticketPrices = ticketPriceDao.getTicketPriceByHql("from TicketPrice one where one.startStation=" + fromSta.getStationId() + " and one.endStation=" + toSta.getStationId() + " and one.ticketPriceStatus=1");
        List<TrainNo> trainNos = new ArrayList<TrainNo>();
        for (int i = 0; i < ticketPrices.size(); i++) {
            TrainNo trainNo=ticketPrices.get(i).getTrainNo();
            if (!trainNos.contains(trainNo))
                trainNos.add(trainNo);
        }
        return trainNos;
         */
        return null;
    }

    public static List<TicketPrice> queryPriceByStation(String from, String to) {
//        List<TicketPrice> ticketPrices= queryPriceByStation("北京南","南京南");
//        if(ticketPrices.size()>0){
//            for(TicketPrice ticketPrice:ticketPrices){
//                System.out.println("trainNo: "+ticketPrice.getTrainNo().getTrainNoName()+"   seatType: "+ticketPrice.getSeatType().getSeatTypeNmae()+"  ticketPrice: "+ticketPrice.getTicketPrice());
//            }
//        }else{
//            System.out.println("未找到路线");
//        }
        Station fromSta = new StationDaoImpl().getStationByName(from);
        Station toSta = new StationDaoImpl().getStationByName(to);
        TicketPriceDao ticketPriceDao = new TicketPriceDaoImpl();
        List<TicketPrice> ticketPrices = ticketPriceDao.getTicketPriceByHql("from TicketPrice one where one.startStation=" + fromSta.getStationId() + " and one.endStation=" + toSta.getStationId() + " and one.ticketPriceStatus=1");
        return ticketPrices;
    }

//    public static

}
