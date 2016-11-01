package zxy.mysql.homework1.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
@Entity
@Table(name="runchart_seat")
public class RunChartSeat {
    private int runChartSeatId;
    private RunChart runChart;
    private String seatType;
    private String seatDesc;
    private List<IntervalSeat> intervalSeats;
//    private boolean isTaken;
    @Id
    @Column(name="run_chart_seat_id")
    @GeneratedValue
    public int getRunChartSeatId() {
        return runChartSeatId;
    }

    public void setRunChartSeatId(int runChartSeatId) {
        this.runChartSeatId = runChartSeatId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="run_chart_id",nullable = false)
    public RunChart getRunChart() {
        return runChart;
    }

    public void setRunChart(RunChart runChart) {
        this.runChart = runChart;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    @Column(name="seat_description",nullable = false)
    public String getSeatDesc() {
        return seatDesc;
    }

    public void setSeatDesc(String seatDesc) {
        this.seatDesc = seatDesc;
    }
    @OneToMany(mappedBy = "runChartSeat")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<IntervalSeat> getIntervalSeats() {
        return intervalSeats;
    }

    public void setIntervalSeats(List<IntervalSeat> intervalSeats) {
        this.intervalSeats = intervalSeats;
    }
    //    @Column(name="seat_is_taken",length=1,columnDefinition = "boolean default true",nullable = false)
//    public boolean isTaken() {
//        return isTaken;
//    }
//
//    public void setTaken(boolean taken) {
//        isTaken = taken;
//    }
}
