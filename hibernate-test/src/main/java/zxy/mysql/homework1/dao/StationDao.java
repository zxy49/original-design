package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Station;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface StationDao {
    public Station getStationById(int id);
    public Station getStationByName(String stationName);
    public List<Station> getStationByHql(String hql);
    public void save(Station station);
}
