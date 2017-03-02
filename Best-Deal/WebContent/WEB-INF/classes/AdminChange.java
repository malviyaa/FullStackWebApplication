import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminChange extends HttpServlet {

	ServletContext context = null;

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		processRequest(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		processRequest(request, response);

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		java.io.PrintWriter out = response.getWriter();
		HttpSession admin = request.getSession();
		String name = request.getParameter("name");
		String price = request.getParameter("price");

		System.out.println(name);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());

		utility.printHtml(basePath + "LeftNavigationBar.html");

		String page = "<div class=\"form-group\">" +

				"<label for=\"lg_username\" class=\"sr-only\">price</label>"
				+ "<input type=\"text\" name=\"price\" placeholder=\"Name\" value=" + price + ">" + "</div>"
				+ "<div class=\"form-group\">" + "<label for=\"lg_username\" class=\"sr-only\">Item name</label>"
				+ "<input type=\"text\" name=\"name\" placeholder=\"Name\" value=" + name + ">";

		out.println(page);

		utility.printHtml(basePath + "Footer.html");

	}
}
