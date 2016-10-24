package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.Carriage;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface CarriageDao {
    public Carriage getCarriageById(int id);
    public List<Carriage> getCarriageByHql(String hql);
    public void save(Carriage carriage);
}
