package com.zzz.crm.dict.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzz.crm.dict.dao.DictDao;
import com.zzz.crm.dict.entity.Dict;

@Transactional
public class DictService {
	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
	
	/**
	 * 查询所有级别
	 * @return
	 */
	public List<Dict> findAllDict() {
		return dictDao.findAll();
	}

	
}
