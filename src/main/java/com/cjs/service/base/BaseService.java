package com.cjs.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiaowu on 2016/5/8.
 */
public interface BaseService<T> {
    /**
     * <p>保存一个对象</p>
     * @param t 需要保存的对象
     */
    public Serializable save(T t);

    /**
     * <p>保存对象集合</p>
     * @param ts 需要保存的对象集合
     */
    public void saveAll(List<T> ts);

    /**
     * <p>更新一个对象</p>
     * @param t 需要更新的对象
     */
    public void update(T t);

    /**
     * <p>更新对象集合</p>
     * @param ts 需要更新的对象集合
     */
    public void updateAll(List<T> ts);

    /**
     * <p>保存或更新一个对象</p>
     * @param t 需要保存或更新的对象
     */
    public void saveOrUpdate(T t);

    /**
     * <p>保存或更新对象集合</p>
     * @param ts 需要保存或更新的对象集合
     */
    public void saveOrUpdateAll(List<T> ts);

    /**
     * <p>删除对象</p>
     * 此处根据传入对象的主键，删除数据库中对应的数据
     * @param t 需要删除的数据（包含主键，即id）
     */
    public void delete(T t);

    /**
     * <p>删除对象集合</p>
     * 此处根据传入对象的主键集合，删除数据库中对应的数据
     * @param ts 需要删除的数据集合（包含主键集合，即ids）
     */
    public void deleteAll(List<T> ts);

    /**
     * <p>根据ID获取对象</p>
     * @param id 对象ID
     */
    public T get(Serializable id);

    /**
     * <p>查询T表中所有的数据</p>
     */
    public List<T> findAll();

    /**
     * <p>查询对应表所有数据的总数</p>
     * @param hql hql语句
     * @param values 属性值的结合
     * @return int 表中记录总数
     */
    public int findAllCount(String hql, Serializable... values);

    /**
     * <p>查询对应表所有数据的总数</p>
     * @param hql hql语句
     * @param values hql中需要注入的参数
     * @return int 表中记录总数
     */
    public int countByHql(String hql, Serializable... values);

    /**
     * <p>根据hql语句和对应的属性值查询</p>
     * @param hql hql语句
     * @param objects hql中需要注入的参数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByHql(String hql, Object... objects);

    /**
     * <p>通过编写hql查询,来进行分页（分页）</p>
     * @param hql hql语句
     * @param start 起始位置
     * @param limit 总数
     * @param objects hql中需要注入的参数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByHqlPage(String hql, int start, int limit, Object... objects);

    /**
     * <p>通过编写hql查询唯一对象</p>
     * @param hql hql语句
     * @param objects hql中需要注入的参数
     * @return T 符合条件的对象
     */
    public T findByHqlUnique(String hql, Object... objects);

    /**
     * <p>通过编写hql更新数据</p>
     * @param hql hql语句
     * @param parameters hql中需要注入的参数
     */
    public void executeUpdate(String hql, Serializable... parameters);

    /**
     * <p>通过一个属性和对应值去相关表中查询数据</p>
     * @param propertyName 属性名
     * @param value 对应属性值
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByProperty(String propertyName, Serializable value);

    /**
     * <p>通过一个属性和对应值去相关表中查询数据（分页）</p>
     * @param propertyName  属性名
     * @param value 对应属性值
     * @param start 起始位置
     * @param limit 总数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByProperty(String propertyName, Serializable value, long start, long limit);

    /**
     * <p>通过一个属性和对应值去相关表中查询数据(分页)</p>
     *
     * @param propertyName  属性名
     * @param value 对应属性值
     * @param start 起始位置
     * @param limit 总数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findByPropertyPage(String propertyName, Serializable value, int start, int limit);

    /**
     * <p>通过属性名和属性值查询唯一对象</p>
     * @param propertyName 属性名
     * @param value 属性值
     * @return T 符合条件的对象
     */
    public T findByPropertyUnique(String propertyName, Serializable value);

    /**
     * <p>查询所有数据（分页）</p>
     * @param start 起始位置
     * @param limit 总数
     * @return List<T> 符合条件的对象列表
     */
    public List<T> findAll(int start, int limit);

    /**
     * <p>通过属性名与属性值删除数据</p>
     *
     * @param propertyName 属性名
     * @param value        属性值
     * @return int
     */
    public int deleteByProperty(String propertyName, Serializable value);

    /**
     * <p>通过多个属性名与属性值删除数据</p>
     *
     * @param propertyNames 属性名数组
     * @param values        属性值数组
     * @return
     */
    public int deleteByProperties(String[] propertyNames, Object[] values);
}
