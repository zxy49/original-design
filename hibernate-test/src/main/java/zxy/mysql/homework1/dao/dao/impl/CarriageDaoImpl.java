package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.CarriageDao;
import zxy.mysql.homework1.model.Carriage;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class CarriageDaoImpl implements CarriageDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public Carriage getCarriageById(int id) {
        Carriage carriage = (Carriage) baseDao.loadByIntId(Carriage.class,id);
        return carriage;
    }

    public List<Carriage> getCarriageByHql(String hql) {
        List<Carriage> carriages = (List<Carriage>)baseDao.findAllByHQL(hql);
        return carriages;
    }

    public void save(Carriage carriage) {
        baseDao.save(carriage);
    }

}
