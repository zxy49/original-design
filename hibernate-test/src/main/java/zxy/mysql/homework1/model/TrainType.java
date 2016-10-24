package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zxy on 2016/10/20.
 */
@Entity
@Table(name="train_type")
public class TrainType {
    private int trainTypeId;
    private String trainTypeName;
    private String trainTypeDesc;
    private Set<Train> trains;
    @Id
    @Column(name="train_type_id")
    @GeneratedValue
    public int getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(int trainTypeId) {
        this.trainTypeId = trainTypeId;
    }
    @Column(name="train_type_name",nullable = false)
    public String getTrainTypeName() {
        return trainTypeName;
    }

    public void setTrainTypeName(String trainTypeName) {
        this.trainTypeName = trainTypeName;
    }
    @Column(name="train_type_desc")
    public String getTrainTypeDesc() {
        return trainTypeDesc;
    }

    public void setTrainTypeDesc(String trainTypeDesc) {
        this.trainTypeDesc = trainTypeDesc;
    }
    @OneToMany(mappedBy = "trainType")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Train> getTrains() {
        return trains;
    }

    public void setTrains(Set<Train> trains) {
        this.trains = trains;
    }
}
