package com.zzz.crm.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.zzz.crm.customer.dao.CustomerDao;
import com.zzz.crm.customer.entity.Customer;
import com.zzz.crm.customer.entity.PageBean;

@Transactional
public class CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * 添加客户
	 * @param customer
	 * @throws CustomerException
	 */
	public void add(Customer customer) throws CustomerException {
		Customer _customer = customerDao.findCustomerByCustName(customer.getCustName());
		if(_customer != null) {
			throw new CustomerException("该客户已存在");
		} else {
			customerDao.add(customer);
		}
	}

	/**
	 * 查询所有客户
	 * @return
	 */
	public List<Customer> findAllCustomer() {
		return customerDao.findAll();
	}

	/**
	 * 根据客户id查找客户
	 * @param cid
	 * @return
	 */
	public Customer findCustomerByCid(Integer cid) {
		return customerDao.findById(cid);
	}

	/**
	 * 编辑客户
	 * @param customer
	 */
	public void edit(Customer customer) {
		customerDao.update(customer);
	}

	/**
	 * 删除客户
	 * @param integer
	 */
	public void delete(Integer cid) {
		customerDao.delete(cid);
	}

	/**
	 * 分页查询
	 * @param currentPage
	 * @param cname
	 * @return
	 */
	public PageBean listPage(int currentPage, String cname) {
		PageBean pageBean = new PageBean();
		
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = customerDao.findTotalCount(cname);
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		
		int totalPage;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		List<Customer> list = customerDao.findCustomerPageList(cname,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 多条件查询
	 * @param customer
	 * @return
	 */
	public List<Customer> findByCondition(Customer customer) {
		return customerDao.findByCondition(customer);
	}

	/**
	 * 按客户级别统计查询
	 * @return
	 */
	public List countLevel() {
		return customerDao.countLevel();
	}

	/**
	 * 按客户来源统计查询
	 * @return
	 */
	public List countSource() {
		return customerDao.countSource();
	}

}
