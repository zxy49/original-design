package zxy.mysql.homework1.test;

import org.hibernate.Transaction;
import zxy.mysql.homework1.dao.*;
import zxy.mysql.homework1.dao.dao.impl.*;
import zxy.mysql.homework1.model.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by zxy on 2016/10/18.
 */
public class Test_Insert {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        RunChartDao runChartDao = new RunChartDaoImpl();
        IntervalSeatDao intervalSeatDao = new IntervalSeatDaoImpl();
        for (int z = 0; z < 28; z++) {
            Transaction transaction = new BaseDaoImpl().getSession().getTransaction();
            transaction.begin();
            int sp = Integer.parseInt(str.split(" ")[1]);
            RunChart runChart = runChartDao.getRunChartById(sp);

            List<RunChartSeat> runChartSeats = runChart.getRunChartSeats();
            TrainNo trainNo = runChart.getTrainNo();
            Route route = trainNo.getRoute();
            List<DockingStation> stations = route.getDockingStations();

            for (int h = 0; h < runChartSeats.size(); h++) {
                RunChartSeat runChartSeat = runChartSeats.get(h);
                runChartSeat.getSeatType();
                for (int j = 0; j < stations.size(); j++) {
                    DockingStation station = stations.get(j);

                    for (int k = 0; k < stations.size(); k++) {
                        if (k != j) {
                            DockingStation dStation = stations.get(k);
                            if (station.getDockingstationOrderNo() < dStation.getDockingstationOrderNo()) {
//                                System.out.println(station.getStation().getStationName()+"-"+station.getDockingstationOrderNo()+"     "+dStation.getStation().getStationName()+"-"+dStation.getDockingstationOrderNo());
                                IntervalSeat intervalSeat = new IntervalSeat();
                                intervalSeat.setFromSta(station.getStation());
                                intervalSeat.setToSta(dStation.getStation());
                                intervalSeat.setRunChart(runChart);
                                intervalSeat.setStatus(true);
                                intervalSeat.setRunChartSeat(runChartSeat);
                                intervalSeatDao.save(intervalSeat);
                            }
                        }
                    }
                }
            }
            System.out.println("runChart " + runChart.getRunChartId() + "   z=" + z + "     save finished");

        str = sc.nextLine();
        transaction.commit();
    }
        }



    }



