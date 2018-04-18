package com.bas.service;

import java.util.List;

import com.bas.bean.Menu;

public interface IMenuService {
	
	public  Menu selectByPrimaryKey(Integer id);
	
	public List<Menu> getAllMenu();
	
	public Menu getMenuById(Integer id);
	
	public List<Menu> getMenuByParentId(Integer id);

}
