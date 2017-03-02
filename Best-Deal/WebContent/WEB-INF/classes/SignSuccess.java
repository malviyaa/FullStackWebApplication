import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignSuccess extends HttpServlet {

	

	ServletContext context = null;

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
		 			 HttpSession admin= request.getSession();
		 			 String name = (String)admin.getAttribute("name");
		 			 System.out.println(name);
					response.setContentType("text/html"); 
					PrintWriter pw = response.getWriter();
					Utilities utility = new Utilities(pw);
					String basePath = context.getRealPath("") + "/";
					utility.printHeader(basePath + "Header.html", request.getSession());

					utility.printHtml(basePath + "LeftNavigationBar.html"); 
					utility.printHtml(basePath + "signSuccess.html"); 
					
					utility.printHtml(basePath + "Footer.html");

	} 

}

