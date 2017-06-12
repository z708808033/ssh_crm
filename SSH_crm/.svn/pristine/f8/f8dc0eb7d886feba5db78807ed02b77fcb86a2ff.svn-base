package com.zzz.crm.user.action;

import java.sql.Driver;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzz.crm.user.entity.User;
import com.zzz.crm.user.service.UserException;
import com.zzz.crm.user.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User form = new User();
	private String msg;
	
	public User getForm() {
		return form;
	}
	public String getMsg() {
		return msg;
	}
	public User getModel() {
		return form;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 登陆功能
	 * @return
	 */
	public String login() {
		try {
			User user = userService.login(form);
			ServletActionContext.getRequest().getSession().setAttribute("session_user", user);
			return "loginSuccess";
		} catch (UserException e) {
			msg = e.getMessage();
			return "loginFail";
		}
	}

}
