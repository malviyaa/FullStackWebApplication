import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MySqlDataStoreUtilities;

public class CustomerStore extends HttpServlet {
	ServletContext context = null;
	String message;
	static ArrayList<HashMap<String, String>> listofcustomer = new ArrayList<>();

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

		String username = (String) request.getSession().getAttribute("username");
		listofcustomer = MySqlDataStoreUtilities.getInstance().getsalesmanclients(username);
		if (request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("remove")) {
			String itemName = request.getParameter("username").trim();
			System.out.println("===1=====" + itemName);
			Iterator<HashMap<String, String>> iterator = listofcustomer.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().get("username").equalsIgnoreCase(itemName)) {
					System.out.println("===2=====" + itemName);
					iterator.remove();
					MySqlDataStoreUtilities.getInstance().removesalesmanclients(itemName);
					break;
				}
			}
			message = "Item deleted from cart";
		}
		listofcustomer = MySqlDataStoreUtilities.getInstance().getsalesmanclients(username);
		showPage(response, request, message);

	}

	protected void showPage(HttpServletResponse response, HttpServletRequest request, String message)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		int i = 1;
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());
		utility.printHtml(basePath + "LeftNavigationBar.html");
		PrintWriter out = response.getWriter();

		out.println("<h2> You have " + listofcustomer.size() + " customers account </h2>");
		out.println("<a href=/Best-Deal/home> Home </a>");

		for (HashMap<String, String> item : listofcustomer) {
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>  </h1>\n\n" + "<h5> Customer " + (i++) + "</h5>" + "<h4> Custumer name :" + item.get("name")
					+ "</h4>" + "<h4> Gender :" + item.get("gender") + "</h4>" + "<h4> Age :" + item.get("age")
					+ "</h4>" + "<h4> Username :" + item.get("username") + "</h4>"
					+ "<form action='/Best-Deal/customerlist' method='get'>"
					+ "<input type='hidden' name='username' value='" + item.get("username") + "' />"
					+ "<input  name=\"action\" type=\"submit\" value='Remove'></form>");
			out.append(sb.toString());
		}
		out.println("</div>");
		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

}
