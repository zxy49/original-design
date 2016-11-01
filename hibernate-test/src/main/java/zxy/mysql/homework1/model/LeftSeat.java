package zxy.mysql.homework1.model;

import javax.persistence.*;

/**
 * Created by soft on 2016/10/27.
 */
@Entity
@Table(name="left_seat")
public class LeftSeat {
    private int leftSeatId;
    private RunChart runChart;
    private Station from;
    private Station to;
    private SeatType seatType;
    private int leftNum;
    @Id
    @Column(name="left_seat_id")
    @GeneratedValue
    public int getLeftSeatId() {
        return leftSeatId;
    }

    public void setLeftSeatId(int leftSeatId) {
        this.leftSeatId = leftSeatId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="run_chart_id",nullable=false)
    public RunChart getRunChart() {
        return runChart;
    }

    public void setRunChart(RunChart runChart) {
        this.runChart = runChart;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seat_type",nullable = false)
    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="from_id",nullable = false)
    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="to_id",nullable = false)
    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }
    @Column(name="left_num",nullable = false)
    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }
}
