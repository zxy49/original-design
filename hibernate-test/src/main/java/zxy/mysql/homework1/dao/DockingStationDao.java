package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.DockingStation;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface DockingStationDao {
    public DockingStation getDockingStationById(int id);
    public List<DockingStation> getDockingStationByHql(String hql);
    public void save(DockingStation dockingStation);
}
