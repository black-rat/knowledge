package com.bas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bas.bean.Menu;

@Repository(value="menuMapper")
public interface MenuMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);


    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    /**
     * 初始化所有菜单
     * @return
     */
    public List<Menu> getAllMenu();
    
    public List<Menu> getAllMenuByparentId(Integer id);
}