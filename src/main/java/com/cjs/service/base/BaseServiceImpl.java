package com.cjs.service.base;

import com.cjs.dao.base.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 2016/5/8
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
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        baseDao.saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
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
    public List<T> findByHql(String hql, Object... objects) {
        return baseDao.findByHql(hql, objects);
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
    public T findByPropertyUnique(String propertyName, Serializable value) {
        return baseDao.findByPropertyUnique(propertyName, value);
    }

    @Override
    public int deleteByProperty(String propertyName, Serializable value) {
        return baseDao.deleteByProperty(propertyName, value);
    }
}
