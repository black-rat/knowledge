package com.bas.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bas.bean.User;
import com.bas.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/sign")
	public String login(Model model) {
	   User user=	userService.getUserById(1);
		return "index";
	}

}
