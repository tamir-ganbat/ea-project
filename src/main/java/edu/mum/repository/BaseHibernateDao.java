package edu.mum.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public abstract class BaseHibernateDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * can use with multiple query object for efficiency
     *
     * @param names        param names
     * @param values       param values
     * @param queryObjects query objects
     * @throws org.hibernate.HibernateException
     */

    public void applyNamedParameterToQuery(List<String> names, List<Object> values, Query... queryObjects) throws HibernateException {
        int len = names.size();
        for (int i = 0; i < len; i++) {
            String name = names.get(i);
            Object value = values.get(i);
            for (Query queryObject : queryObjects) {
                if (value instanceof Collection) {
                    queryObject.setParameterList(name, (Collection) value);
                } else if (value instanceof Object[]) {
                    queryObject.setParameterList(name, (Object[]) value);
                } else {
                    queryObject.setParameter(name, value);
                }
            }
        }
    }
}
