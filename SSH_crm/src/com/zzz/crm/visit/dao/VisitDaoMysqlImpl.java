package com.zzz.crm.visit.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zzz.crm.visit.entity.Visit;

public class VisitDaoMysqlImpl extends HibernateDaoSupport implements VisitDao {

	/**
	 * 添加功能
	 */
	public void add(Visit visit) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.save(visit);
	}

	/**
	 * 查询所有拜访记录
	 */
	public List<Visit> findAllVisit() {
		HibernateTemplate template = this.getHibernateTemplate();
		List<Visit> visitList = (List<Visit>) template.find("from Visit");
		return visitList;
	}
	
	/**
	 * 根据vid查询拜访
	 */
	public Visit findVisitByVid(Integer vid) {
		HibernateTemplate template = this.getHibernateTemplate();
		Visit visit = template.get(Visit.class, vid);
		return visit;
	}
	
	/**
	 * 修改拜访
	 */
	public void update(Visit visit) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.update(visit);
	}

	/**
	 * 多条件查询
	 */
	public List<Visit> findByCondition(Visit visit) {
		HibernateTemplate template = this.getHibernateTemplate();
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		if(visit.getCustomer().getCid() != -1) {
			criteria.add(Restrictions.eq("customer.cid", visit.getCustomer().getCid()));
		}
		if(visit.getUser().getUid() != -1) {
			criteria.add(Restrictions.eq("user.uid", visit.getUser().getUid()));
		}
		criteria.add(Restrictions.like("visitAddress","%" + visit.getVisitAddress() + "%"));
		List<Visit> list = (List<Visit>) template.findByCriteria(criteria);
		return list;
	}

}
