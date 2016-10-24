package zxy.mysql.homework1.model;



import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by zxy on 2016/10/19.
 */
@Entity
@Table(name="train_carriages")
public class TrainCarriages implements Serializable{//表示默认的列车和车厢组合
    private static final long serialVersionUID = 1L;
    private int trainCarriagesId;
    private Train train;
    private Set<CarriageSet> carriageSets;
    private Set<RunChart> runCharts;
    @OneToMany(mappedBy="trainCarriages")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<RunChart> getRunChartTrains() {
        return runCharts;
    }

    public void setRunChartTrains(Set<RunChart> runCharts) {
        this.runCharts = runCharts;
    }

    @Id
    @Column(name="train_carriages_id",length=11)
    public int getTrainCarriagesId() {
        return trainCarriagesId;
    }

    public void setTrainCarriagesId(int trainCarriagesId) {
        this.trainCarriagesId = trainCarriagesId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="train_id",nullable = false)
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="train_carriageset_map",joinColumns = {@JoinColumn(name="train_carriages_id")},inverseJoinColumns = {@JoinColumn(name="carriage_set_id")})
    public Set<CarriageSet> getCarriageSets() {
        return carriageSets;
    }

    public void setCarriageSets(Set<CarriageSet> carriageSets) {
        this.carriageSets = carriageSets;
    }
}
