package com.bas.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bas.bean.User;

/**
 * springMvc 常见传值方式
 * @author lizhao
 *
 */

@Controller
@RequestMapping(value="/example")
public class SpringmvcByValue {
	
	@RequestMapping(value = "")
	public String helloWorld(Model model){
	    model.addAttribute("message", "Hello World");
	    return "example/example";
	}
/**
 * 最原始的方式
 * @param request
 * @param response
 * @return
 */
/*	@RequestMapping(value="/tradition")
	public String tradtion(HttpServletRequest request,HttpServletResponse response){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+"------------"+password);
		return "example/example";
	}*/
	/**
	 * 使用注解后，后台这样写形参，前台传的参数，会自动封装到形参里面，
	 * 但这个是基于同名配置的规则，前台参数的名称， 要和后台形参名一致
	 * @param username
	 * @param password
	 * @return
	 */
/*	@RequestMapping(value="/tradition")
	public String tradtion(String username,String password){
		System.out.println(username+"------------"+password);
		return "example/example";
	}*/
	/**
	 * 前后台参数不一致 使用 requestParam
	 * @RequestParam(value="name"String username):表明前台的传的参数名称叫name，
	 * 要往username里面注入当前台名字和形参不一致，可以使用@RequestParam注解进行映射
	 * required=true，表示前台的参数是不是必须要传，默认是true必须要传  
     *defaultValue：表示前台没有传，我就给一个设置的默认值，这里设置的是haha，当没有前台没有传，我就显示haha
	 * @param name
	 * @param password
	 * @return
	 */
/*	@RequestMapping(value="/tradition")
	public String tradtion(@RequestParam(value="username",required=true,defaultValue="默认值")String name,String password){
		System.out.println(name+"------------"+password);
		return "example/example";
	}*/
	/**
	 * springmvc也是支持模型传参的
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/tradition")
	public String tradtion(User user){
		System.out.println(user.username+"------------"+user.password);
		return "example/example";
	}
	/**
	 * 那一串是做为参数传到后台的，这种是restful的风格
	 * 上占位符，此时前台参数是注入不到后台的，得加一个注解来映射
	 * @param name
	 * @return
	 */
/*	@RequestMapping(value="/tradition/{username}")
	public String tradtion(@PathVariable(value="username") String name){
		System.out.println(name);
		return "example/example";
	}*/
}
