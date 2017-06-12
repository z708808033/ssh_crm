package com.zzz.crm.customer.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzz.crm.customer.entity.Customer;
import com.zzz.crm.customer.entity.PageBean;
import com.zzz.crm.customer.service.CustomerException;
import com.zzz.crm.customer.service.CustomerService;
import com.zzz.crm.dict.entity.Dict;
import com.zzz.crm.dict.service.DictService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService customerService;
	private DictService dictService;
	private Customer customer = new Customer();
	private List<Customer> customerList = new ArrayList<Customer>();
	private String msg;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public String getMsg() {
		return msg;
	}
	public Customer getModel() {
		return customer;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * 添加客户
	 * @return
	 */
	public String addCustomer() {
		try {
			customerService.add(customer);
			msg = "添加成功!";
			return "addCustomerSuccess";
		} catch (CustomerException e) {
			msg = e.getMessage();
			return "addCustomerFail";
		}
	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public String findAllCustomer() {
		customerList = customerService.findAllCustomer();
		return "customerList";
	}
	
	/**
	 * 编辑客户之前的预处理工作
	 * @return
	 */
	public String preEdit() {
		customer = customerService.findCustomerByCid(customer.getCid());
		List<Dict> dictList = dictService.findAllDict();
		ServletActionContext.getRequest().setAttribute("dictList", dictList);
		return "editCustomer";
	}
	
	/**
	 * 编辑客户
	 * @return
	 */
	public String edit() {
		customerService.edit(customer);
		return "editSuccess";
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	public String delete() {
		customerService.delete(customer.getCid());
		return "deleteSuccess";
	}
	
	/**
	 * 分页查询
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String listPage() throws UnsupportedEncodingException {
		String cname = ServletActionContext.getRequest().getParameter("cname");
		if(ServletActionContext.getRequest().getMethod().equalsIgnoreCase("get")) {
			cname = new String(cname.getBytes("iso-8859-1"), "utf-8");
		}
		
		int currentPage = Integer.parseInt(ServletActionContext.getRequest().getParameter("currentPage"));
		PageBean pageBean = customerService.listPage(currentPage,cname);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		ServletActionContext.getRequest().setAttribute("cname", cname);
		return "listPage";
	}
	
	/**
	 * 多条件查询
	 * @return
	 */
	public String findByCondition() {
		customerList = customerService.findByCondition(customer);
		return "customerList";
	}
	
	/**
	 * 前往添加页面
	 * @return
	 */
	public String toAddPage() {
		System.out.println("来这里了");
		List<Dict> dictList = dictService.findAllDict();
		ServletActionContext.getRequest().setAttribute("dictList", dictList);
		return "add";
	}

	/**
	 * 按客户级别统计查询
	 * @return
	 */
	public String countLevel() {
		List list = customerService.countLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
	
	/**
	 * 按客户来源统计查询
	 * @return
	 */
	public String countSource() {
		List list = customerService.countSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
}
