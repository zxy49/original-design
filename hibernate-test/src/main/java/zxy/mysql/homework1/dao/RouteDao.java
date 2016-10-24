package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Route;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface RouteDao {
    public Route getRouteById(int id);
    public Route getRouteByRouteName(String routeName);
    public List<Route> getAllRouteByHql(String hql);
    public Route getLastRouteByRouteName(String routeName);
    public void save(Route route);
}
