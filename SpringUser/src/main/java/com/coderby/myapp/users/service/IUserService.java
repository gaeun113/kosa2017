package com.coderby.myapp.users.service;

import java.util.List;

import com.coderby.myapp.users.model.UserVO;

public interface IUserService {

	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(String userId, String userPassword);
	UserVO selectUser(String userId);
	List<UserVO> selectAllUser();
	boolean checkPassword(String userId, String userPassword);
	
}
