package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.TrainType;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public interface TrainTypeDao {
    public TrainType getTrainTypeById(int id);
    public List<TrainType> getTrainTypeByHql(String hql);
    public void save(TrainType trainType);
}
