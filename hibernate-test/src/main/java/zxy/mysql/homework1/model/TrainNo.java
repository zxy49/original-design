package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="train_no")
public class TrainNo {
    private int trainNoId;
    private String trainNoName;
    private Route route;
    private Set<RunChart> runCharts;
    private boolean trainNoStatus;
    private Set<TicketPrice> ticketPrices;

    @Id
    @Column(name="train_no_id",length=5)
    @GeneratedValue
    public int getTrainNoId() {
        return trainNoId;
    }

    public void setTrainNoId(int train_no_id) {
        this.trainNoId = train_no_id;
    }
    @Column(name="train_no_name")
    public String getTrainNoName() {
        return trainNoName;
    }

    public void setTrainNoName(String train_no_name) {
        this.trainNoName = train_no_name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="route_id")
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
    @OneToMany(mappedBy = "trainNo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<RunChart> getRunCharts() {
        return runCharts;
    }

    public void setRunCharts(Set<RunChart> runCharts) {
        this.runCharts = runCharts;
    }

    @Column(name="train_no_status",columnDefinition = "boolean default true")
    public boolean isTrainNoStatus() {
        return trainNoStatus;
    }

    public void setTrainNoStatus(boolean train_no_status) {
        this.trainNoStatus = train_no_status;
    }
    @OneToMany(mappedBy = "trainNo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<TicketPrice> getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(Set<TicketPrice> ticketPrices) {
        this.ticketPrices = ticketPrices;
    }
}
