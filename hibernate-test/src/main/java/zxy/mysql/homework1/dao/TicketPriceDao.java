package zxy.mysql.homework1.dao;

import zxy.mysql.homework1.model.TicketPrice;

import java.util.List;

/**
 * Created by zxy on 2016/10/19.
 */
public interface TicketPriceDao {
    public TicketPrice getTicketPriceById(int id);
    public List<TicketPrice> getTicketPriceByHql(String hql);
    public void save(TicketPrice ticketPrice);
}
