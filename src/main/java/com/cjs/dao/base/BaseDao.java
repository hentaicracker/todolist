package com.cjs.dao.base;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
@Component
public class BaseDao<T extends Serializable> {
    @Autowired(required = true)
    private SessionFactory sessionFactory;
    private Session session;
    @SuppressWarnings("rawtypes")
    private Class entityClass;

    @SuppressWarnings("rawtypes")
    public Class getEntityClass() {
        return entityClass;
    }

    @SuppressWarnings("rawtypes")
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings("rawtypes")
    public BaseDao() {
        Type type = this.getClass().getGenericSuperclass();
        if (!this.getClass().getSimpleName().equals("BaseDao") && !(type instanceof Class)) {
            if (type.toString().indexOf("BaseDao") != -1) {
                ParameterizedType type1 = (ParameterizedType) type;
                Type[] types = type1.getActualTypeArguments();
                setEntityClass((Class) types[0]);
            } else {
                type = ((Class) type).getGenericSuperclass();
                ParameterizedType type1 = (ParameterizedType) type;
                Type[] types = type1.getActualTypeArguments();
                setEntityClass((Class) types[0]);
            }
        }
    }


    public Session getSession() {
        session = sessionFactory.getCurrentSession();
        return session;
    }

    private Session openSession() {
        return this.sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    /**
     * <p>保存一个对象</p>
     *
     * @param t 需要保存的对象
     */
    public Serializable save(T t) {
        return this.getSession().save(t);
    }


    /**
     * <p>更新一个对象</p>
     *
     * @param t 需要更新的对象
     */
    public void update(T t) {
        this.getSession().update(t);
    }


    /**
     * <p>保存或更新一个对象</p>
     *
     * @param t 需要保存或更新的对象
     */
    public void saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
    }


    /**
     * <p>删除对象</p>
     * 此处根据传入对象的主键，删除数据库中对应的数据
     *
     * @param t 需要删除的数据（包含主键，即id）
     */
    public void delete(T t) {
        this.getSession().delete(t);
    }


    /**
     * <p>根据ID获取对象</p>
     *
     * @param id 对象ID
     */
    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        T t = null;
        t = (T) this.getSession().get(this.getEntityClass(), id);
        return t;
    }

    /**
     * <p>查询T表中所有的数据</p>
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List<T> list = null;
        String hqlAll = "from " + this.entityClass.getSimpleName();
        Query query = this.getSession().createQuery(hqlAll);
        list = query.list();
        return list;
    }

    /**
     * <p>根据hql语句和对应的属性值查询</p>
     *
     * @param hql     hql语句
     * @param objects hql中需要注入的参数
     * @return List<T> 符合条件的对象列表
     */
    @SuppressWarnings("unchecked")
    public List<T> findByHql(String hql, Object... objects) {
        if (hql.trim().startsWith("and")) {
            hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
        }
        List<T> list = null;
        System.out.println(hql);
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i, objects[i]);
        }
        list = query.list();
        return list;
    }

    /**
     * <p>通过编写hql查询唯一对象</p>
     *
     * @param hql     hql语句
     * @param objects hql中需要注入的参数
     * @return T 符合条件的对象
     */
    public T findByHqlUnique(String hql, Object... objects) {
        if (hql.trim().startsWith("and")) {
            hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
        }
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i, objects[i]);
        }
        @SuppressWarnings("unchecked")
        T t = (T) query.uniqueResult();
        return t;
    }

    /**
     * <p>通过编写hql更新数据</p>
     *
     * @param hql        hql语句
     * @param parameters hql中需要注入的参数
     */
    public void executeUpdate(String hql, Serializable... parameters) {
        Session session = this.getSession();
        Query query = session.createQuery(hql);
        if (parameters != null && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
            }
        }
        query.executeUpdate();
    }

    /**
     * <p>通过一个属性和对应值去相关表中查询数据</p>
     *
     * @param propertyName  属性名
     * @param value 对应属性值
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByProperty(String propertyName, Serializable value) {
        String hql = "from " + entityClass.getSimpleName() + " where " + propertyName + " = ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0, value);
        @SuppressWarnings("unchecked")
        List<T> list = query.list();
        return list;
    }

    /**
     * <p>通过属性名和属性值查询唯一对象</p>
     *
     * @param propertyName 属性名
     * @param value        属性值
     * @return T 符合条件的对象
     */
    @SuppressWarnings("unchecked")
    public T findByPropertyUnique(String propertyName, Serializable value) {
        String hql = "from " + entityClass.getSimpleName() + " where " + propertyName + " =? ";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0, value);
        return (T) query.uniqueResult();
    }

    /**
     * <p>通过属性名与属性值删除数据</p>
     *
     * @param propertyName 属性名
     * @param value        属性值
     * @return
     */
    public int deleteByProperty(String propertyName, Serializable value) {
        if (propertyName == null || value == null || propertyName.length() == 0) {
            throw new IllegalArgumentException();
        }
        String hql = "delete " + entityClass.getSimpleName() + " where " + propertyName + " =  ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0, value);
        return query.executeUpdate();
    }
}