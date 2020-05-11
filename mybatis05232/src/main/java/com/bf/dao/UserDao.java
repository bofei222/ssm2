package com.bf.dao;

import com.bf.pojo.User;

import java.util.List;

public interface UserDao {
	User findUserById(Integer id);
	
	List<User> findUserByUserName(String username);

	int insertUser(User user);
}
