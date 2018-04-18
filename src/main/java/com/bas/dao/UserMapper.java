package com.bas.dao;

import org.springframework.stereotype.Repository;
import com.bas.bean.User;

@Repository(value="userMapper")
public interface UserMapper {

	public User getUserById(Integer id);
	
	public User getUserByUserName(String username);
}
