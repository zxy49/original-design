package zxy.mysql.homework1.dao.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.TrainDao;
import zxy.mysql.homework1.model.Train;

import java.util.List;

/**
 * Created by zxy on 2016/10/18.
 */
public class TrainDaoImpl implements TrainDao{
    private BaseDao baseDao = new BaseDaoImpl();

    public Train getTrainById(int id){
        Train train=(Train)baseDao.loadByIntId(Train.class,id);
        return train;
    }

    public List<Train> getAllTrainByHql(String hql){
        List<Train> trains = (List<Train>)baseDao.findAllByHQL(hql);
        return trains;
    }

    public Train getTrainByName(String trainName) {
        Session session = baseDao.getSession();
        Criteria criteria = session.createCriteria(Train.class).add(Restrictions.eq("train_name",trainName));
        @SuppressWarnings("unchecked")
        List<Train> results = (List<Train>)criteria.list();
        if(results.size()>0){
            return results.get(0);
        }
        return null;
    }

    public void save(Train train) {
        baseDao.save(train);
    }
}
