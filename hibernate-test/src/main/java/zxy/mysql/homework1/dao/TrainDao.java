package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Train;

import java.util.List;

/**
 * Created by zxy on 2016/10/18.
 */
public interface TrainDao {
    public Train getTrainById(int id);
    public Train getTrainByName(String trainName);
    public List<Train> getAllTrainByHql(String hql);
//    public void setTrainCarriage();
    public void save(Train train);
}

