package com.cjs.dao.base;

import com.cjs.util.string.StringUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
     * <p>保存对象集合</p>
     *
     * @param ts 需要保存的对象集合
     */
    public void saveAll(List<T> ts) {
        if (ts != null && ts.size() > 0) {
            for (T t : ts) {
                this.save(t);
            }
        }
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
     * <p>更新对象集合</p>
     *
     * @param ts 需要更新的对象集合
     */
    public void updateAll(List<T> ts) {
        if (ts != null && ts.size() > 0) {
            for (T t : ts) {
                this.update(t);
            }
        }
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
     * <p>保存或更新对象集合</p>
     *
     * @param ts 需要保存或更新的对象集合
     */
    public void saveOrUpdateAll(List<T> ts) {
        if (ts != null && ts.size() > 0) {
            for (T t : ts) {
                this.saveOrUpdate(t);
            }
        }
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
     * <p>删除对象集合</p>
     * 此处根据传入对象的主键集合，删除数据库中对应的数据
     *
     * @param ts 需要删除的数据集合（包含主键集合，即ids）
     */
    public void deleteAll(List<T> ts) {
        if (ts != null && ts.size() > 0) {
            for (T t : ts) {
                this.getSession().delete(t);
            }
        }
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
     * <p>查询对应表所有数据的总数</p>
     *
     * @param hql    hql语句
     * @param values 属性值的结合
     * @return int 表中记录总数
     */
    public int findAllCount(String hql, Serializable... values) {
        String hqlCountAll = "select count(*) from " + this.entityClass.getSimpleName();
        String counthql = StringUtil.isEmpty(hql) ? hqlCountAll : hql;
        Query query = this.getSession().createQuery(counthql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        int count = ((Long) query.uniqueResult()).intValue();
        return count;
    }

    /**
     * <p>查询对应表所有数据的总数</p>
     *
     * @param hql    hql语句
     * @param values hql中需要注入的参数
     * @return int 表中记录总数
     */
    public int countByHql(String hql, Serializable... values) {
        if (hql.trim().startsWith("and")) {
            hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
        }
        if (hql.trim().startsWith("from")) {
            hql = "select count(*) " + hql;
        }
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        int count = ((Long) query.uniqueResult()).intValue();
        return count;
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
     * <p>通过编写hql查询,来进行分页（分页）</p>
     *
     * @param hql     hql语句
     * @param start   起始位置
     * @param limit   总数
     * @param objects hql中需要注入的参数
     * @return List<T> 符合条件的对象列表
     */
    @SuppressWarnings("unchecked")
    public List<T> findByHqlPage(String hql, int start, int limit, Object... objects) {
        if (hql.trim().startsWith("and")) {
            hql = "from " + entityClass.getSimpleName() + " where 1 = 1 " + hql;
        }
        List<T> list = null;
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i, objects[i]);
        }
        query.setFirstResult(start);
        query.setMaxResults(limit);

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
     * <p>通过一个属性和对应值去相关表中查询数据（分页）</p>
     *
     * @param propertyName  属性名
     * @param value 对应属性值
     * @param start 起始位置
     * @param limit 总数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByProperty(String propertyName, Serializable value, long start, long limit) {
        String hql = "from " + entityClass.getSimpleName() + " where " + propertyName + " = ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0, value);
        query.setFirstResult((int) start);
        query.setMaxResults((int) limit);
        @SuppressWarnings("unchecked")
        List<T> list = query.list();
        return list;
    }

    /**
     * <p>通过一个属性和对应值去相关表中查询数据(分页)</p>
     *
     * @param propertyName  属性名
     * @param value 对应属性值
     * @param start 起始位置
     * @param limit 总数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByPropertyPage(String propertyName, Serializable value, int start, int limit) {
        String hql = "from " + entityClass.getSimpleName() + " where " + propertyName + " like ?";
        Query query = this.getSession().createQuery(hql);
        query.setParameter(0, "%" + value + "%");
        query.setFirstResult(start);
        query.setMaxResults(limit);
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
     * <p>查询所有数据（分页）</p>
     *
     * @param start 起始位置
     * @param limit 总数
     * @return List<T> 符合条件的对象列表
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(int start, int limit) {
        String hql = "from " + entityClass.getSimpleName();
        Query query = this.getSession().createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.list();
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

    /**
     * <p>通过多个属性名与属性值删除数据</p>
     *
     * @param propertyNames 属性名数组
     * @param values        属性值数组
     * @return
     */
    public int deleteByProperties(String[] propertyNames, Object[] values) {
        if (propertyNames == null || values == null || propertyNames.length == 0 || values.length == 0) {
            throw new IllegalArgumentException();
        }
        StringBuffer hql = new StringBuffer("delete from " + entityClass.getSimpleName() + " where 1=1 ");
        for (int i = 0; i < propertyNames.length; i++) {
            if (i > 0) {
                hql.append(" and " + propertyNames[i] + " =?");
            } else {
                hql.append(propertyNames[i] + " =?");
            }
        }
        Query query = this.getSession().createQuery(hql.toString());
        for (int j = 0; j < values.length; j++) {
            query.setParameter(j, values[j]);
        }
        return query.executeUpdate();
    }
}