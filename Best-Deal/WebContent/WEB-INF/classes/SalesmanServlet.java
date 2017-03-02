import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SalesmanServlet extends HttpServlet {

	ServletContext context = null;

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession customer = request.getSession();
		String name = (String) customer.getAttribute("name");
		PrintWriter out = response.getWriter();
		System.out.println(name);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());

		utility.printHtml(basePath + "LeftNavigationBar.html");
		// out.println("<form action='/Best-Deal/addcustomer' method='get'>");
		//
		// out.println("<input type='submit' value='Add customer' />");
		utility.printHtml(basePath + "Content.html");

		utility.printHtml(basePath + "Footer.html");

	}

}
