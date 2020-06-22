package com.myweb.domain;

import java.util.Date;

public class MemberVO {

	private int usernum;
	private String userId;
	private String password;
	//private String nickname;
	private String email;
	private int authority;
	//private int declaration;
	//private Date last_login;
	//private Date create_time;
	//private Date update_time;
	private Date regd8;
	
	private String domain;

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public Date getRegd8() {
		return regd8;
	}

	public void setRegd8(Date regd8) {
		this.regd8 = regd8;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	
	
}