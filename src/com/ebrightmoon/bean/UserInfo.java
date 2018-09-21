package com.ebrightmoon.bean;

/**
 * 
 * @author Administrator
 * user_id              int not null auto_increment,
   user_name            char(16),
   sex                  char(4),
   user_pwd             varchar(50),
   mobile               char(11),
   user_email           varchar(50),
   gen_time             timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   login_time           timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   last_login_time      timestamp DEFAULT CURRENT_TIMESTAMP,
   token                varchar(50),
   primary key (user_id)
 */
public class UserInfo {

	private int userId;
	private String userName;
	private String sex;
	private String userPwd;
	private String mobile;
	private String userEmail;
	private long genTime;
	private long loginTime;
	private long lastLoginTime;
	private String token;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getGenTime() {
		return genTime;
	}
	public void setGenTime(long genTime) {
		this.genTime = genTime;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
