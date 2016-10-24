package zxy.mysql.homework1.dao.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.RailDao;
import zxy.mysql.homework1.model.Rail;
import zxy.mysql.homework1.model.Seat;
import zxy.mysql.homework1.model.Train;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public class RailDaoImpl implements RailDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public Rail getRailById(int id) {
        Rail rail = (Rail)baseDao.loadByIntId(Rail.class,id);
        return rail;
    }

    public Rail getRailByName(String railName) {
        Session session = baseDao.getSession();
        Criteria criteria = session.createCriteria(Rail.class).add(Restrictions.eq("rail_name",railName));
        List<Rail> rails = (List<Rail>)criteria.list();
//        String hql = "from Rail rail where rail.rail_name='"+railName+"'";
//        Transaction ts = session.getTransaction();
//        ts.begin();
//        Query qurey = session.createQuery(hql);
//        List<Rail> rails = qurey.list();
//        ts.commit();
        if(rails.size()>0){
            return rails.get(0);
        }
        return null;
    }

    public void save(Rail rail) {
        baseDao.save(rail);
    }
}
