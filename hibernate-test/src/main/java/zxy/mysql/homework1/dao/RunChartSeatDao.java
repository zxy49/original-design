package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.RunChart;
import zxy.mysql.homework1.model.RunChartSeat;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface RunChartSeatDao {
    public RunChartSeat getRunChartSeatById(int id);
    public List<RunChartSeat> getRunChartSeatByHql(String hql);
    public void save(RunChartSeat runChartSeat);
}
