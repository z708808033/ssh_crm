package com.zzz.crm.linkman.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzz.crm.customer.entity.PageBean;
import com.zzz.crm.linkman.dao.LinkmanDao;
import com.zzz.crm.linkman.entity.Linkman;

@Transactional
public class LinkmanService {
	private LinkmanDao linkmanDao;

	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}

	/**
	 * 添加联系人
	 * @param linkman
	 * @param cid
	 */
	public void add(Linkman linkman, Integer cid) {
		linkmanDao.add(linkman,cid);
	}

	/**
	 * 查询所有联系人
	 * @param currentPage 
	 * @param lname 
	 * @return
	 */
	public PageBean findAllLinkman(Integer currentPage, String lname) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);

		Integer pageSize = 5;
		pageBean.setPageSize(pageSize);
		
		Integer begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		
		Integer totalCount = linkmanDao.findCount(lname);
		pageBean.setTotalCount(totalCount);
		
		Integer totalPage;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		List<Linkman> list = linkmanDao.findLinkman(lname,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据lid查询联系人
	 * @param lid
	 * @return
	 */
	public Linkman findLinkmanByLid(Integer lid) {
		return linkmanDao.findLinkmanByLid(lid);
	}

	/**
	 * 修改联系人
	 * @param linkman
	 */
	public void update(Linkman linkman) {
		linkmanDao.update(linkman);
	}

	/**
	 * 删除联系人
	 * @param lid
	 */
	public void delete(Integer lid) {
		linkmanDao.delete(lid);
	}
	
	/**
	 * 多条件查询
	 * @param linkman
	 * @return
	 */
	public List<Linkman> findByCondition(Linkman linkman) {
		return linkmanDao.findByCondition(linkman);
	}

}
