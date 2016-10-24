package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.CarriageTypeDao;
import zxy.mysql.homework1.model.CarriageType;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class CarriageTypeDaoImpl implements CarriageTypeDao {
    private BaseDao baseDao = new BaseDaoImpl();
    public CarriageType getCarriageTypeById(int id) {
        CarriageType carriageType = (CarriageType) baseDao.loadByIntId(CarriageType.class,id);
        return carriageType;
    }

    public List<CarriageType> getCarriageTypeByHQL(String hql) {
        List<CarriageType> carriageTypes = (List<CarriageType>)baseDao.findAllByHQL(hql);
        return carriageTypes;
    }

    public void save(CarriageType carriageType) {
        baseDao.save(carriageType);
    }
}
