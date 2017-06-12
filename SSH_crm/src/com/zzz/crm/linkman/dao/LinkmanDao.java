package com.zzz.crm.linkman.dao;

import java.util.List;

import com.zzz.crm.linkman.entity.Linkman;

public interface LinkmanDao {

	/**
	 * 添加联系人
	 * @param linkman
	 * @param cid
	 */
	public void add(Linkman linkman, Integer cid);

	/**
	 * 查询所有联系人
	 * @param pageSize 
	 * @param begin 
	 * @param lname 
	 * @return
	 */
	public List<Linkman> findLinkman(String lname, Integer begin, Integer pageSize);

	/**
	 * 根据lid查询联系人
	 * @param lid
	 * @return
	 */
	public Linkman findLinkmanByLid(Integer lid);

	/**
	 * 查找记录数
	 * @param lname 
	 * @return
	 */
	public Integer findCount(String lname);

	/**
	 * 修改联系人
	 * @param linkman
	 */
	public void update(Linkman linkman);

	/**
	 * 删除联系人
	 * @param lid
	 */
	public void delete(Integer lid);

	/**
	 * 多条件查询
	 * @param linkman
	 * @return
	 */
	public List<Linkman> findByCondition(Linkman linkman);


}
