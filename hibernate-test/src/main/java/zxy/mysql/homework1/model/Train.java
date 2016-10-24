package zxy.mysql.homework1.model;

import javax.persistence.*;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import zxy.mysql.homework1.model.TrainType;
/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name = "train")
public class Train {
    private int train_id;
    private String train_name;
    private boolean train_status;
    private TrainType trainType;
    private Rail rail;
    private Set<TrainCarriages> trainCarriages;

//    private Set<Carriage> carriages;
//    public enum TrainType {高铁G, 动车D, 城际C, 直特Z, 特快T, 快速K, 管快N, 临时L}

    @Id
    @Column(name = "train_id")
    @GeneratedValue
    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="train_type")
    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType train_type) {
        this.trainType = train_type;
    }


    @Column(name = "train_name", length = 20, nullable = false)
    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    @Column(name = "train_status", columnDefinition = "boolean default true")
    public boolean getTrain_status() {
        return train_status;
    }

    public void setTrain_status(boolean train_status) {
        this.train_status = train_status;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_rail_id")
    public Rail getRail() {
        return rail;
    }

    public void setRail(Rail rail) {
        this.rail = rail;
    }
    @OneToMany(targetEntity=TrainCarriages.class,mappedBy = "train")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<TrainCarriages> getTrainCarriages() {
        return trainCarriages;
    }

    public void setTrainCarriages(Set<TrainCarriages> trainCarriages) {
        this.trainCarriages = trainCarriages;
    }

}
