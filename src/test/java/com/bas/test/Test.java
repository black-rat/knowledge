package com.bas.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bas.bean.Menu;
import com.bas.bean.User;
import com.bas.service.IMenuService;
import com.bas.service.IUserService;
import com.bas.util.TreeUtil;
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
	@Resource
	private IMenuService menuService;
	
	@org.junit.Test
	public void query(){
		
		//User user=userService.getUserById(1);
		List<Menu> ls=menuService.getAllMenu();
		TreeUtil.getTreeJson(ls);
		
	}
}
