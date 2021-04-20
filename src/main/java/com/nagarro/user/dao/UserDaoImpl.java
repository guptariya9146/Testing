package com.nagarro.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nagarro.user.model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Users user) {

		String sql = "INSERT INTO user_table (username,firstname,lastname,email,phone)" + " VALUES (?, ?, ?, ?,?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail(),
				user.getPhone());

	}

	@Override
	public void delete(int userId) {

		String sql = "DELETE FROM user_table WHERE id=?";
		jdbcTemplate.update(sql, userId);

	}

	@Override
	public Users get(int userId) {
		String sql = "SELECT * FROM user_table WHERE id=" + userId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {

			@Override
			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Users userobj = new Users();
					userobj.setId(rs.getInt("id"));
					userobj.setUsername((rs.getString("username")));
					userobj.setFirstname(rs.getString("firstname"));
					userobj.setLastname(rs.getString("lastname"));
					userobj.setEmail(rs.getString("email"));
					userobj.setPhone(rs.getString("phone"));
					return userobj;
				}

				return null;
			}

		});
	}

	@Override
	public List<Users> list() {
		String sql = "SELECT * FROM user_table";
		List<Users> listUser = jdbcTemplate.query(sql, new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users userobj = new Users();
				userobj.setId(rs.getInt("id"));
				userobj.setUsername((rs.getString("username")));
				userobj.setFirstname(rs.getString("firstname"));
				userobj.setLastname(rs.getString("lastname"));
				userobj.setEmail(rs.getString("email"));
				userobj.setPhone(rs.getString("phone"));
				return userobj;

			}

		});

		return listUser;
	}

	@Override
	public Users update(int id, Users user) {
		String sql = "UPDATE user_table SET username=?,firstname=?,lastname=?, email=?,phone=?" + "WHERE id=?";
		jdbcTemplate.update(sql, user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail(),
				user.getPhone(), user.getId());
		return user;

	}
	
	
	@Override
	public boolean isUserExist(String username)
	{
		 String sql = "SELECT count(*) FROM user_table WHERE username= ?";

		  int count = jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);

		    return count > 0;
	}
		
	}
	
	


		
	


