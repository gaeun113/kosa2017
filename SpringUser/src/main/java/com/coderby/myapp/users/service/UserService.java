package com.coderby.myapp.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderby.myapp.users.dao.IUserRepository;
import com.coderby.myapp.users.model.UserVO;

@Service
@Transactional("txManager") //이름이 완전 똑같은 경우가 아니라면 따로 지정
public class UserService implements IUserService {

//	의존성 주입
	@Autowired
	IUserRepository userRepository;
	

	@Override
	public void insertUser(UserVO user) {
		userRepository.insertUser(user);
	}

	@Override
	public void updateUser(UserVO user) {
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String userId, String userPassword) {
		userRepository.deleteUser(userId, userPassword);
	}

	@Override
	public UserVO selectUser(String userId) {
		return userRepository.selectUser(userId);
	}

	@Override
	public List<UserVO> selectAllUser() {
		return userRepository.selectAllUser();
	}

	@Override
	public boolean checkPassword(String userId, String userPassword) {
		String pw = userRepository.getPassword(userId);
		if(pw != null && pw.equals(userPassword)) {
			return true;
		} else {
			return false;
		}
//		굳이 try 블록으로 안 묶어도 괜찮음
	}

}
