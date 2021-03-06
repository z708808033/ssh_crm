package com.zzz.crm.visit.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzz.crm.customer.entity.Customer;
import com.zzz.crm.customer.service.CustomerService;
import com.zzz.crm.user.entity.User;
import com.zzz.crm.user.service.UserService;
import com.zzz.crm.visit.entity.Visit;
import com.zzz.crm.visit.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	private Visit visit = new Visit();
	private VisitService visitService;
	private CustomerService customerService;
	private UserService userService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	public Visit getModel() {
		return visit;
	}
	
	/**
	 * 前往添加页面
	 * @return
	 */
	public String toAddPage() {
		List<Customer> customerList = customerService.findAllCustomer();
		List<User> userList = userService.findAllUser();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		ServletActionContext.getRequest().setAttribute("userList", userList);
		return "add";
	}
	
	/**
	 * 添加功能
	 * @return
	 */
	public String add() {
		visitService.add(visit);
		return "addSuccess";
	}
	
	/**
	 * 查询所有拜访记录
	 * @return
	 */
	public String findAllVisit() {
		List<Visit> visitList = visitService.findAllVisit();
		ServletActionContext.getRequest().setAttribute("visitList", visitList);
		return "list";
	}
	
	/**
	 * 编辑之前的预处理
	 * @return
	 */
	public String preEdit() {
		Integer vid = Integer.parseInt(ServletActionContext.getRequest().getParameter("vid"));
		Visit visit = visitService.findVisitByVid(vid);
		List<User> userList = userService.findAllUser();
		List<Customer> customerList = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("visit", visit);
		ServletActionContext.getRequest().setAttribute("userList", userList);
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "edit";
	}
	
	/**
	 * 编辑拜访
	 * @return
	 */
	public String edit() {
		visitService.update(visit);
		return "editSuccess";
	}
	
	/**
	 * 多条件查询
	 * @return
	 */
	public String findByCondition() {
		List<Visit> visitList = visitService.findByCondition(visit);
		ServletActionContext.getRequest().setAttribute("visitList", visitList);
		return "list";
	}
	
	/**
	 * 前往多条件查询页面
	 * @return
	 */
	public String toConditionPage() {
		List<User> userList = userService.findAllUser();
		List<Customer> customerList = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("userList", userList);
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "conditionPage";
	}
}
