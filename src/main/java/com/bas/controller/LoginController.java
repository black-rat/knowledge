package com.bas.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.bas.bean.Menu;
import com.bas.bean.User;
import com.bas.service.IMenuService;
import com.bas.service.IUserService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="menuService")
	private IMenuService menuService;
	
	@RequestMapping("/sign")
	public ModelAndView login(String username,String password) {
		logger.info("username=="+username);
		ModelAndView mav=new ModelAndView();
		
	   User user=userService.getUserByUserName(username);
	   if(user!=null){
		   if(password!=null&&password.equals(user.getPassword())){
			   mav.setViewName("main");
			   mav.addObject(user);
		   }else{
			   mav.setViewName("login");
		   }
	   }else{
		   mav.setViewName("login");
	   }
	 
	  return mav;
	}
    @RequestMapping(value = "/loginout")
	public String loginout(HttpServletRequest request,HttpServletResponse response){
		
		return "login";
	}
/*  @RequestMapping("/menu")
  public void  getMenu(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   List<Menu> tree = menuService.getAllMenu();
	   String json = TreeUtil.getTreeJson(tree);
	   response.setCharacterEncoding("utf-8");
       response.getWriter().write(json);
       response.getWriter().close();
   }*/
    @RequestMapping("/menu")
    public void getMenu(HttpServletRequest request,HttpServletResponse response) throws Exception{
  	   List<Menu> tree = menuService.getAllMenu();
  	   String json = JSONArray.toJSONString(tree);
	   response.setCharacterEncoding("utf-8");
       response.getWriter().write(json);
       response.getWriter().close();
     }
}
