package zxy.mysql.homework1.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name = "docking_station")
public class DockingStation implements Serializable {
    private static final long serialVersionUID = 1L;
    private int dockingStationId;
    private Route route;
    private int dockingstationOrderNo;
    private Station station;
    private String arrivalTime;
    private String departureTime;
    private String stayTime;
    private String days;//天数
//    private String runTime;//运行时间
    private String mileage;//里程  ---这里考虑冗余的话把座位类型和价格也带上


    @Id
    @Column(name = "docking_station_id")
    @GeneratedValue
    public int getDockingStationId() {
        return dockingStationId;
    }

    public void setDockingStationId(int dockingStationId) {
        this.dockingStationId = dockingStationId;
    }



    @Column(name = "docking_station_order_no", length = 5, nullable = false)
    public int getDockingstationOrderNo() {
        return dockingstationOrderNo;
    }

    public void setDockingstationOrderNo(int dockingstationOrderNo) {
        this.dockingstationOrderNo = dockingstationOrderNo;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="route_id",nullable = false)
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="station_id",nullable = false)
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Column(name = "arrival_time", length = 8, nullable = false)
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Column(name = "departure_time", length = 8, nullable = false)
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Column(name = "stay_time", length = 8, nullable = false)
    public String getStayTime() {
        return stayTime;
    }

    public void setStayTime(String stayTime) {
        this.stayTime = stayTime;
    }

    @Column(name = "days", nullable = false)
    public String getDays() {
        return days;
    }

    public void setDays(String  days) {
        this.days = days;
    }

//    @Column(name = "run_time", nullable = false)
//    public String getRunTime() {
//        return runTime;
//    }
//
//    public void setRunTime(String runTime) {
//        this.runTime = runTime;
//    }

    @Column(name = "mileage", nullable = false)
    public String  getMileage() {
        return mileage;
    }

    public void setMileage(String  mileage) {
        this.mileage = mileage;
    }
    public String toString(){
        String dockingStation = "dockingStation:\n"+"routeId:"+this.getRoute().getRouteId()+"\norderNo:"+this.getDockingstationOrderNo()+"\nstationId:"+this.getStation().getStationName()+"\narrivalTime:"
                +this.getArrivalTime()+"\nstayTime:"+this.getStayTime()+"\ndepartureTime:"+this.getDepartureTime()+"\ndays:"+this.getDays()+"\nMileage:"+this.getMileage();
        System.out.println(dockingStation);
        return dockingStation;
    }
}
