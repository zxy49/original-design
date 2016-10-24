package zxy.mysql.homework1.model;



import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by soft on 2016/10/17.
 */
@Entity
public class Rail {
    private int rail_id;
    private String rail_name;
    private String rail_type;
    private String rail_address;
    private String rail_tel;
    private Set<City> cities;
    private Set<Train> trains;
    @OneToMany(mappedBy = "rail",fetch = FetchType.EAGER)
    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Id
    @Column(name="rail_id",length=5)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRail_id() {
        return rail_id;
    }

    public void setRail_id(int rail_id) {
        this.rail_id = rail_id;
    }

    @Column(name="rail_name",length=20,nullable = false)
    public String getRail_name() {
        return rail_name;
    }

    public void setRail_name(String rail_name) {
        this.rail_name = rail_name;
    }

    @Column(name="rail_type",length=20)
    public String getRail_type() {
        return rail_type;
    }

    public void setRail_tel(String rail_tel) {
        this.rail_tel = rail_tel;
    }

    @Column(name="rail_address",length=255)
    public String getRail_address() {
        return rail_address;
    }

    public void setRail_address(String rail_address) {
        this.rail_address = rail_address;
    }

    @Column(name="rail_tel",length=20)
    public String getRail_tel() {
        return rail_tel;
    }

    public void setRail_type(String rail_type) {
        this.rail_type = rail_type;
    }
    @OneToMany(mappedBy = "rail")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Train> getTrains() {
        return trains;
    }

    public void setTrains(Set<Train> trains) {
        this.trains = trains;
    }
}
