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
@Table(name="station")
public class Station {
    private int stationId;
    private String stationName;
    private String stationAddress;
    private boolean stationStatus;
    private City city;
    private Set<TicketPrice> ticketPrices;
    private Set<DockingStation> dockingStations;
    private List<LeftSeat> leftSeatList;
    private List<IntervalSeat> intervalSeats;
    @OneToMany(mappedBy = "station",fetch = FetchType.EAGER)
    public Set<DockingStation> getDockingStations() {
        return dockingStations;
    }

    public void setDockingStations(Set<DockingStation> dockingStations) {
        this.dockingStations = dockingStations;
    }
//    private int cityId;
    @Id
    @Column(name="station_id",length=11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Column(name="station_name",length=20,nullable = false)
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Column(name="station_address",length=255, nullable = false)
    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    @Column(name="station_status",length=1,columnDefinition = "boolean default true")
    public boolean isStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(boolean stationStatus) {
        this.stationStatus = stationStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id", nullable = false)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    @OneToMany(mappedBy = "startStation")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<TicketPrice> getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(Set<TicketPrice> ticketPrices) {
        this.ticketPrices = ticketPrices;
    }
    @OneToMany(mappedBy="from")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<LeftSeat> getLeftSeatList() {
        return leftSeatList;
    }

    public void setLeftSeatList(List<LeftSeat> leftSeatList) {
        this.leftSeatList = leftSeatList;
    }
    @OneToMany(mappedBy= "fromSta")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<IntervalSeat> getIntervalSeats() {
        return intervalSeats;
    }

    public void setIntervalSeats(List<IntervalSeat> intervalSeats) {
        this.intervalSeats = intervalSeats;
    }
}
