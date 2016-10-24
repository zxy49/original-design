package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Seat;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface SeatDao {
    public Seat getSeatById(int id);
    public List<Seat> getSeatByHql(String hql);
    public void update(Seat seat);
    public void save(Seat seat);
}
