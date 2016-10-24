package zxy.mysql.homework1.dao.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.TrainNoDao;
import zxy.mysql.homework1.model.Train;
import zxy.mysql.homework1.model.TrainNo;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class TrainNoDaoImpl implements TrainNoDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public TrainNo getTrainNoById(int id) {
        TrainNo trainNo = (TrainNo)baseDao.loadByIntId(TrainNo.class,id);
        return trainNo;
    }

    public TrainNo getTrainNoByName(String trainName) {
        Session session = baseDao.getSession();
        String hql = "from TrainNo trainNo where trainNo.trainNoName='"+trainName+"'";
        Query query = session.createQuery(hql);
        List<TrainNo> trainNos = query.list();
        if(trainNos.size()>0)
            return trainNos.get(0);
        return null;
    }

    public List<TrainNo> getTrainNoByHql(String hql) {
        List<TrainNo> trainNos = (List<TrainNo>) baseDao.findAllByHQL(hql);
        return trainNos;
    }

    public void save(TrainNo trainNo) {
        baseDao.save(trainNo);
    }
}
