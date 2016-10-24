package zxy.mysql.homework1.dao.dao.impl;

import org.hibernate.Query;
import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.StationDao;
import zxy.mysql.homework1.model.Station;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class StationDaoImpl implements StationDao {
    private BaseDao baseDao = new BaseDaoImpl();

    public Station getStationById(int id) {
        Station station = (Station) baseDao.loadByIntId(Station.class, id);
        return station;
    }

    public List<Station> getStationByHql(String hql) {
        List<Station> stations = (List<Station>) baseDao.findAllByHQL(hql);
        return stations;
    }

    public Station getStationByName(String stationName) {
        String hql = "from Station station where station.stationName='" + stationName + "'";
        List<Station> stations = (List<Station>) baseDao.findAllByHQL(hql);
        if (stations.size() > 0)
            return stations.get(0);
        else
            return null;
    }

    public void save(Station station) {
        baseDao.save(station);
    }
}
