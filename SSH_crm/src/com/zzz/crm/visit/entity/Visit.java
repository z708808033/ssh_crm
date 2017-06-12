package com.zzz.crm.visit.entity;

import com.zzz.crm.customer.entity.Customer;
import com.zzz.crm.user.entity.User;

public class Visit {
	private Integer vid;
	private String visitAddress;
	private String visitContent;
	private Customer customer;
	private User user;
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVisitAddress() {
		return visitAddress;
	}
	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}
	public String getVisitContent() {
		return visitContent;
	}
	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
