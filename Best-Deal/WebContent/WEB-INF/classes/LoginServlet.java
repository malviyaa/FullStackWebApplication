
/*
 * LoginServlet.java
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MySqlDataStoreUtilities;

public class LoginServlet extends HttpServlet {
	static ArrayList<HashMap<String, String>> sessionList = new ArrayList<>();
	static ArrayList<HashMap<String, String>> listofcart = new ArrayList<>();
	String fullName;

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

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HashMap<String, HashMap<String, String>> dbuserdetails = MySqlDataStoreUtilities.getInstance()
				.selectUser(username);
		HashMap<String, String> dbuservalue = dbuserdetails.get(username);
		String printpassword = dbuservalue.get("password");

		if (dbuservalue.get("password").equals(password)) {
			sessionList = Cart.listofcart;
			System.out.println("Login session list vaue" + sessionList);
			// Cart.listofcart.clear();

			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("CartList", sessionList);
			request.getSession().setAttribute("type",
					MySqlDataStoreUtilities.getInstance().selectUser(username).get(username).get("type"));
			System.out.println("type of      salesmam"
					+ MySqlDataStoreUtilities.getInstance().selectUser(username).get(username).get("type"));
			System.out.println("Print in login " + request.getSession().getAttribute("CartList"));

			if (username.equals("Admin@iit.edu")) {
				response.sendRedirect("/Best-Deal/adminServlet");
			} else if (username.equals("Salesman@iit.edu")) {
				response.sendRedirect("/Best-Deal/salesmanServlet");
			}

			else {

				response.sendRedirect("/Best-Deal/customerServlet");
			}
		}

		else {
			showPage(response, "Login Failure! You must enter a correct username and password");
		}

	}

	protected void showPage(HttpServletResponse response, String message) throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Best Deal Login</title>");
		out.println("<a href=home> Home </a>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>" + message + "</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
