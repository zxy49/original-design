package zxy.mysql.homework1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{

    private static SessionFactory sessionFactory=buildSessionFactory();

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    @SuppressWarnings("deprecation")
    private static SessionFactory buildSessionFactory()
    {
        Configuration conf=new Configuration().configure();
        return conf.buildSessionFactory();
    }

}