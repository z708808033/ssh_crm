package com.zzz.crm.base.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = type.getActualTypeArguments();
		this.clazz = (Class) types[0];
	}
	
	/**
	 * 添加
	 */
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	/**
	 * 删除
	 */
	public void delete(int id) {
		T t = (T) this.getHibernateTemplate().get(clazz, id);
		this.getHibernateTemplate().delete(t);
	}

	/**
	 * 修改
	 */
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	/**
	 * 查询所有
	 */
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
	}

	/**
	 * 根据id查询
	 */
	public T findById(int id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
}
