package com.bas.service;

import com.bas.bean.User;

public interface IUserService {
	public User getUserById(Integer id);
	public User getUserByUserName(String username);

}
