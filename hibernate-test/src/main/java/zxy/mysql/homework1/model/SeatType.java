package zxy.mysql.homework1.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zxy on 2016/10/19.
 */
@Entity
@Table(name="seat_type")
public class SeatType {
    private int seatTypeId;
    private String seatTypeNmae;
    private String SeatTypeDes;
    private Set<Seat> seats;
    @Id
    @Column(name="seat_type_id")
    @GeneratedValue
    public int getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(int seatTypeId) {
        this.seatTypeId = seatTypeId;
    }
    @Column(name="seat_type_name",length=20,nullable = false)
    public String getSeatTypeNmae() {
        return seatTypeNmae;
    }

    public void setSeatTypeNmae(String seatTypeNmae) {
        this.seatTypeNmae = seatTypeNmae;
    }
    @Column(name="seat_type_des")
    public String getSeatTypeDes() {
        return SeatTypeDes;
    }

    public void setSeatTypeDes(String seatTypeDes) {
        SeatTypeDes = seatTypeDes;
    }
    @OneToMany(mappedBy = "seatType")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }
}
