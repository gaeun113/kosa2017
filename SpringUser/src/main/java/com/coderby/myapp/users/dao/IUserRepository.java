package com.coderby.myapp.users.dao;

import java.util.List;

import com.coderby.myapp.users.model.UserVO;

public interface IUserRepository {

	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(String userId, String userPassword);
	UserVO selectUser(String userId);
	List<UserVO> selectAllUser();
	String getPassword(String userId);
	
}
