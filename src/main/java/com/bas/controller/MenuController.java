package com.bas.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.bas.bean.Menu;
import com.bas.service.IMenuService;
import com.bas.service.IUserService;
import com.bas.util.DateUtil;


@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private static final Logger logger = Logger.getLogger(MenuController.class);

	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="menuService")
	private IMenuService menuService;
	
	@RequestMapping("/addmenu")
	public void addmenu(Menu vo,HttpServletResponse response)  throws Exception{
		try {
			String json="{\"message\":\"true\"}";
			if(vo!=null){
				boolean flag=menuService.isExistMenuNo(vo.getMenuNo().toString().trim());
				if(!flag){
					menuService.insertMenu(vo);
					json=JSONObject.toJSONString(vo);
				}
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (Exception e) {
			logger.info("添加失败");
			e.printStackTrace();
		}
	}
	@RequestMapping("/delmenu")
	public void delMenu(String id,HttpServletResponse response)  throws Exception{
		try {
			String json="{\"message\":\"true\"}";
	/*		if(vo!=null){
				boolean flag=menuService.isExistMenuNo(vo.getMenuNo().toString().trim());
				if(!flag){
					menuService.insertMenu(vo);
					json=JSONObject.toJSONString(vo);
				}
			}*/
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("删除失败");
			e.printStackTrace();
		}
	}
	/**
	 * 修改ztree
	 * @param vo
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/updatemenu")
	public void updateMenu(Menu vo,HttpServletResponse response)  throws Exception{
		try {
			String json="{\"message\":\"true\"}";
			if(vo!=null){
				vo.setUpdatetime(DateUtil.getCurrentDateTimeAsString());
			    menuService.updateMenu(vo);
				json=JSONObject.toJSONString(vo);
			}
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			response.getWriter().close();
		} catch (Exception e) {
			logger.info("修改失败");
			e.printStackTrace();
		}
	}
}
