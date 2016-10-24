package zxy.mysql.homework1.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by zxy on 2016/10/18.
 */
public interface BaseDao {
    //获取Session
    public Session getSession();
    public Session getNewSession();
    public void flush();
    public void clear();

    /** 增删改查，通过hql语句实现*/
    public List getAllListByHQL(Class c);

    //根据hql语句来找数量
    public int getCount(String hql);

    //根据hql语句找到从start个开始的num个对象
    public List findLimitedObjByHQL(String hql,int start,int num);

    //执行hql语句并返回查询对象
    public List findAllByHQL(String hql);

    //根据id取对象
    public Object loadByStringId(Class c,String id);

    public Object loadByLongId(Class c,Long id);

    public Object loadByIntId(Class c,int id);

    //从列表中取出从start个开始的num个对象
    public List findLimitedObj(Class c,int start ,int num);

    //获取所有的对象的列表
    public List getAllList(Class c);

    //获取所有的对象的个数
    public int getTotalCount(Class c);

    public void save(Object bean);

    public void update(Object bean);

    public void delete(Object bean);

    public void delete(Class c,String id);

    public void delete(Class c,String[] ids);
}
