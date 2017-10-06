import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import bean.CartStore;
import hashStore.SessionCartHashStore;

public class Cart extends HttpServlet {
	String name, price, retailer, condition, username, type, id, discount, rebate, ProductOnSale, RetailerState,
			RetailerZip, RetailerCity, ManufacturerName, ManufacturerRebate,accessory1,accessory2;
	static ArrayList<HashMap<String, String>> sessionList = new ArrayList<HashMap<String, String>>();
	static ArrayList<HashMap<String, String>> listofcart = new ArrayList<HashMap<String, String>>();
	ArrayList<HashMap<String, String>> userList;
	HashMap<String, String> carthashmap = new HashMap<String, String>();
    int Totalprice, size;
	SessionCartHashStore carthashStore = new SessionCartHashStore();
	ServletContext context = null;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		HttpSession session = request.getSession();
		String message = null;
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

		// carthashmap = CartStore.getInstance().storeCart(username, id, name,
		// price, retailer, RetailerCity, RetailerZip,
		// RetailerState, ProductOnSale, ManufacturerName, ManufacturerRebate,
		// condition, accessory1, accessory2);
		// listofcart.add(carthashmap);
		// carthashStore.setCarthash(carthashmap);
		// session.setAttribute("CartList", listofcart);
		// sessionList = (ArrayList<HashMap<String, String>>)
		// session.getAttribute("CartList");
		// System.out.println("Session list is " + sessionList);
		//
		CartBean hashcartbean = new CartBean(username, id, name, price, retailer, RetailerCity, RetailerZip,
				RetailerState, ProductOnSale, ManufacturerName, ManufacturerRebate, condition, accessory1, accessory2);

		carthashmap = CartStore.getInstance().storeCart(hashcartbean);
		System.out.println(carthashmap);
		carthashStore.setCarthash(carthashmap);

		if (request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("remove")) {
			String itemName = request.getParameter("itemname").trim();
			carthashStore.remove(itemName);

		}
		listofcart= carthashStore.getCarthash();

		// if (request.getParameter("action") != null &&
		// request.getParameter("action").equalsIgnoreCase("remove")) {
		// String itemName = request.getParameter("itemname").trim();
		//
		// Iterator<HashMap<String, String>> iterator = listofcart.iterator();
		// while (iterator.hasNext()) {
		// if (iterator.next().get("name").equalsIgnoreCase(itemName)) {
		// iterator.remove();
		// break;
		// }
		// }
		// message = "Item deleted from cart";
		// }
		showPage(response, request, message);

	}

	// public double totalprice(ArrayList<HashMap<String, String>> listofcart) {
	// double TotalPrice = 0;
	// for (HashMap<String, String> item : listofcart) {
	// TotalPrice += Double.parseDouble(item.get("price").substring(1));
	// System.out.println(TotalPrice);
	// }
	//
	// return TotalPrice;
	// }

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

		out.println("<h2> Amount to pay$ " + carthashStore.totalprice(listofcart) + "</h2>");

		out.println("<h2> Amount to pay$ " + carthashStore.totalprice(listofcart) + "</h2>");
		out.println("<h2> You have " + listofcart.size() + " items in your cart </h2>");
		out.println("<a href=/Best-Deal/home> Home </a>");

		for (HashMap<String, String> item : listofcart) {
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>  </h1>\n\n" + "<h5> Item " + (i++) + "</h5>" + "<h4> Item Name :" + item.get("name")
					+ "</h4>" + "<h4> Item Price :" + item.get("price") + "</h4>" + "<h4> Item Condition :"
					+ item.get("condition") + "</h4>" + "<h4> Item Accessory 1 :" + item.get("accessory1") + "</h4>"
					+ "<form action='/Best-Deal/cart' method='get'>" + "<input type='hidden' name='itemname' value='"
					+ item.get("name") + "' />" + "<input  name=\"action\" type=\"submit\" value='Remove'></form>");
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
