package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.CarriageSeat;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface CarriageSeatDao {
    public CarriageSeat getCarriageSeatById(int id);
    public List<CarriageSeat> getCarriageSeatByHql(String hql);
    public void save(CarriageSeat carriageSeat);
}
