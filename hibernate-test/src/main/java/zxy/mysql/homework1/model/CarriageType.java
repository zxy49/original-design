package zxy.mysql.homework1.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zxy on 2016/10/19.
 */
@Entity
@Table(name="carriage_type")
public class CarriageType
{
    private int carriageTypeId;
    private String carriageTypeName;
    private Set<Carriage> carriages;
    @Id
    @Column(name="carriage_type_id")
    @GeneratedValue
    public int getCarriageTypeId() {
        return carriageTypeId;
    }

    public void setCarriageTypeId(int carriageTypeId) {
        this.carriageTypeId = carriageTypeId;
    }
    @Column(name="carriage_type_name",nullable = false)
    public String getCarriageTypeName() {
        return carriageTypeName;
    }

    public void setCarriageTypeName(String carriageTypeName) {
        this.carriageTypeName = carriageTypeName;
    }
    @OneToMany(mappedBy = "carriageType")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }



}
