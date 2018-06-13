package com.bas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bas.bean.Menu;

@Repository(value="menuMapper")
public interface MenuMapper {

    /**
     * 初始化所有菜单
     * @return
     */
    public List<Menu> getAllMenu();
    
    public List<Menu> getAllMenuByparentId(Integer id);
    /**
     * 新增菜单
     * @param vo
     */
    public void insertMenu(Menu vo);
    /**
     * 判断节点是否存在
     * @param menuNo
     * @return
     */
    public Integer isExistMenuNo(String menuNo);
    /**
     * 修改当前节点
     * @param vo
     */
    public void updateMenu(Menu vo);
}