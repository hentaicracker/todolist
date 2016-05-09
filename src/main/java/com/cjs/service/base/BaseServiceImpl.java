package com.cjs.service.base;

import com.cjs.dao.base.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
@Component
public class BaseServiceImpl<T extends Serializable> implements BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public Serializable save(T t) {
        return baseDao.save(t);
    }

    @Override
    public void saveAll(List<T> ts) {
        baseDao.saveAll(ts);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void updateAll(List<T> ts) {
        baseDao.updateAll(ts);
    }

    @Override
    public void saveOrUpdate(T t) {
        baseDao.saveOrUpdate(t);
    }

    @Override
    public void saveOrUpdateAll(List<T> ts) {
        baseDao.saveOrUpdateAll(ts);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void deleteAll(List<T> ts) {
        baseDao.deleteAll(ts);
    }

    @Override
    public T get(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public int findAllCount(String hql, Serializable... values) {
        return baseDao.findAllCount(hql, values);
    }

    @Override
    public int countByHql(String hql, Serializable... values) {
        return baseDao.countByHql(hql, values);
    }

    @Override
    public List<T> findByHql(String hql, Object... objects) {
        return baseDao.findByHql(hql, objects);
    }

    @Override
    public List<T> findByHqlPage(String hql, int start, int limit,Object... objects) {
        return baseDao.findByHqlPage(hql, start, limit, objects);
    }

    @Override
    public T findByHqlUnique(String hql, Object... objects) {
        return baseDao.findByHqlUnique(hql, objects);
    }

    @Override
    public void executeUpdate(String hql, Serializable... parameters) {
        baseDao.executeUpdate(hql, parameters);
    }

    @Override
    public List<T> findByProperty(String propertyName, Serializable value) {
        return baseDao.findByProperty(propertyName, value);
    }

    @Override
    public List<T> findByProperty(String propertyName, Serializable value, long start, long limit) {
        return baseDao.findByProperty(propertyName, value, start, limit);
    }

    @Override
    public List<T> findByPropertyPage(String propertyName, Serializable value, int start, int limit) {
        return baseDao.findByPropertyPage(propertyName, value, start, limit);
    }

    @Override
    public T findByPropertyUnique(String propertyName, Serializable value) {
        return baseDao.findByPropertyUnique(propertyName, value);
    }

    @Override
    public List<T> findAll(int start, int limit) {
        return baseDao.findAll(start, limit);
    }

    @Override
    public int deleteByProperty(String propertyName, Serializable value) {
        return baseDao.deleteByProperty(propertyName, value);
    }

    @Override
    public int deleteByProperties(String[] propertyNames, Object[] values) {
        return baseDao.deleteByProperties(propertyNames, values);
    }
}
