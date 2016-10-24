package zxy.mysql.homework1.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="ticket_price")
public class TicketPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ticketPriceId;
    private TrainNo trainNo;
    private SeatType seatType;
    private Station startStation;
    private Station endStation;
    private String ticketPriceDes;
    private String ticketPrice;
    private boolean ticketPriceStatus;
    @Id
    @Column(name="ticket_price_id")
    @GeneratedValue
    public int getTicketPriceId() {
        return ticketPriceId;
    }

    public void setTicketPriceId(int ticketPriceId) {
        this.ticketPriceId = ticketPriceId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="train_no_id")
    public TrainNo getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(TrainNo trainNo) {
        this.trainNo = trainNo;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seat_type_id",nullable = false)
    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="start_station_id",nullable = false)
    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="end_station_id",nullable = false)
    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    @Column(name="ticket_price",nullable = false)
    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Column(name="ticket_price_des")
    public String getTicketPriceDes() {
        return ticketPriceDes;
    }

    public void setTicketPriceDes(String ticketPriceDes) {
        this.ticketPriceDes = ticketPriceDes;
    }

    public String toString(){
        String tp = "price:"+getTicketPrice()+"\nfrom:"+getStartStation().getStationName()+"\nto:"+getEndStation().getStationName()
                +"\nseatType:"+getSeatType().getSeatTypeNmae()+"\ntrainNo:"+getTrainNo().getTrainNoName();
        System.out.println(tp);
        return tp;
    }
    @Column(name="price_status")
    public boolean isTicketPriceStatus() {
        return ticketPriceStatus;
    }

    public void setTicketPriceStatus(boolean ticketPriceStatus) {
        this.ticketPriceStatus = ticketPriceStatus;
    }
}
