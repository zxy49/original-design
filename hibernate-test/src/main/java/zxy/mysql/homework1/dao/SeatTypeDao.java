package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.SeatType;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface SeatTypeDao {
    public SeatType getSeatTypeById(int id);
    public List<SeatType> getSeatTypeByHql(String hql);
    public void save(SeatType seatType);
}
