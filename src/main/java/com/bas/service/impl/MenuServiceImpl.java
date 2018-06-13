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
	public List<Menu> getAllMenu() {
		return menudao.getAllMenu();
	}
	@Override
	public List<Menu> getMenuByParentId(Integer id) {
		return menudao.getAllMenuByparentId(id);
	}
	@Override
	public void insertMenu(Menu vo) {
		// TODO Auto-generated method stub
		 menudao.insertMenu(vo);
	}
	@Override
	public boolean isExistMenuNo(String menuNo) {
		// TODO Auto-generated method stub
		Integer num=this.menudao.isExistMenuNo(menuNo);
		if(num!=null&&num>0){
			return true;
		}
		return false;
	}
	@Override
	public void updateMenu(Menu vo) {
		// TODO Auto-generated method stub
		this.menudao.updateMenu(vo);
	}

}
