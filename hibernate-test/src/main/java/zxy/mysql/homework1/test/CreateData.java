package zxy.mysql.homework1.test;

import org.hibernate.Transaction;
import zxy.mysql.homework1.dao.*;
import zxy.mysql.homework1.dao.dao.impl.*;
import zxy.mysql.homework1.model.*;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by zxy on 2016/10/20.
 */
public class CreateData {
    private static BaseDao baseDao =new BaseDaoImpl();
    public static void main(String[] args){
//        insertToCity();
//        insertToStation();
//        insertToSeat();
//        updateSeat();
//        insertToTrainType();
//        insertToTrain();
//        insertToCarriage();
//        insertToTrainCarriages();
//        insertToCarriageSet();
//        insertToCarriageSet();
//        insertToTrainCarriage();
//        insertToRunChart();
//        insertToRunChartSeat();


    }

    public static void insertToRunChartSeat(){
        Transaction transaction = baseDao.getSession().getTransaction();
        transaction.begin();
        RunChartSeatDao runChartSeatDao = new RunChartSeatDaoImpl();
        try{
            int count=0;
            System.out.println("start");
            long start = System.currentTimeMillis();
            List<RunChart> runCharts = new RunChartDaoImpl().getRunChartByHql("from RunChart");
            for(int i=0;i<runCharts.size();i++){
                RunChart runChart = runCharts.get(i);
                TrainCarriages trainCarriages = runChart.getTrainCarriages();
                Set<CarriageSet> carriageSets = trainCarriages.getCarriageSets();
                long start1 = System.currentTimeMillis();
                    for(Iterator<CarriageSet> cs = carriageSets.iterator();cs.hasNext();){
                        CarriageSet carriageSet = cs.next();
                        String pos = String.format("%02d",carriageSet.getCarriageNo())+"车";
                        Carriage carriage = carriageSet.getCarriage();
                        CarriageSeat carriageSeat = carriage.getCarriageSeat();
                        String seatType = carriageSeat.getCarriageSeatType();
                        Set<Seat> seats = carriageSeat.getSeats();
                        for(Iterator<Seat> st = seats.iterator();st.hasNext();){
                            Seat seat = st.next();
                            if(!seat.getSeatPosition().equalsIgnoreCase("无座位")){
                                String position = pos+seat.getSeatPosition()+"号";
                                RunChartSeat runChartSeat = new RunChartSeat();
                                runChartSeat.setRunChart(runChart);
                                runChartSeat.setSeatType(seatType);
                                runChartSeat.setSeatDesc(position);
                                runChartSeatDao.save(runChartSeat);
//                                System.out.println(position);
                                count++;
                            }

                        }
                    }
                long end = System.currentTimeMillis();
                System.out.println("runCharts.get("+i+"):   "+(end-start1)+"ns");
            }
            long end = System.currentTimeMillis();
            System.out.println((end-start)+"ns");
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            System.out.println("over");
        }
    }

    public static void insertToRunChart(){
        Transaction transaction = baseDao.getSession().getTransaction();
        transaction.begin();
        try{
            List<TrainNo> trainNos =new TrainNoDaoImpl().getTrainNoByHql("from TrainNo");
            RunChartDao runChartDao = new RunChartDaoImpl();
            for(int tn = 0;tn<trainNos.size();tn++){
                TrainCarriages trainCarriages = new TrainCarriagesDaoImpl().getTrainCarriageById(tn+1);
                TrainNo trainNo = trainNos.get(tn);
                for(int i=1;i<=7;i++){
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(new Date(System.currentTimeMillis()));
                    cal.add(Calendar.DATE, i);
                    Date date = new Date(cal.getTime().getTime());
                    RunChart runChart = new RunChart();
                    runChart.setRunChartRunTime(date);
                    runChart.setRunChartStatus(true);
                    runChart.setTrainCarriages(trainCarriages);
                    runChart.setTrainNo(trainNo);
                    runChartDao.save(runChart);
                }
            }
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            System.out.println("over");
        }
    }

    public static void insertToTrainCarriage(){
        Transaction transaction = baseDao.getSession().getTransaction();
        transaction.begin();
        List<Train> trains = new TrainDaoImpl().getAllTrainByHql("from Train");
        try{
            if(trains.size()>0){
                String hql = "from CarriageSet cs where cs.carriage.carriageSeat.carriageSeatId=3";
                List<CarriageSet> firstCarriageSets =  new CarriageSetDaoImpl().getCarriageSetByHql(hql);
                hql = "from CarriageSet cs where cs.carriage.carriageSeat.carriageSeatId=4";
                List<CarriageSet> secondCarriageSets = new CarriageSetDaoImpl().getCarriageSetByHql(hql);
                TrainCarriagesDao trainCarriagesDao = new TrainCarriagesDaoImpl();
                int firstCSL = firstCarriageSets.size();
                int secondCSL = secondCarriageSets.size();
                for(int i=0;i<trains.size();i++){
//                    System.out.println("train"+(i+1)+":");
                    TrainCarriages trainCarriages = new TrainCarriages();
                    Set<CarriageSet> carriageSets = new HashSet<CarriageSet>();
                    int random = new Random().nextInt(16);
                    if(random>8){
                        for(int j=0;j<6;j++){
                            CarriageSet carriageSet = firstCarriageSets.get((16*i+17*j)%firstCSL);
                            carriageSets.add(carriageSet);
//                            System.out.println(carriageSet.getCarriage().getCarriageId()+"  "+carriageSet.getCarriageNo());
                        }
                        for(int j=0;j<10;j++){
                            CarriageSet carriageSet = secondCarriageSets.get((16*i+17*j+6)%secondCSL);
                            carriageSets.add(carriageSet);
//                            System.out.println(carriageSet.getCarriage().getCarriageId()+"  "+carriageSet.getCarriageNo());
                        }
                    }else{
                        for(int j=0;j<3;j++){
                            CarriageSet carriageSet = firstCarriageSets.get((16*i+17*j)%firstCSL);
                            carriageSets.add(carriageSet);
//                            System.out.println(carriageSet.getCarriage().getCarriageId()+"  "+carriageSet.getCarriageNo());
                        }
                        for(int j=0;j<5;j++){
                            CarriageSet carriageSet = secondCarriageSets.get((16*i+17*j+3)%secondCSL);
                            carriageSets.add(carriageSet);
//                            System.out.println(carriageSet.getCarriage().getCarriageId()+"  "+carriageSet.getCarriageNo());
                        }
                    }
                    trainCarriages.setTrain(trains.get(i));
                    trainCarriages.setCarriageSets(carriageSets);
                    trainCarriages.setTrainCarriagesId(i+1);
                    trainCarriagesDao.save(trainCarriages);
                }
                transaction.commit();
            }else{
                System.out.println("error");
            }
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            System.out.println("over");
        }


    }

    public static void insertToTicketPrice(){
        String url;
    }

    public static void insertToTrainCarriages2(){//默认车厢八截
        Transaction transaction = baseDao.getSession().getTransaction();
        transaction.begin();
        TrainCarriagesDao trainCarriagesDao = new TrainCarriagesDaoImpl();
        List<Train> trains = new TrainDaoImpl().getAllTrainByHql("from Train");
        try{
            if(trains.size()>0){
                String hql = "from Carriage carriage where carriage_seat_id=3";
                List<Carriage> firstCarriages =  new CarriageDaoImpl().getCarriageByHql(hql);
                hql = "from Carriage carriage where carriage_seat_id=4";
                List<Carriage> secondCarriages = new CarriageDaoImpl().getCarriageByHql(hql);
                for(int i=0;i<trains.size();i++){
                    Train train = trains.get(i);
                    TrainCarriages trainCarriages = new TrainCarriages();
                    Set<CarriageSet> carriageSets = new HashSet<CarriageSet>();
                    for(int j=1;j<=3;j++){
                        Carriage carriage1 = firstCarriages.get(3*i-3);
                        Carriage carriage2 = firstCarriages.get(3*i-2);
                        Carriage carriage3 = firstCarriages.get(3*i-1);
                        String getCS1 = "from CarriageSet cs where cs.carriage="+carriage1.getCarriageId()+" and cs.carriageNo=1";
                        String getCS2 = "from CarriageSet cs where cs.carriage="+carriage2.getCarriageId()+" and cs.carriageNo=2";
                        String getCS3 = "from CarriageSet cs where cs.carriage="+carriage3.getCarriageId()+" and cs.carriageNo=3";
                        CarriageSet carriageSet = new CarriageSet();

//                        carriageSets.add(new CarriageSetDaoImpl().getCarriageSetByHql("from"));
                        carriageSet.setCarriage(carriage2);
                        carriageSet.setCarriageNo(2);
                        carriageSets.add(carriageSet);
                        carriageSet.setCarriage(carriage3);
                        carriageSet.setCarriageNo(3);
                        carriageSets.add(carriageSet);
                        Carriage carriage4 = secondCarriages.get(5*i-5);
                        Carriage carriage5 = secondCarriages.get(5*i-4);
                        Carriage carriage6 = secondCarriages.get(5*i-3);
                        Carriage carriage7 = secondCarriages.get(5*i-2);
                        Carriage carriage8 = secondCarriages.get(5*i-1);
                        carriageSet.setCarriage(carriage4);
                        carriageSet.setCarriageNo(4);

                    }
                    trainCarriages.setTrain(train);
                    trainCarriages.setCarriageSets(carriageSets);
                }
                transaction.commit();
            }
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            System.out.println("over");
        }
    }

    public static void insertToTrainCarriages(){
        TrainCarriagesDao trainCarriagesDao = new TrainCarriagesDaoImpl();
        for(int i=1;i<201;i++){
            Train train = new TrainDaoImpl().getTrainById(i);
            String hql = "from Carriage carriage where carriage_seat_id=3";
            Set<Carriage> carriages = new HashSet<Carriage>();
            List<Carriage> firstCarriages =  new CarriageDaoImpl().getCarriageByHql(hql);
            Carriage carriage1 = firstCarriages.get(3*i-3);
            Carriage carriage2 = firstCarriages.get(3*i-2);
            Carriage carriage3 = firstCarriages.get(3*i-1);
            carriages.add(carriage1);
            hql = "from Carriage carriage where carriage_seat_id=4";
            List<Carriage> secondCarriages = new CarriageDaoImpl().getCarriageByHql(hql);
            Carriage carriage4 = secondCarriages.get(5*i-5);
            Carriage carriage5 = secondCarriages.get(5*i-4);
            Carriage carriage6 = secondCarriages.get(5*i-3);
            Carriage carriage7 = secondCarriages.get(5*i-2);
            Carriage carriage8 = secondCarriages.get(5*i-1);
            carriages.add(carriage1);
            carriages.add(carriage2);
            carriages.add(carriage3);
            carriages.add(carriage4);
            carriages.add(carriage5);
            carriages.add(carriage6);
            carriages.add(carriage7);
            carriages.add(carriage8);
            TrainCarriages trainCarriages = new TrainCarriages();
//            trainCarriages.setCarriages(carriages);
            trainCarriages.setTrain(train);
            trainCarriages.setTrainCarriagesId(i);
            trainCarriagesDao.save(trainCarriages);
        }
    }

    public static void insertToCarriage(){
        CarriageDao carriageDao = new CarriageDaoImpl();
        List<Carriage> carriages = new ArrayList<Carriage>();
//        for(int i =0;i<1000;i++){
//            Carriage carriage = new Carriage();
//            carriage.setCarriageSeat(new CarriageSeatDaoImpl().getCarriageSeatById(4));
//            carriage.setCarriageType(new CarriageTypeDaoImpl().getCarriageTypeById(13));
//            carriage.setCarriageName("CRH1-No."+(i+2));
//            carriage.setCarriageStatus(true);
//            carriage.setCreateTime("2012年");
//            carriage.setValidTime("二十年");
//            carriage.setSeatNum(100);
//            carriages.add(carriage);
//            carriageDao.save(carriage);
//        }
        for(int i =0;i<600;i++){
            Carriage carriage = new Carriage();
            carriage.setCarriageSeat(new CarriageSeatDaoImpl().getCarriageSeatById(3));
            carriage.setCarriageType(new CarriageTypeDaoImpl().getCarriageTypeById(2));
            carriage.setCarriageName("CRH2-No."+(i+1));
            carriage.setCarriageStatus(true);
            carriage.setCreateTime("2013年");
            carriage.setValidTime("二十年");
            carriage.setSeatNum(80);
            carriages.add(carriage);
            carriageDao.save(carriage);
        }

    }

    public static void insertToTrainType(){
        TrainType trainType = new TrainType();
        TrainTypeDao trainTypeDao = new TrainTypeDaoImpl();
        trainType.setTrainTypeName("高铁G");
        trainType.setTrainTypeDesc("高铁");
        trainTypeDao.save(trainType);
    }

    public static void insertToTrain(){

        TrainDao trainDao = new TrainDaoImpl();
        for(int i=0;i<200;i++){
            Rail rail = new RailDaoImpl().getRailById(new Random().nextInt(18)+1);
            Train train = new Train();
            train.setRail(rail);
            train.setTrain_status(true);
            train.setTrain_name("和谐号");
            TrainType trainType = new TrainTypeDaoImpl().getTrainTypeById(1);
            train.setTrainType(trainType);
            trainDao.save(train);
        }

    }

    public static void insertToCity(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> stationNames = new ArrayList<String>();
        while(true){
            if(str.contains("#"))
                break;
            String[] sp = str.split(" ");
            String[] stations = sp[1].split("-");
            for (int i=0;i<stations.length;i++){
                if(!stationNames.contains(stations[i])){
                    stationNames.add(stations[i]);
                }
            }
            str = sc.nextLine();
        }
        ArrayList<String> cityNames = new ArrayList<String>();
        CityDao cityDao = new CityDaoImpl();
        for(int i=0;i<stationNames.size();i++){
            String name= stationNames.get(i);
            if(name.length()>2&&(name.endsWith("东")||name.endsWith("西")||name.endsWith("南")||name.endsWith("北"))){
                name = name.substring(0,name.length()-1);
            }else if(name.endsWith("虹桥")){
                name = name.substring(0,name.length()-2);
            }
            City city = new City();
            city.setCityName(name);
            city.setCityStatus(true);
            Rail rail = new RailDaoImpl().getRailById(new Random().nextInt(18)+1);
            city.setRail(rail);
            cityDao.save(city);
        }
    }


    public static  void updateSeat(){
        SeatDao seatDao = new SeatDaoImpl();
        List<Seat> seatList = seatDao.getSeatByHql("from Seat seat where seat.carriageSeat.carriageSeatId=10");
        for(int i =0;i<seatList.size();i++){
            Seat seat = seatList.get(i);
            CarriageSeat carriageSeat = new CarriageSeatDaoImpl().getCarriageSeatById(3);
            seat.setCarriageSeat(carriageSeat);
            seatDao.update(seat);
        }
        List<Seat> seatList2 = seatDao.getSeatByHql("from Seat seat where seat.carriageSeat.carriageSeatId=11");
        for(int i =0;i<seatList2.size();i++){
            Seat seat = seatList2.get(i);
            CarriageSeat carriageSeat = new CarriageSeatDaoImpl().getCarriageSeatById(4);
            seat.setCarriageSeat(carriageSeat);
            seatDao.update(seat);
        }
        seatList2 = seatDao.getSeatByHql("from Seat seat where seat.carriageSeat.carriageSeatId=12");
        for(int i =0;i<seatList2.size();i++){
            Seat seat = seatList2.get(i);
            CarriageSeat carriageSeat = new CarriageSeatDaoImpl().getCarriageSeatById(8);
            seat.setCarriageSeat(carriageSeat);
            seatDao.update(seat);
        }
        seatList2 = seatDao.getSeatByHql("from Seat seat where seat.carriageSeat.carriageSeatId=13");
        for(int i =0;i<seatList2.size();i++){
            Seat seat = seatList2.get(i);
            CarriageSeat carriageSeat = new CarriageSeatDaoImpl().getCarriageSeatById(9);
            seat.setCarriageSeat(carriageSeat);
            seatDao.update(seat);
        }
//        List<Seat> seatList = seatDao.getSeatByHql("from Seat seat where seat.seatType.seatTypeId=4");
//        for(int i =0;i<seatList.size();i++){
//            Seat seat = seatList.get(i);
//            if(seat.getSeatPosition().contains("D")){
//                seat.setSeatPosition(seat.getSeatPosition().replace("D","C"));
//                seatDao.update(seat);
//            }else if(seat.getSeatPosition().contains("E")){
//                seat.setSeatPosition(seat.getSeatPosition().replace("E","D"));
//                seatDao.update(seat);
//            }
//        }
    }
    public static void insertToSeat(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] sp = str.split(" ");
        SeatType seatType = new SeatTypeDaoImpl().getSeatTypeById(Integer.parseInt(sp[1]));
        CarriageSeat carriageSeat = new CarriageSeatDaoImpl().getCarriageSeatById(Integer.parseInt(sp[0]));
        int times = 0;
        SeatDao seatDao = new SeatDaoImpl();
        if(sp[0].equalsIgnoreCase("1")){
            for(int i=1;i<=7;i++){
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d",i)+"A");
                seat1.setSeatType(seatType);
                seat1.setCarriageSeat(carriageSeat);
                seatDao.save(seat1);
                Seat seat2 = new Seat();
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatPosition(String.format("%02d",i)+"B");
                seat2.setSeatType(seatType);
                seatDao.save(seat2);
                Seat seat3 = new Seat();
                seat3.setSeatPosition(String.format("%02d",i)+"D");
                seat3.setSeatType(seatType);
                seat3.setCarriageSeat(carriageSeat);
                seatDao.save(seat3);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d",i)+"F");
                seat4.setSeatType(seatType);
                seat4.setCarriageSeat(carriageSeat);
                seatDao.save(seat4);
            }
        }
        else if(sp[0].equalsIgnoreCase("2")){
            for(int i=1;i<=7;i++){
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d",i)+"A");
                seat1.setSeatType(seatType);
                seat1.setCarriageSeat(carriageSeat);
                seatDao.save(seat1);
                Seat seat2 = new Seat();
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatPosition(String.format("%02d",i)+"C");
                seat2.setSeatType(seatType);
                seatDao.save(seat2);
                Seat seat3 = new Seat();
                seat3.setSeatPosition(String.format("%02d",i)+"D");
                seat3.setSeatType(seatType);
                seat3.setCarriageSeat(carriageSeat);
                seatDao.save(seat3);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d",i)+"F");
                seat4.setSeatType(seatType);
                seat4.setCarriageSeat(carriageSeat);
                seatDao.save(seat4);
            }
        }
        else if(sp[0].equalsIgnoreCase("3")){
            for(int i=1;i<=20;i++){
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d", i) +"A");
                seat1.setSeatId(97+4*i);
                seat1.setCarriageSeat(carriageSeat);
                seat1.setSeatType(seatType);
                seatDao.update(seat1);
                Seat seat2 = new Seat();
                seat2.setSeatId(98+4*i);
                seat2.setSeatPosition(String.format("%02d", i) +"B");
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatType(seatType);
                seatDao.update(seat2);
//                Seat seat3 = new Seat();
//                seat3.setSeatPosition(String.format("%02d", i) +"D");
//                seat3.setCarriageSeat(carriageSeat);
//                seat3.setSeatType(seatType);
//                seatDao.save(seat3);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d", i) +"E");
                seat4.setCarriageSeat(carriageSeat);
                seat4.setSeatId(99+4*i);
                seat4.setSeatType(seatType);
                seatDao.update(seat4);
                Seat seat5 = new Seat();
                seat5.setSeatPosition(String.format("%02d", i) +"F");
                seat5.setSeatId(100+4*i);
                seat5.setCarriageSeat(carriageSeat);
                seat5.setSeatType(seatType);
                seatDao.update(seat5);
            }
        }
        else if(sp[0].equalsIgnoreCase("5")) {
            for (int i = 1; i <= 11; i++) {
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d", 2*i-1) +"号下铺");
                seat1.setCarriageSeat(carriageSeat);
                seat1.setSeatId(179+2*i);
                seat1.setSeatType(seatType);
                seatDao.update(seat1);
                Seat seat2 = new Seat();
                seat2.setSeatId(98+4*i);
                seat2.setSeatPosition(String.format("%02d", 2*i) +"号下铺");
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatType(seatType);
                seat2.setSeatId(180+2*i);
                seatDao.update(seat2);

            }
        }
        else if(sp[0].equalsIgnoreCase("6")) {
            for (int i = 1; i <= 11; i++) {
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d", 4*i-3) +"号下铺");
                seat1.setCarriageSeat(carriageSeat);
                seat1.setSeatType(seatType);
                seatDao.save(seat1);
                Seat seat2 = new Seat();
                seat2.setSeatId(98+4*i);
                seat2.setSeatPosition(String.format("%02d", 4*i-2) +"号上铺");
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatType(seatType);
                seatDao.save(seat2);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d", 4*i-1) +"号下铺");
                seat4.setCarriageSeat(carriageSeat);
                seat4.setSeatType(seatType);
                seatDao.save(seat4);
                Seat seat5 = new Seat();
                seat5.setSeatPosition(String.format("%02d", 4*i) +"号上铺");
                seat5.setCarriageSeat(carriageSeat);
                seat5.setSeatType(seatType);
                seatDao.save(seat5);
            }
        }
        else if(sp[0].equalsIgnoreCase("7")) {
            for (int i = 1; i <= 22; i++) {
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d", i) +"号下铺");
                seat1.setCarriageSeat(carriageSeat);
                seat1.setSeatType(seatType);
                seatDao.save(seat1);
                Seat seat2 = new Seat();
                seat2.setSeatPosition(String.format("%02d", i) +"号中铺");
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatType(seatType);
                seatDao.save(seat2);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d", i) +"号上铺");
                seat4.setCarriageSeat(carriageSeat);
                seat4.setSeatType(seatType);
                seatDao.save(seat4);
            }
        }
        else if(sp[0].equalsIgnoreCase("8")){
            for(int i=1;i<=20;i++){
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d",i)+"A");
                seat1.setSeatType(seatType);
                seat1.setCarriageSeat(carriageSeat);
                seatDao.save(seat1);
                Seat seat2 = new Seat();
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatPosition(String.format("%02d",i)+"C");
                seat2.setSeatType(seatType);
                seatDao.save(seat2);
                Seat seat3 = new Seat();
                seat3.setSeatPosition(String.format("%02d",i)+"D");
                seat3.setSeatType(seatType);
                seat3.setCarriageSeat(carriageSeat);
                seatDao.save(seat3);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d",i)+"F");
                seat4.setSeatType(seatType);
                seat4.setCarriageSeat(carriageSeat);
                seatDao.save(seat4);
            }
        }else if(sp[0].equalsIgnoreCase("9")){
            for(int i=1;i<=20;i++){
                Seat seat1 = new Seat();
                seat1.setSeatPosition(String.format("%02d",i)+"A");
                seat1.setSeatType(seatType);
                seat1.setCarriageSeat(carriageSeat);
                seatDao.save(seat1);
                Seat seat2 = new Seat();
                seat2.setCarriageSeat(carriageSeat);
                seat2.setSeatPosition(String.format("%02d",i)+"B");
                seat2.setSeatType(seatType);
                seatDao.save(seat2);
                Seat seat3 = new Seat();
                seat3.setSeatPosition(String.format("%02d",i)+"C");
                seat3.setSeatType(seatType);
                seat3.setCarriageSeat(carriageSeat);
                seatDao.save(seat3);
                Seat seat4 = new Seat();
                seat4.setSeatPosition(String.format("%02d",i)+"D");
                seat4.setSeatType(seatType);
                seat4.setCarriageSeat(carriageSeat);
                seatDao.save(seat4);
                Seat seat5 = new Seat();
                seat5.setCarriageSeat(carriageSeat);
                seat5.setSeatPosition(String.format("%02d",i)+"F");
                seat5.setSeatType(seatType);
                seatDao.save(seat5);
            }
        }else if(sp[0].equalsIgnoreCase("10")){
            for(int i=0;i<10;i++){
                Seat seat = new Seat();
                seat.setCarriageSeat(carriageSeat);
                seat.setSeatPosition("无座位");
                seat.setSeatType(seatType);
                seatDao.save(seat);
            }
        }else if(sp[0].equalsIgnoreCase("11")){
            for(int i=0;i<20;i++){
                Seat seat = new Seat();
                seat.setCarriageSeat(carriageSeat);
                seat.setSeatPosition("无座位");
                seat.setSeatType(seatType);
                seatDao.save(seat);
            }
        }else if(sp[0].equalsIgnoreCase("12")){
            for(int i=0;i<40;i++){
                Seat seat = new Seat();
                seat.setCarriageSeat(carriageSeat);
                seat.setSeatPosition("无座位");
                seat.setSeatType(seatType);
                seatDao.save(seat);
            }
        }else if(sp[0].equalsIgnoreCase("13")){
            for(int i=0;i<60;i++){
                Seat seat = new Seat();
                seat.setCarriageSeat(carriageSeat);
                seat.setSeatPosition("无座位");
                seat.setSeatType(seatType);
                seatDao.save(seat);
            }
        }


    }


    public static void insertToStation(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> stationNames = new ArrayList<String>();
        while(true){
            if(str.contains("#"))
                break;;
            String[] sp = str.split(" ");
            String[] stations = sp[1].split("-");
            for (int i=0;i<stations.length;i++){
                if(!stationNames.contains(stations[i])){
                    stationNames.add(stations[i]);
                }
            }
            str = sc.nextLine();
        }
        ArrayList<String> cityNames = new ArrayList<String>();
        CityDao cityDao = new CityDaoImpl();
        for(int i=0;i<stationNames.size();i++){
            String name= stationNames.get(i);
            if(name.length()>2&&(name.endsWith("东")||name.endsWith("西")||name.endsWith("南")||name.endsWith("北"))){
                name = name.substring(0,name.length()-1);
            }else if(name.endsWith("虹桥")){
                name = name.substring(0,name.length()-2);
            }
            cityNames.add(name);
        }
        for(int i=0;i<stationNames.size();i++){
            Station station = new Station();
            City city = new CityDaoImpl().getCityByHql("from City city where cityName='"+cityNames.get(i)+"'").get(0);
            station.setCity(city);
            station.setStationAddress("");
            station.setStationName(stationNames.get(i));
            station.setStationStatus(true);
            StationDao stationDao = new StationDaoImpl();
            stationDao.save(station);
//            station.setCity();
        }
    }
}
