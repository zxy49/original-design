package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.SeatDao;
import zxy.mysql.homework1.model.Seat;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class SeatDaoImpl implements SeatDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public Seat getSeatById(int id) {
        Seat seat = (Seat) baseDao.loadByIntId(Seat.class,id);
        return seat;
    }

    public List<Seat> getSeatByHql(String hql) {
        List<Seat> seats = (List<Seat>)baseDao.findAllByHQL(hql);
        return seats;
    }

    public void update(Seat seat){
        baseDao.update(seat);
    }

    public void save(Seat seat) {
        baseDao.save(seat);
    }
}
