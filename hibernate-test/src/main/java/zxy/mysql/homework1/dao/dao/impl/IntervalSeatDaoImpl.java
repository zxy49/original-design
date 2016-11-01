package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.IntervalSeatDao;
import zxy.mysql.homework1.model.IntervalSeat;

import java.util.List;

/**
 * Created by zxy on 2016/11/1.
 */
public class IntervalSeatDaoImpl implements IntervalSeatDao {
    private BaseDao baseDao = new BaseDaoImpl();
    public IntervalSeat getIntervalSeatById(int id) {
        IntervalSeat intervalSeat = (IntervalSeat)baseDao.loadByIntId(IntervalSeat.class,id);
        return intervalSeat;
    }

    public List<IntervalSeat> getIntervalSeatByHql(String hql) {
        List<IntervalSeat> intervalSeats = (List<IntervalSeat>)baseDao.findAllByHQL(hql);
        return intervalSeats;
    }

    public void update(IntervalSeat intervalSeat) {
        baseDao.update(intervalSeat);
    }

    public void save(IntervalSeat intervalSeat) {
        baseDao.save(intervalSeat);
    }

    public void delete(IntervalSeat intervalSeat) {
        baseDao.delete(intervalSeat);
    }
}
