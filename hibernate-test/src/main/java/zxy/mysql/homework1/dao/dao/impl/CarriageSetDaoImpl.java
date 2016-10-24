package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.CarriageSetDao;
import zxy.mysql.homework1.model.Carriage;
import zxy.mysql.homework1.model.CarriageSet;

import java.util.List;
import java.util.Set;

/**
 * Created by zxy on 2016/10/23.
 */
public class CarriageSetDaoImpl implements CarriageSetDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public CarriageSet getCarriageSetById(int id) {
        CarriageSet carriageSet = (CarriageSet)baseDao.loadByIntId(CarriageSet.class,id);
        return carriageSet;
    }

    public List<CarriageSet> getCarriageSetByHql(String hql) {
        List<CarriageSet> carriageSets = (List<CarriageSet>)baseDao.findAllByHQL(hql);
        return carriageSets;
    }

    public void save(CarriageSet carriageSet) {
        baseDao.save(carriageSet);
    }
}
