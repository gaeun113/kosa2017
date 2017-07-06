package com.coderby.myapp.users.model;

public class UserVO {

	private String userId;
	private String userName;
	private String userPassword;
	private String userRole;
//	private String checkUserPassword;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "사용자 [아이디= " + userId + ", 이름= " + userName + ", 비밀번호= " + userPassword + ", 권한= "
				+ userRole + "]";
	}
	
}
