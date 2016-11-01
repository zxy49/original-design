package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="runchart")
public class RunChart {
    private int runChartId;
    private TrainNo trainNo;
    private Date runChartRunTime;
    private boolean runChartStatus;
    private TrainCarriages trainCarriages;
    private List<RunChartSeat> runChartSeats;
    private List<IntervalSeat> intervalSeats;
    private List<LeftSeat> leftSeatList;


    @OneToMany(mappedBy = "runChart")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<IntervalSeat> getIntervalSeats() {
        return intervalSeats;
    }

    public void setIntervalSeats(List<IntervalSeat> intervalSeats) {
        this.intervalSeats = intervalSeats;
    }

    @OneToMany(mappedBy = "runChart",fetch = FetchType.LAZY)
    public List<RunChartSeat> getRunChartSeats() {
        return runChartSeats;
    }

    public void setRunChartSeats(List<RunChartSeat> runChartSeats) {
        this.runChartSeats = runChartSeats;
    }

    @Id
    @Column(name="runchart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRunChartId() {
        return runChartId;
    }

    public void setRunChartId(int runChartId) {
        this.runChartId = runChartId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="train_no_id", nullable = false)
    public TrainNo getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(TrainNo trainNo) {
        this.trainNo = trainNo;
    }

    @Column(name="runchart_runtime",nullable = false)
    public Date getRunChartRunTime(){
        return runChartRunTime;
    }

    public void setRunChartRunTime(Date runChartRunTime) {
        this.runChartRunTime = runChartRunTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="train_carriages_id",nullable = false)
    public TrainCarriages getTrainCarriages() {
        return trainCarriages;
    }

    public void setTrainCarriages(TrainCarriages trainCarriages) {
        this.trainCarriages = trainCarriages;
    }

    @Column(name="runchart_status",columnDefinition = "boolean default true",nullable = false)
    public boolean isRunChartStatus() {
        return runChartStatus;
    }

    public void setRunChartStatus(boolean runChartStatus) {
        this.runChartStatus = runChartStatus;
    }

    @OneToMany(mappedBy = "runChart")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<LeftSeat> getLeftSeatList() {
        return leftSeatList;
    }

    public void setLeftSeatList(List<LeftSeat> leftSeats) {
        this.leftSeatList = leftSeats;
    }
}
