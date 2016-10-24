package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="carriage_seat")
public class CarriageSeat {
    private int carriageSeatId;
    private String carriageSeatType;
    private Set<Carriage> carriages;
    private Set<Seat> seats;
    private int CarriageSeatNum;
    @Id
    @Column(name="carriage_seat_id")
    @GeneratedValue
    public int getCarriageSeatId() {
        return carriageSeatId;
    }

    public void setCarriageSeatId(int carriageSeatId) {
        this.carriageSeatId = carriageSeatId;
    }

    @Column(name="carriage_seat_type",length=10,nullable = false)
    public String getCarriageSeatType() {
        return carriageSeatType;
    }

    public void setCarriageSeatType(String carriageSeatType) {
        this.carriageSeatType = carriageSeatType;
    }
    @OneToMany(mappedBy = "carriageSeat")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }

    @OneToMany(mappedBy = "carriageSeat")
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OrderBy("seatId")
    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
    @Column(name="carriage_seat_num")
    public int getCarriageSeatNum() {
        return CarriageSeatNum;
    }

    public void setCarriageSeatNum(int carriageSeatNum) {
        CarriageSeatNum = carriageSeatNum;
    }


}
