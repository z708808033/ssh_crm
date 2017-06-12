package com.zzz.crm.linkman.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzz.crm.customer.entity.Customer;
import com.zzz.crm.customer.entity.PageBean;
import com.zzz.crm.customer.service.CustomerService;
import com.zzz.crm.linkman.entity.Linkman;
import com.zzz.crm.linkman.service.LinkmanService;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman>{
	private LinkmanService linkmanService;
	private CustomerService customerService;
	private Linkman linkman = new Linkman();
	private File upload;			//实现文件上传需要封装两个对象,对象的名称有规范限制,文件对应表单的name,而文件的名称则是在表单的name属性值后面加上FileName
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public Linkman getModel() {
		return linkman;
	}
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String toAddPage() {
		List<Customer> customerList = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "add";
	}
	
	/**
	 * 添加联系人
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException {
		//struts的上传文件大小限制默认是2M,可以通过修改struts配置文件来修改上传大小限制
		File serverFile = new File("G:/" + uploadFileName);
		FileUtils.copyFile(upload, serverFile);
		
		Integer cid = Integer.parseInt(ServletActionContext.getRequest().getParameter("cid"));
		linkmanService.add(linkman,cid);
		String msg = "添加成功!";
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "addSuccess";
	}
	
	/**
	 * 查询联系人
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String findLinkman() throws UnsupportedEncodingException{
		String lname = ServletActionContext.getRequest().getParameter("lname");
		if(lname != null) {
			if(ServletActionContext.getRequest().getMethod().equalsIgnoreCase("get")) {
				lname = new String(lname.getBytes("iso-8859-1"), "utf-8");
			}
		} else {
			lname = "";
		}
		Integer currentPage = 1;
		if(ServletActionContext.getRequest().getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(ServletActionContext.getRequest().getParameter("currentPage"));
		}
		PageBean pageBean = linkmanService.findAllLinkman(currentPage,lname);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		ServletActionContext.getRequest().setAttribute("lname", lname);
		return "list";
	}
	
	/**
	 * 修改前的预处理
	 * @return
	 */
	public String preEdit() {
		Integer lid = Integer.parseInt(ServletActionContext.getRequest().getParameter("lid"));
		Linkman linkman = linkmanService.findLinkmanByLid(lid);
		List<Customer> customerList = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("linkman", linkman);
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "edit";
	}
	
	/**
	 * 编辑联系人
	 * @return
	 */
	public String edit() {
		linkmanService.update(linkman);
		return "editSuccess";
	}
	
	/**
	 * 删除联系人
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String delete() throws UnsupportedEncodingException {
		Integer lid = Integer.parseInt(ServletActionContext.getRequest().getParameter("lid"));
		linkmanService.delete(lid);
		return findLinkman();
	}
	
	/**
	 * 前往多条件查询页面
	 * @return
	 */
	public String toConditionPage() {
		List<Customer> customerList = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "conditionPage";
	}
	
	/**
	 * 多条件查询
	 * @return
	 */
	public String findByCondition() {
		List<Linkman> linkmanList = linkmanService.findByCondition(linkman);
		ServletActionContext.getRequest().setAttribute("linkmanList", linkmanList);
		return "list2";
	}
}
