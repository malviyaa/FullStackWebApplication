import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MySqlDataStoreUtilities;

public class PaymentSuccess extends HttpServlet {

	String fullName;
	ServletContext context = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		processRequest(request, response);
	}

	public void init(ServletConfig config) {
		context = config.getServletContext();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String randomordernumber = UUID.randomUUID().toString();

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());

		// utility.printHtml(basePath + "LeftNavigationBar.html");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 14); // Adding 14 days
		String delieverydate = sdf.format(c.getTime());

		sb.append(" <form action='/Best-Deal/home' method='get'>" + "<h1> Your Payment is successful  </h1>\n\n"
				+ "<h5> Your order is placed</h5>" + "<h4>  Order Number: " + randomordernumber + "</h4>"
				+ "<h4>Expected delivery date is:" + delieverydate + "</h4>"
				+ "<input  name=\"action\" type=\"submit\" value='Cancel Order'></form>");

		MySqlDataStoreUtilities.getInstance().insertItemDetails(UserCart.userList, randomordernumber, delieverydate);
		UserCart.userList.clear();
		out.append(sb.toString());
		utility.printHtml(basePath + "Footer.html");
	}

	protected void showPage(HttpServletResponse response, String message) throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

	}

}