package com.bas.test;

import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bas.bean.User;
import com.bas.service.IUserService;
/**
 * 
 * @author lizhao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class Test {
	@Resource
	private IUserService userService;
	
	@org.junit.Test
	public void query(){
		
		User user=userService.getUserById(1);
		
		System.out.println(user.getUsername());
	}
}
