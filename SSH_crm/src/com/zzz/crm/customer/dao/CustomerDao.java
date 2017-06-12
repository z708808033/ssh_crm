package com.zzz.crm.customer.dao;

import java.util.List;
import java.util.Map;

import com.zzz.crm.base.dao.BaseDao;
import com.zzz.crm.customer.entity.Customer;

public interface CustomerDao extends BaseDao<Customer> {

	/**
	 * 按客户名称查找单个客户
	 * @param custName
	 * @return
	 */
	public Customer findCustomerByCustName(String custName);

	/**
	 * 查询总记录数
	 * @return
	 */
	public int findTotalCount(String cname);

	/**
	 * 查询分页的客户列表
	 * @param cname 
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Customer> findCustomerPageList(String cname, int begin, int pageSize);

	/**
	 * 多条件查询
	 * @param customer
	 * @return
	 */
	public List<Customer> findByCondition(Customer customer);

	/**
	 * 按客户级别统计查询
	 * @return
	 */
	public List countLevel();

	/**
	 * 按客户来源统计查询
	 * @return
	 */
	public List countSource();


}
