package zxy.mysql.homework1.dao.dao.impl;

import zxy.mysql.homework1.dao.BaseDao;
import zxy.mysql.homework1.dao.TicketPriceDao;
import zxy.mysql.homework1.model.TicketPrice;

import java.util.List;

/**
 * Created by zxy on 2016/10/20.
 */
public class TicketPriceDaoImpl implements TicketPriceDao{
    private BaseDao baseDao = new BaseDaoImpl();
    public TicketPrice getTicketPriceById(int id) {
        TicketPrice ticketPrice = (TicketPrice) baseDao.loadByIntId(TicketPrice.class,id);
        return ticketPrice;
    }

    public List<TicketPrice> getTicketPriceByHql(String hql) {
        List<TicketPrice> ticketPrices = (List<TicketPrice>)baseDao.findAllByHQL(hql);
        return ticketPrices;
    }

    public void save(TicketPrice ticketPrice) {
        baseDao.save(ticketPrice);
    }
}
