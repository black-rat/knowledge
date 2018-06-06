package com.bas.service;

import java.util.List;

import com.bas.bean.Menu;

public interface IMenuService {
	
	
	public List<Menu> getAllMenu();
	
	
	public List<Menu> getMenuByParentId(Integer id);

	public void insertMenu(Menu vo);
	/**
	 * 判断是否存在相同菜单编码
	 * @param menuNo
	 * @return
	 */
	public boolean isExistMenuNo(String menuNo);
}
