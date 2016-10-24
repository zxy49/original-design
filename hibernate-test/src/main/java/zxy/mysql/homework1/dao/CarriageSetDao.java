package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Carriage;
import zxy.mysql.homework1.model.CarriageSet;

import java.util.List;
import java.util.Set;

/**
 * Created by zxy on 2016/10/23.
 */
public interface CarriageSetDao {
    public CarriageSet getCarriageSetById(int id);
    public List<CarriageSet> getCarriageSetByHql(String hql);
    public void save(CarriageSet carriageSet);
}
