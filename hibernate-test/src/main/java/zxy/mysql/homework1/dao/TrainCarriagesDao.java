package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.TrainCarriages;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface TrainCarriagesDao {
    public TrainCarriages getTrainCarriageById(int id);
    public List<TrainCarriages> getTrainCarriageByHql(String hql);
    public void save(TrainCarriages trainCarriages);
}
