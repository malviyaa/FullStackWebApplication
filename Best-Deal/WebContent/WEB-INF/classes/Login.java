
import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;

import org.apache.catalina.Session;


public class Login extends HttpServlet{

	ServletContext context = null;

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
		 HttpSession session = request.getSession(false);
		 session.invalidate();
					response.setContentType("text/html"); 
					PrintWriter pw = response.getWriter();
					Utilities utility = new Utilities(pw);
					String basePath = context.getRealPath("") + "/";
					utility.printHtml(basePath + "Header.html"); 
					utility.printHtml(basePath + "LeftNavigationBar.html"); 
					utility.printHtml(basePath + "login.html"); 
					utility.printHtml(basePath + "Footer.html");

	} 

}