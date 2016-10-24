package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.CarriageSeatDao;
import zxy.mysql.homework1.model.CarriageSeat;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class CarriageSeatDaoImpl implements CarriageSeatDao {
    private BaseDao baseDao = new BaseDaoImpl();
    public CarriageSeat getCarriageSeatById(int id) {
        CarriageSeat carriageSeat = (CarriageSeat)baseDao.loadByIntId(CarriageSeat.class,id);
        return carriageSeat;
    }

    public List<CarriageSeat> getCarriageSeatByHql(String hql) {
        List<CarriageSeat> carriageSeats = (List<CarriageSeat>) baseDao.findAllByHQL(hql);
        return carriageSeats;
    }

    public void save(CarriageSeat carriageSeat) {
        baseDao.save(carriageSeat);
    }
}
