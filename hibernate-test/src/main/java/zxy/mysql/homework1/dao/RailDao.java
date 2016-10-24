package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Rail;

/**
 * Created by zxy on 2016/10/19.
 */
public interface RailDao {
    public Rail getRailById(int id);
    public Rail getRailByName(String railName);
    public void save(Rail rail);
}
