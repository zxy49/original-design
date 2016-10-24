package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.DockingStationDao;
import zxy.mysql.homework1.model.DockingStation;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class DockingStationDaoImpl implements DockingStationDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public DockingStation getDockingStationById(int id) {
        DockingStation dockingStation = (DockingStation) baseDao.loadByIntId(DockingStation.class,id);
        return  dockingStation;
    }

    public List<DockingStation> getDockingStationByHql(String hql) {
        List<DockingStation> dockingStations = (List<DockingStation>)baseDao.findAllByHQL(hql);
        return dockingStations;
    }

    public void save(DockingStation dockingStation) {
        baseDao.save(dockingStation);
    }
}
