package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.RunChartSeatDao;
import zxy.mysql.homework1.model.RunChart;
import zxy.mysql.homework1.model.RunChartSeat;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class RunChartSeatDaoImpl implements RunChartSeatDao {
    private BaseDao baseDao = new BaseDaoImpl();

    public RunChartSeat getRunChartSeatById(int id) {
        RunChartSeat runChartSeat = (RunChartSeat) baseDao.loadByIntId(RunChartSeat.class, id);
        return runChartSeat;
    }

    public List<RunChartSeat> getRunChartSeatByHql(String hql) {
        List<RunChartSeat> runChartSeats = (List<RunChartSeat>) baseDao.findAllByHQL(hql);
        return runChartSeats;
    }

    public void save(RunChartSeat runChartSeat) {
        baseDao.save(runChartSeat);
    }
}