package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>用户登录</title>\r\n");
      out.write("    <script src=\"./static/util/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./static/css/login.css\"  style=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<div class=\"logo_box\">\r\n");
      out.write("\t<h3>亲哈社区欢迎你</h3>\r\n");
      out.write("\t<form action=\"#\" name=\"f\" method=\"post\">\r\n");
      out.write("\t\t<div class=\"input_outer\">\r\n");
      out.write("\t\t\t<span class=\"u_user\"></span>\r\n");
      out.write("\t\t\t<input name=\"logname\" class=\"text\" onFocus=\" if(this.value=='输入ID或用户名登录') this.value=''\" onBlur=\"if(this.value=='') this.value='输入ID或用户名登录'\" value=\"输入ID或用户名登录\" style=\"color: #FFFFFF !important\" type=\"text\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"input_outer\">\r\n");
      out.write("\t\t\t<span class=\"us_uer\"></span>\r\n");
      out.write("\t\t\t<label class=\"l-login login_password\" style=\"color: rgb(255, 255, 255);display: block;\">输入密码</label>\r\n");
      out.write("\t\t\t<input name=\"logpass\" class=\"text\" style=\"color: #FFFFFF !important; position:absolute; z-index:100;\" onFocus=\"$('.login_password').hide()\" onBlur=\"if(this.value=='') $('.login_password').show()\" value=\"\" type=\"password\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"mb2\"><a class=\"act-but submit\" href=\"javascript:;\" style=\"color: #FFFFFF\">登录</a></div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
