package zxy.mysql.homework1.model;



import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="route")
public class Route {
    private int routeId;
    private String routeDesc;
    private boolean routeStatus;
    private Set<TrainNo> trainNos;
    private List<DockingStation> dockingStations;
    @OneToMany(mappedBy = "route")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<TrainNo> getTrainNos() {
        return trainNos;
    }

    public void setTrainNos(Set<TrainNo> trainNos) {
        this.trainNos = trainNos;
    }
    @OneToMany(mappedBy = "route")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<DockingStation> getDockingStations() {
        return dockingStations;
    }

    public void setDockingStations(List<DockingStation> dockingStations) {
        this.dockingStations = dockingStations;
    }

    @Id
    @Column(name="route_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Column(name="route_desc",nullable = false)
    public String getRouteDesc() {
        return routeDesc;
    }

    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    @Column(name="route_status",length=1,columnDefinition = "boolean default true")
    public boolean getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(boolean routeStatus) {
        this.routeStatus = routeStatus;
    }

}
