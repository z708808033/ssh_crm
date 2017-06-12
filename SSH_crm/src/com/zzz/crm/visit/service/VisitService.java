package com.zzz.crm.visit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzz.crm.visit.dao.VisitDao;
import com.zzz.crm.visit.entity.Visit;

@Transactional
public class VisitService {
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	/**
	 * 添加功能
	 * @param visit
	 */
	public void add(Visit visit) {
		visitDao.add(visit);
	}

	/**
	 * 查询所有拜访记录
	 * @return
	 */
	public List<Visit> findAllVisit() {
		return visitDao.findAllVisit();
	}

	/**
	 * 根据vid查询拜访
	 * @param vid
	 * @return
	 */
	public Visit findVisitByVid(Integer vid) {
		return visitDao.findVisitByVid(vid);
	}

	/**
	 * 修改拜访
	 * @param visit
	 */
	public void update(Visit visit) {
		visitDao.update(visit);
	}

	/**
	 * 多条件查询
	 * @param visit
	 * @return
	 */
	public List<Visit> findByCondition(Visit visit) {
		return visitDao.findByCondition(visit);
	}
}
