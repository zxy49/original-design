package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.TrainNo;

import java.util.List;

/**
 * Created by zxy on 2016/10/18.
 */
public interface TrainNoDao {
    public TrainNo getTrainNoById(int id);
    public TrainNo getTrainNoByName(String trainName);
    public List<TrainNo> getTrainNoByHql(String hql);
    public void save(TrainNo trainNo);
}
