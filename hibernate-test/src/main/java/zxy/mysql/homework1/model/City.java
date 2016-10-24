package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
@Table(name="city")
public class City {
    private int cityId;
    private String cityName;
    private Rail rail;
//    private int cityRailId;
    private boolean cityStatus;
    private Set<Station> stations;
    @OneToMany(mappedBy = "city")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Station> getStations() {
        return stations;
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    @Id
    @Column(name="city_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Column(name="city_name",length=20,nullable = false)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rail_id")
    public Rail getRail() {
        return rail;
    }

    public void setRail(Rail rail) {
        this.rail = rail;
    }

    @Column(name="city_status",columnDefinition = "boolean default true")
    public boolean isCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(boolean cityStatus) {
        this.cityStatus = cityStatus;
    }
}
