package com.zzz.crm.customer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zzz.crm.base.dao.BaseDaoImpl;
import com.zzz.crm.customer.entity.Customer;

public class CustomerDaoMysqlImpl extends BaseDaoImpl<Customer> implements CustomerDao {


	/**
	 * 根据客户名称查找客户
	 */
	public Customer findCustomerByCustName(String custName) {
		HibernateTemplate template = this.getHibernateTemplate();
		List<Customer> list = (List<Customer>) template.find("from Customer where custName=?", custName);
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	/**
	 * 查询总记录数
	 */
	public int findTotalCount(String cname) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.setProjection(Projections.rowCount());
		criteria.add(Restrictions.like("custName","%" + cname + "%"));
		System.out.println(template.findByCriteria(criteria));
		List<Long> list = (List<Long>) template.findByCriteria(criteria);
		if(list != null && list.size() > 0) {
			long l = list.get(0);
			int totalCount = (int) l;
			return totalCount;
		} else {
			return 0;
		}
	}

	/**
	 * 查询每页记录
	 */
	public List<Customer> findCustomerPageList(String cname, int begin,int pageSize) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName", "%" + cname + "%"));
		List<Customer> list = (List<Customer>) template.findByCriteria(criteria, begin, pageSize);
		return list;
	}
	
	/**
	 * 多条件查询
	 */
	public List<Customer> findByCondition(Customer customer) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		criteria.add(Restrictions.like("custLevel", "%" + customer.getDict().getDname() + "%"));
		criteria.add(Restrictions.like("custSource", "%" + customer.getCustSource() + "%"));
		List<Customer> list = (List<Customer>) template.findByCriteria(criteria);
		return list;
	}
	
	/**
	 * 按客户级别统计查询
	 */
	public List countLevel() {
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT COUNT(*) AS num,d.dname AS custLevel FROM t_customer c INNER JOIN t_dict d ON c.did=d.did GROUP BY c.did");
		query.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = query.list();
		return list;
	}
	
	/**
	 * 按客户来源统计查询
	 */
	public List countSource() {
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT COUNT(*) num,custSource FROM t_customer GROUP BY custSource");
		query.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		return query.list();
	}


}
