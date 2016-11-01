package zxy.mysql.homework1.model;

import javax.persistence.*;

/**
 * Created by soft on 2016/10/27.
 */
@Entity
@Table(name="interval_seat")
public class IntervalSeat {
    private int intervalSeatId;
    private RunChart runChart;
    private RunChartSeat runChartSeat;
    private Station fromSta;
    private Station toSta;
    private boolean status;
    @Id
    @Column(name="interval_seat")
    @GeneratedValue
    public int getIntervalSeatId() {
        return intervalSeatId;
    }

    public void setIntervalSeatId(int intervalSeatId) {
        this.intervalSeatId = intervalSeatId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="run_chart_id",nullable = false)
    public RunChart getRunChart() {
        return runChart;
    }

    public void setRunChart(RunChart runChart) {
        this.runChart = runChart;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="run_chart_seat_id",nullable = false)
    public RunChartSeat getRunChartSeat() {
        return runChartSeat;
    }

    public void setRunChartSeat(RunChartSeat runChartSeat) {
        this.runChartSeat = runChartSeat;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="from_id",nullable = false)
    public Station getFromSta() {
        return fromSta;
    }

    public void setFromSta(Station from) {
        this.fromSta = from;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="to_id",nullable = false)
    public Station getToSta() {
        return toSta;
    }

    public void setToSta(Station to) {
        this.toSta = to;
    }
    @Column(name="seat_status",nullable = false,columnDefinition = "boolean default true")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
