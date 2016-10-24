package zxy.mysql.homework1.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

/**
 * Created by zxy on 2016/10/23.
 */
@Entity
@Table(name="carriage_set")
public class CarriageSet {
    private int carriageSetId;
    private Carriage carriage;
    private int carriageNo;//in one runchart-train
    private String carriageSetDesc;
    private Set<TrainCarriages> trainCarriages;

    @Id
    @Column(name="carriage_set_id")
    @GeneratedValue
    public int getCarriageSetId() {
        return carriageSetId;
    }

    public void setCarriageSetId(int carriageSetId) {
        this.carriageSetId = carriageSetId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carriage_id",nullable=false)
    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }
    @Column(name="carriage_no",nullable = false)
    public int getCarriageNo() {
        return carriageNo;
    }

    public void setCarriageNo(int carriageNo) {
        this.carriageNo = carriageNo;
    }
    @Column(name="carriage_set_desc",nullable = false)
    public String getCarriageSetDesc() {
        return carriageSetDesc;
    }

    public void setCarriageSetDesc(String carriageSetDesc) {
        this.carriageSetDesc = carriageSetDesc;
    }

    @ManyToMany(mappedBy = "carriageSets")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<TrainCarriages> getTrainCarriages() {
        return trainCarriages;
    }

    public void setTrainCarriages(Set<TrainCarriages> trainCarriages) {
        this.trainCarriages = trainCarriages;
    }
}
