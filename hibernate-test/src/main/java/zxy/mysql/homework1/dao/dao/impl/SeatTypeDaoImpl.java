package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.SeatTypeDao;
import zxy.mysql.homework1.model.SeatType;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class SeatTypeDaoImpl implements SeatTypeDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public SeatType getSeatTypeById(int id) {
        SeatType seatType = (SeatType)baseDao.loadByIntId(SeatType.class,id);
        return seatType;
    }


    public List<SeatType> getSeatTypeByHql(String hql) {
        List<SeatType> seatTypes = (List<SeatType>) baseDao.findAllByHQL(hql);
        return seatTypes;
    }

    public void save(SeatType seatType) {
        baseDao.save(seatType);
    }
}
