package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.TrainTypeDao;
import zxy.mysql.homework1.model.TrainType;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class TrainTypeDaoImpl implements TrainTypeDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public TrainType getTrainTypeById(int id) {
        TrainType trainType = (TrainType) baseDao.loadByIntId(TrainType.class,id);
        return trainType;
    }

    public List<TrainType> getTrainTypeByHql(String hql) {
        List<TrainType> trainTypes = (List<TrainType>)baseDao.findAllByHQL(hql);
        return trainTypes;
    }

    public void save(TrainType trainType) {
        baseDao.save(trainType);
    }
}
