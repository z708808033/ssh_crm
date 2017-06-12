package com.zzz.crm.base.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t);
	/**
	 * 删除
	 * @param t
	 */
	public void delete(int id);
	/**
	 * 修改
	 * @param t
	 */
	public void update(T t);
	/**
	 * 查询所有
	 * @param t
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T findById(int id);
}
