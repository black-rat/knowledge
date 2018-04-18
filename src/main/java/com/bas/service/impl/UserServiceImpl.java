package com.bas.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bas.bean.User;
import com.bas.dao.UserMapper;
import com.bas.service.IUserService;

@Service(value="userService")
public class UserServiceImpl implements IUserService {
	
	@Resource(name="userMapper")
	UserMapper userdao;
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userdao.getUserById(id);
	}
	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userdao.getUserByUserName(username);
	}

}
