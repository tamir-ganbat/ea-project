package edu.mum.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public abstract class BaseHibernateDaoSupport<D, ID extends Serializable> extends BaseHibernateDao implements BaseRepo<D, ID> {

    protected final Class<D> domain;

    protected final String domainName;

    protected int maxPageSize = 100;

    @Autowired
    private SessionFactory sessionFactory;

    private BaseHibernateDaoSupport() {
        throw new IllegalStateException("you cannot create with default constructor");
    }

    public BaseHibernateDaoSupport(Class<D> domain) {
        this.domain = domain;
        this.domainName = domain.getSimpleName();
    }

    @Override
    @SuppressWarnings("unchecked")
    public D get(ID id) {
        return (D) getSession().get(domain, id);
    }

    @SuppressWarnings("unchecked")
    public ID save(D item) {
        return (ID) getSession().save(item);
    }

    public void update(D item) {
        getSession().update(item);
    }

    public void saveOrUpdate(D item) {
        getSession().saveOrUpdate(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public D merge(D item) {
        return (D) getSession().merge(item);
    }

    @Override
    public void refresh(D item) {
        getSession().refresh(item);
    }

    public void delete(D item) {
        getSession().delete(item);
    }

    @Override
    public List<D> find() {
        return getSession().createQuery("FROM " + domainName).list();
    }
}
