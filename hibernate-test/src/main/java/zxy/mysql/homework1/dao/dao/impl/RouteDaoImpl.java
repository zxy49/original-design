package zxy.mysql.homework1.dao.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.RouteDao;
import zxy.mysql.homework1.model.Route;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class RouteDaoImpl implements RouteDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public Route getRouteById(int id) {
        Route route = (Route) baseDao.loadByIntId(Route.class,id);
        return route;
    }

    public Route getRouteByRouteName(String routeName) {
        Session session = baseDao.getSession();
        String hql = "from Route route where route.routeDesc='"+routeName+"'";
        Transaction ts = session.getTransaction();
        ts.begin();
        Query query = session.createQuery(hql);
        List<Route> routes = query.list();
        ts.commit();
        if(routes.size()>0)
            return routes.get(0);
        return null;
    }

    public List<Route> getAllRouteByHql(String hql) {
        List<Route> routes = (List<Route>)baseDao.findAllByHQL(hql);
        return routes;
    }

    public Route getLastRouteByRouteName(String routeName) {
        Session session = baseDao.getSession();
        String hql = "from Route route where route.routeDesc='"+routeName+"'";
        Transaction ts = session.getTransaction();
        ts.begin();
        Query query = session.createQuery(hql);
        List<Route> routes = query.list();
        ts.commit();
        if(routes.size()>0)
            return routes.get(routes.size()-1);
        return null;
    }

    public void save(Route route) {
        baseDao.save(route);
    }
}
