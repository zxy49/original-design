package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.TrainCarriagesDao;
import zxy.mysql.homework1.model.TrainCarriages;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class TrainCarriagesDaoImpl implements TrainCarriagesDao {
    private BaseDao baseDao = new BaseDaoImpl();
    public TrainCarriages getTrainCarriageById(int id) {
        TrainCarriages trainCarriages = (TrainCarriages) baseDao.loadByIntId(TrainCarriages.class,id);
        return trainCarriages;
    }

    public List<TrainCarriages> getTrainCarriageByHql(String hql) {
        List<TrainCarriages> trainCarriages = (List<TrainCarriages>)baseDao.findAllByHQL(hql);
        return trainCarriages;
    }

    public void save(TrainCarriages trainCarriages) {
        baseDao.save(trainCarriages);
    }
}
