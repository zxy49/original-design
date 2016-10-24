package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="carriage")
public class Carriage {
    private int carriageId;
    private String carriageName;
    private int seatNum;
    private CarriageType carriageType;//假设车厢类型与座位类型一一对应
    private String createTime;
    private String validTime;
    private boolean carriageStatus;
    private Set<CarriageSet> carriageSets;
//    private Set<TrainCarriages> trainCarriages;
    private CarriageSeat carriageSeat;
//    public enum CarriageType{双层快速座车25K型,双层软座车厢25型,双层硬座车厢25型,
//            准高速单层客车车厢25K型,单层客车车厢22型,准高速客车软卧车厢25TBSP型,单层客车硬卧车厢22型,
//            行李车厢22型,餐车车厢23型,准高速客车软卧车厢25T型,新版22型硬座车厢,青藏25T型车厢,硬座车厢25G型,软座车厢22型,软卧车厢22型,单层客车硬卧车厢25K型}


    @Id
    @Column(name="carriage_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(int carriageId) {
        this.carriageId = carriageId;
    }


    @Column(name="carriage_name",length=20, nullable = false)
    public String getCarriageName(){
        return carriageName;
    }

    public void setCarriageName(String carriageName) {
        this.carriageName = carriageName;
    }



    @Column(name="seat_num", nullable = false)
    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
    @Column(name="creat_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    @Column(name="valid_time")
    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="carriage_type_id",nullable = false)
    public CarriageType getCarriageType(){
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
    }

    @Column(name="carrige_status",columnDefinition = "boolean default true",nullable = false)
    public boolean isCarriageStatus() {
        return carriageStatus;
    }

    public void setCarriageStatus(boolean carriageStatus) {
        this.carriageStatus = carriageStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carriage_seat_id",nullable = false)
    public CarriageSeat getCarriageSeat() {
        return carriageSeat;
    }

    public void setCarriageSeat(CarriageSeat carriageSeat) {
        this.carriageSeat = carriageSeat;
    }
    @OneToMany(mappedBy = "carriage")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<CarriageSet> getCarriageSets() {
        return carriageSets;
    }

    public void setCarriageSets(Set<CarriageSet> carriageSets) {
        this.carriageSets = carriageSets;
    }
}
