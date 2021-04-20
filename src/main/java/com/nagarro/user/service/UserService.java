package com.nagarro.user.service;

import java.util.List;

import com.nagarro.user.model.Users;

public interface UserService {

	void save(Users user);

	Users get(int userId);

	void delete(int userId);

	List<Users> list();

	boolean isUserExist(String username);

	Users update(int id, Users user);

}
