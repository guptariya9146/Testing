package com.nagarro.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.user.dao.UserDao;
import com.nagarro.user.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private Connection connection;

	@Override
	public void save(Users user) {
		userDao.save(user);

	}

	@Override
	public Users get(int userId) {
		return userDao.get(userId);
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);

	}

	@Override
	public List<Users> list() {
		return userDao.list();
	}

	@Override
	public boolean isUserExist(String username) {

		return userDao.isUserExist(username);
	

	}

	@Override
	public Users update(int id, Users user) {

		return userDao.update(id, user);
	}

}
