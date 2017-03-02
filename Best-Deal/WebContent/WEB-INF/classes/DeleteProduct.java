
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MySqlDataStoreUtilities;

public class DeleteProduct extends HttpServlet {

	ServletContext context = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		processRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = request.getSession();

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());

		utility.printHtml(basePath + "LeftNavigationBar.html");

		String name = request.getParameter("name");
		MySqlDataStoreUtilities.getInstance().deleteProduct(name);

		pw.println("<h1>  </h1>");
		pw.println("<h2> Your product " + name + "is successfully deleted!! </h2>");

		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		System.out.println("Printing context");
		context = config.getServletContext();
	}

}