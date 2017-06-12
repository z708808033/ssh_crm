package com.zzz.crm.user.entity;

import java.util.Set;

import com.zzz.crm.visit.entity.Visit;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private Set<Visit> userVisitSet;
	public Set<Visit> getUserVisitSet() {
		return userVisitSet;
	}
	public void setUserVisitSet(Set<Visit> userVisitSet) {
		this.userVisitSet = userVisitSet;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + "]";
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
