package zxy.mysql.homework1.model;

import javax.persistence.*;

/**
 * Created by zxy on 2016/10/19.
 */
@Entity
@Table(name="seat")
public class Seat {
    private int seatId;
    private SeatType seatType;
//    private int seatRow;
//    private String seatColumn;
    private String seatPosition;
    private CarriageSeat carriageSeat;



    @Id
    @Column(name="seat_id")
    @GeneratedValue
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seat_type_id",nullable = false)
    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

//    @Column(name="seat_row",length = 11,nullable = false)
//    public int getSeatRow() {
//        return seatRow;
//    }
//
//    public void setSeatRow(int seatRow) {
//        this.seatRow = seatRow;
//    }
//    @Column(name="seat_column",length = 11,nullable = false)
//    public String getSeatColumn() {
//        return seatColumn;
//    }
//
//    public void setSeatColumn(String seatColumn) {
//        this.seatColumn = seatColumn;
//    }

    @Column(name="seat_positon",length=20,nullable = false)
    public String getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(String seatPosition) {
        this.seatPosition = seatPosition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="carriage_seat_id")
    public CarriageSeat getCarriageSeat() {
        return carriageSeat;
    }

    public void setCarriageSeat(CarriageSeat carriageSeat) {
        this.carriageSeat = carriageSeat;
    }
}
