package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.CityDao;
import zxy.mysql.homework1.model.City;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class CityDaoImpl implements CityDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public City getCityById(int id) {
        City city = (City) baseDao.loadByIntId(City.class,id);
        return city;
    }

    public List<City> getCityByHql(String hql) {
        List<City> cities = (List<City>)baseDao.findAllByHQL(hql);
        return cities;
    }

    public void save(City city) {
        baseDao.save(city);
    }
}
