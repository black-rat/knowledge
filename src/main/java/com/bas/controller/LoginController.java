package com.bas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
			   mav.setViewName("index");
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
  @RequestMapping("/menu")
  public void  getMenu(HttpServletRequest request,HttpServletResponse response) throws Exception{
	  // Node tree = getTreeJson();//获得一棵树模型的数据
	   //List<Menu> tree = menuService.getAllMenu();
	   String json = getSysOrganizeByParentIdJSON("0");
	   json=json.substring(0, json.length()-1);
	   response.setCharacterEncoding("utf-8");
       response.getWriter().write(json);
       response.getWriter().close();
   }
private String getSysOrganizeByParentIdJSON(String id){
      String sonNodes=""; 
      List<Menu> reslist = menuService.getMenuByParentId(Integer.valueOf(id));
      for(Menu menu : reslist){
          sonNodes+="{ text: '"+menu.getName()+"', id: '"+menu.getId()+"'";
          if(!getSysOrganizeByParentIdJSON(menu.getId().toString()).isEmpty()){
              sonNodes+= ", nodes: ["+getSysOrganizeByParentIdJSON(menu.getId().toString())+"] ";
          }
          sonNodes+= "},";
      }
      return sonNodes;
  }


}
