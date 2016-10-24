package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.CarriageType;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface CarriageTypeDao {
    public CarriageType getCarriageTypeById(int id);
    public List<CarriageType> getCarriageTypeByHQL(String hql);
    public void save(CarriageType carriageType);
}
