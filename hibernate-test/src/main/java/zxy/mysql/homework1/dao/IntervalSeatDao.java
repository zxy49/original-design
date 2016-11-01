package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.IntervalSeat;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by zxy on 2016/11/1.
 */
public interface IntervalSeatDao {
    public IntervalSeat getIntervalSeatById(int id);
    public List<IntervalSeat> getIntervalSeatByHql(String hql);
    public void update(IntervalSeat intervalSeat);
    public void save(IntervalSeat intervalSeat);
    public void delete(IntervalSeat intervalSeat);
}
