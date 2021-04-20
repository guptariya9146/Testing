package com.nagarro.user.model;

import java.util.List;

public class UserResponse {

	List<Users> userList;
	Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

}
