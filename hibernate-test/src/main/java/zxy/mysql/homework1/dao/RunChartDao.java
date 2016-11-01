package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.RunChart;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface RunChartDao {
    public RunChart getRunChartById(int id);
    public List<RunChart> getRunChartByHql(String hql);
    public void update(RunChart runChart);
    public void save(RunChart runChart);
    public void delete(RunChart runChart);
}
