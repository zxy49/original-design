package zxy.mysql.homework1.test;

import org.hibernate.Session;
import zxy.mysql.homework1.dao.*;
import zxy.mysql.homework1.dao.dao.impl.*;
import zxy.mysql.homework1.model.*;

import java.sql.Date;
import java.util.Scanner;

/**
 * Created by zxy on 2016/10/18.
 */
public class Test_Insert {


    static RouteDao routeDao;
    static TrainNoDao trainNoDao;
//    static BaseDao baseDao = new BaseDaoImpl();
    public static void main(String[] args) {
//        System.out.print(getRail().getRail_id());
//        insertRail();
//        Train train = new Train();
//        train.setTrain_name("和谐号");
//        train.setParent_rail_id(1);
//        train.setTrain_type(Train.TrainType.动车D);
//        train.setTrain_status(true);
//        TrainDao trainDao = new TrainDaoImpl();
//        System.out.print(trainDao.getTrainById(2).getTrain_name());
//        trainDao.save(train);
//        Session session = new BaseDaoImpl().getSession();
        routeDao = new RouteDaoImpl();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String hql= "from Route route where route.routeId=10";
//        Route route = (Route)baseDao.findAllByHQL(hql).get(0);
        Route route = routeDao.getAllRouteByHql(hql).get(0);
        System.out.print(route.getRouteDesc());
//        session.getTransaction().begin();
//        while (!str.equals("#")) {
//            Route route = new Route();
//            String[] sp = str.split(" ");
//            route.setRouteDesc(sp[1]);
//            route.setRouteStatus(true);
//            routeDao = new RouteDaoImpl();
//            routeDao.save(route);
//            route = routeDao.getLastRouteByRouteName(sp[1]);
//            TrainNo trainNo = new TrainNo();
//            trainNo.setTrainNoName(sp[0]);
//            trainNo.setRoute(route);
//            trainNo.setTrainNoStatus(true);
//            trainNoDao = new TrainNoDaoImpl();
//            trainNoDao.save(trainNo);
//            str = sc.nextLine();
//        }
//        System.out.println(getTrainById(1).getTrain_name());
    }

//    public void insertTrain(Train train){
//        trainDao.save(train);
//    }
//    public static Train getTrainById(int id){
    //    static TrainDao trainDao; = new TrainDaoImpl();
//        return trainDao.getTrainById(id);
//        System.out.println(.getTrain_name());
//    }

    public static void insertRoute(Route route) {
        routeDao.save(route);
    }

    public static void insertRail() {
        RailDao railDao = new RailDaoImpl();
        Rail rail = new Rail();
        rail.setRail_id(1);
        rail.setRail_name("哈尔滨铁路局");
        railDao.save(rail);
    }

    public static Rail getRail() {
        RailDao railDao = new RailDaoImpl();
//        Rail rail = railDao.getRailByName("哈尔滨铁路局");
        Rail rail = railDao.getRailById(1);
        return rail;
    }
}
