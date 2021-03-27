package com.example.springWeb.datasource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.common.base.Preconditions;
import java.util.List;

public abstract class AbstractHibernateDAO<T>{
    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    public void setClazz(Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T find(long id) {
        return (T) getCurrentSession().get( clazz, id );
    }
    public List<T> findAll() {
        return getCurrentSession()
                .createQuery( "from " + clazz.getName() ).list();
    }

    public T create(final T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete( entity );
    }

    public void deleteById(final long entityId) {
        final T entity = find(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
