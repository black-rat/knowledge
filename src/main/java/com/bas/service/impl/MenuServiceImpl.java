package com.bas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bas.bean.Menu;
import com.bas.dao.MenuMapper;
import com.bas.service.IMenuService;

@Service(value="menuService")
public class MenuServiceImpl implements IMenuService {

	@Resource(name="menuMapper")
	MenuMapper menudao;
	@Override
	public Menu selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menudao.getAllMenu();
	}

	@Override
	public Menu getMenuById(Integer id) {
		// TODO Auto-generated method stub
		return menudao.selectByPrimaryKey(id);
	}

	@Override
	public List<Menu> getMenuByParentId(Integer id) {
		// TODO Auto-generated method stub
		return menudao.getAllMenuByparentId(id);
	}

}
