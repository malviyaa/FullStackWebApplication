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

public class OrderList extends HttpServlet {
	ServletContext context = null;
	String message;
	ArrayList<HashMap<String, String>> listoforder = new ArrayList<>();

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

		if (request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("remove")) {
			String orderId = request.getParameter("orderId").trim();

			Iterator<HashMap<String, String>> iterator = listoforder.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().get("idOrderdetail").equalsIgnoreCase(orderId)) {
					iterator.remove();
					MySqlDataStoreUtilities.getInstance().removeOrder(orderId);
					break;
				}
			}
			message = "order deleted from cart";
		}
		listoforder = MySqlDataStoreUtilities.getInstance().getorderdetails(username);

		showPage(response, request, username, message);

	}

	protected void showPage(HttpServletResponse response, HttpServletRequest request, String username, String message)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		int i = 1;
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());
		utility.printHtml(basePath + "LeftNavigationBar.html");
		PrintWriter out = response.getWriter();

		out.println("<h2> You have " + listoforder.size() + " Orders done in account </h2>");
		out.println("<a href=/Best-Deal/home> Home </a>");

		for (HashMap<String, String> item : listoforder) {
			StringBuilder sb = new StringBuilder();

			if (username.equals("Salesman@iit.edu")) {
				sb.append("<h1>  </h1>\n\n" + "<h5> Customer " + (i++) + "</h5>" + "<h4> Order Id :"
						+ item.get("idOrderdetail") + "<h4> Item name :" + item.get("name") + "</h4>"
						+ "<h4> Item price :" + item.get("price") + "</h4>" + "<h4> Retailer :" + item.get("retailer")
						+ "</h4>" + "<h4> Username :" + item.get("username") + "</h4>"
						+ "<form action='/Best-Deal/orderlist' method='get'>"
						+ "<input type='hidden' name='orderId' value='" + item.get("idOrderdetail") + "' />"
						+ "<input  name=\"action\" type=\"submit\" value='Remove'></form>");
				out.append(sb.toString());
			} else {
				sb.append("<h1>  </h1>\n\n" + "<h4> Order Id :" + item.get("idOrderdetail") + "<h4> Item name :"
						+ item.get("name") + "</h4>" + "<h4> Item price :" + item.get("price") + "</h4>"
						+ "<h4> Retailer :" + item.get("retailer") + "</h4>" + "<h4> Username :" + item.get("username")
						+ "</h4>" + "<form action='/Best-Deal/orderlist' method='get'>"
						+ "<input type='hidden' name='orderId' value='" + item.get("idOrderdetail") + "' />"
						+ "<input  name=\"action\" type=\"submit\" value='Remove'></form>");
				out.append(sb.toString());
			}
		}

		out.println("</div>");
		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

}
