package com.zzz.crm.linkman.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zzz.crm.customer.entity.Customer;
import com.zzz.crm.linkman.entity.Linkman;

public class LinkmanDaoMysqlImpl extends HibernateDaoSupport implements LinkmanDao{

	/**
	 * 添加联系人
	 */
	public void add(Linkman linkman,Integer cid) {
		HibernateTemplate template = this.getHibernateTemplate();
		Customer customer = template.get(Customer.class, cid);
		customer.getLinkmans().add(linkman);
		template.save(customer);
	}

	/**
	 * 查询联系人
	 */
	public List<Linkman> findLinkman(String lname, Integer begin, Integer pageSize) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		criteria.add(Restrictions.like("lkmName", "%" + lname + "%"));
		List<Linkman> linkmans = (List<Linkman>) template.findByCriteria(criteria,begin ,pageSize );
		return linkmans;
	}

	/**
	 * 根据lid查询联系人
	 */
	public Linkman findLinkmanByLid(Integer lid) {
		HibernateTemplate template = this.getHibernateTemplate();
		Linkman linkman = template.get(Linkman.class, lid);
		return linkman;
	}

	/**
	 * 查询记录数
	 */
	public Integer findCount(String lname) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		criteria.add(Restrictions.like("lkmName","%" + lname + "%"));
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) template.findByCriteria(criteria);
		if(list.size() > 0) {
			long l = list.get(0);
			int i = (int) l;
			return i;
		}
		return 0;
	}

	/**
	 * 修改联系人
	 */
	public void update(Linkman linkman) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.update(linkman);
	}

	/**
	 * 删除联系人
	 */
	public void delete(Integer lid) {
		HibernateTemplate template = this.getHibernateTemplate();
		Linkman linkman = template.get(Linkman.class, lid);
		template.delete(linkman);
	}

	/**
	 * 多条件查询
	 */
	public List<Linkman> findByCondition(Linkman linkman) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		criteria.add(Restrictions.like("lkmName", "%" + linkman.getLkmName() + "%"));
		if(linkman.getCustomer().getCid() != -1) {
			criteria.add(Restrictions.eq("customer.cid", linkman.getCustomer().getCid()));
		}
		List<Linkman> list = (List<Linkman>) template.findByCriteria(criteria);
		return list;
	}
	
}
