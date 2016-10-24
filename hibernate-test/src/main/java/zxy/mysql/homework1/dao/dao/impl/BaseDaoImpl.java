package zxy.mysql.homework1.dao.dao.impl;

import org.hibernate.*;
import zxy.mysql.homework1.HibernateUtil;
import zxy.mysql.homework1.dao.BaseDao;

import java.util.List;

/**
 * Created by zxy on 2016/10/18.
 */
public class BaseDaoImpl implements BaseDao {

    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    /*
         Session相关
         */
    // getCurrentSession 会自动关闭session, 使用的是当前的session事务
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    // openSession 需要手动关闭session, 该方法直接重新打开一个新的session
    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }
    /*
         HQL语句相关查询
         */
    public List getAllListByHQL(Class c) {
        String hql="from "+c.getName();
        Session session = getSession();
        return session.createQuery(hql).list();
    }

    public int getCount(String hql) {
        Session session = getSession();
        Long count = (Long)session.createQuery(hql).uniqueResult();
        return count!= null ? count.intValue():0;
    }

    public List findLimitedObjByHQL(String hql, int start, int num) {
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(num);
        List list = query.list();
        return list;
    }

    public List findAllByHQL(String hql) {
        Session session = getSession();
        Query query = session.createQuery(hql);
        List list = query.list();
        return list;
    }

    public Object loadByStringId(Class c, String id) {
        Session session = getSession();
        Object obj = session.get(c,id);
        return obj;
    }

    public Object loadByLongId(Class c, Long id) {
        Session session = getSession();
        Object obj = session.get(c,id);
        return obj;
    }

    public Object loadByIntId(Class c, int id) {
        Session session = getSession();
        Object obj = session.get(c,id);
        return obj;
    }

    public List findLimitedObj(Class c, int start, int num) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(c);
        criteria.setFirstResult(start);
        criteria.setMaxResults(num);
        List list = criteria.list();
        return list;
    }

    public List getAllList(Class c) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(c);
        List list = criteria.list();
        return list;
    }

    public int getTotalCount(Class c) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(c);
        int size = criteria.list().size();
        return size;
    }

    public void save(Object bean) {
        Session session = getSession();
        session.save(bean);
    }

    public void update(Object bean) {
        Session session = getSession();
        session.update(bean);
    }

    public void delete(Object bean) {
        Session session = getSession();
        session.delete(bean);
    }

    public void delete(Class c, String id) {
        Session session = getSession();
        Object obj = session.get(c,id);
        session.delete(obj);
    }

    public void delete(Class c, String[] ids) {
        Session session = getSession();
        for(String id:ids){
            Object obj = session.get(c,id);
            if(obj!=null){
                session.delete(obj);
            }
        }
    }
}
