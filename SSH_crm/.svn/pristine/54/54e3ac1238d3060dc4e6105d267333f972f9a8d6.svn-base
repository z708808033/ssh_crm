package com.zzz.crm.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zzz.crm.user.dao.UserDao;
import com.zzz.crm.user.entity.User;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 登陆功能
	 * @param form
	 * @return
	 * @throws UserException
	 */
	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getUsername());
		if(user == null) {
			throw new UserException("用户名不存在");
		} else {
			if(!user.getPassword().equals(form.getPassword())) {
				throw new UserException("密码错误");
			} else {
				return user;
			}
		}
	}

	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	
}
