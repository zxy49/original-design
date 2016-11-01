package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.RunChartDao;
import zxy.mysql.homework1.model.RunChart;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class RunChartDaoImpl implements RunChartDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public RunChart getRunChartById(int id) {
        RunChart runChart = (RunChart) baseDao.loadByIntId(RunChart.class,id);
        return runChart;
    }

    public List<RunChart> getRunChartByHql(String hql) {
        List<RunChart> runCharts = (List<RunChart>) baseDao.findAllByHQL(hql);
        return runCharts;
    }

    public void update(RunChart runChart) {
        baseDao.update(runChart);
    }

    public void save(RunChart runChart) {
        baseDao.save(runChart);
    }

    public void delete(RunChart runChart) {
        baseDao.delete(runChart);
    }
}
