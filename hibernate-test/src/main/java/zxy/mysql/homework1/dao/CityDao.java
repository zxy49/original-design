package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.City;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface CityDao {
    public City getCityById(int id);
    public List<City> getCityByHql(String hql);
    public void save(City city);
}
