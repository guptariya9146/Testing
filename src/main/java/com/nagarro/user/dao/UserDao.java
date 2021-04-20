package com.nagarro.user.dao;

import java.util.List;

import com.nagarro.user.model.Users;

public interface UserDao {

	void save(Users user);

	Users get(int userId);

	void delete(int userId);

	List<Users> list();

	Users update(int id, Users user);

	boolean isUserExist(String username);

}
