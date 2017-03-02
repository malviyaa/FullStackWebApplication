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

import bean.CartBean;
import bean.CartStore;
import hashStore.CartHashStore;
import hashStore.SessionCartHashStore;

public class UserCart extends HttpServlet {
	String name, price, retailer, condition, username, type, id, discount, rebate, ProductOnSale, RetailerState,
			RetailerZip, RetailerCity, ManufacturerName, ManufacturerRebate;
	String accessory1, accessory2;
	static ArrayList<HashMap<String, String>> sessionList = new ArrayList<>();
	static ArrayList<HashMap<String, String>> userList = new ArrayList<>();
	HashMap<String, String> carthashmap = new HashMap<String, String>();
	int Totalprice, size, i = 1;
	String message;
	CartHashStore carthashstore = new CartHashStore();
	ServletContext context = null;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		// HttpSession session = request.getSession();
		sessionList = (ArrayList<HashMap<String, String>>) request.getSession().getAttribute("CartList");
		if (request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("remove")) {
			String itemName = request.getParameter("itemname").trim();

			Iterator<HashMap<String, String>> iterator = userList.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().get("name").equalsIgnoreCase(itemName)) {
					iterator.remove();
					break;
				}
			}
			message = "Item deleted from cart";
		}

		if (request.getParameter("name") != null) {
			username = request.getParameter("username");
			name = request.getParameter("id");
			id = request.getParameter("id");
			price = request.getParameter("price");
			retailer = request.getParameter("retailer");
			RetailerCity = request.getParameter("RetailerCity");
			RetailerZip = request.getParameter("RetailerZip");
			RetailerState = request.getParameter("RetailerState");
			ProductOnSale = request.getParameter("ProductOnSale");
			ManufacturerName = request.getParameter("ManufacturerName");
			ManufacturerRebate = request.getParameter("ManufacturerRebate");
			condition = request.getParameter("condition");
			accessory1 = request.getParameter("accessory1");
			accessory2 = request.getParameter("accessory2");

			CartBean cartbean = new CartBean(username, id, name, price, retailer, RetailerCity, RetailerZip,
					RetailerState, ProductOnSale, ManufacturerName, ManufacturerRebate, condition, accessory1,
					accessory2);

			carthashmap = CartStore.getInstance().storeCart(cartbean);

			carthashstore.setCarthash(carthashmap);

		}

		if (request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("remove")) {
			String itemName = request.getParameter("itemname").trim();

			carthashstore.remove(itemName);

		}

		userList = carthashstore.getCarthash();

		if (sessionList != null) {
			System.out.println("Session list is ============:" + sessionList);
			userList.addAll(sessionList);
			System.out.println("Userlist list is ======+++++=====:" + sessionList);
			request.removeAttribute("CartList");
			SessionCartHashStore.listofcart.clear();

		}

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

		out.println("<p><a href=/Best-Deal/paymentpage>");
		out.println("<img border=\"0\" alt=\"CHECKOUT\" src=visa.jpg width=\"200\" height=\"50\"></a></p>");
		out.println("<h2> Amount to pay$ " + carthashstore.totalprice(userList) + "</h2>");
		out.println("<h2> You have " + userList.size() + " items in your cart </h2>");
		out.println("<a href=/Best-Deal/home> Home </a>");

		for (HashMap<String, String> item : userList) {
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>  </h1>\n\n" + "<h5> Item " + (i++) + "</h5>" + "<h4> Item Name :" + item.get("name")
					+ "</h4>" + "<h4> Item Price :" + item.get("price") + "</h4>" + "<h4> Item Condition :"
					+ item.get("condition") + "</h4>" + "<h4> Item Accessory 1 :" + item.get("accessory1") + "</h4>"
					+ "<form action='/Best-Deal/usercart' method='get'>"
					+ "<input type='hidden' name='itemname' value='" + item.get("name") + "' />"
					+ "<input  name=\"action\" type=\"submit\" value='Remove'></form>");
			out.append(sb.toString());
		}
		out.println("</div>");
		utility.printHtml(basePath + "Footer.html");

	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getusername() {
		return username;
	}

	public void init(ServletConfig config) {
		context = config.getServletContext();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		processRequest(request, response);

	}
}
