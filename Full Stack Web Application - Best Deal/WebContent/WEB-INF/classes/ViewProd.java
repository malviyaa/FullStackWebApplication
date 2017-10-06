import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MySqlDataStoreUtilities;

public class ViewProd extends HttpServlet {

	ServletContext context = null;
	HashMap<String, bean.Console> carthashmap = new HashMap<String, bean.Console>();

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
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String type = (String) session.getAttribute("type");
		String url;
		if (username != null) {
			url = "/Best-Deal/usercart";

		} else {
			url = "/Best-Deal/cart";
		}
		java.io.PrintWriter out = response.getWriter();
		HttpSession admin = request.getSession();
		String id = request.getParameter("searchId");
		String name = request.getParameter("id");

		carthashmap = MySqlDataStoreUtilities.getInstance().getSearchProducts(id, name);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());

		utility.printHtml(basePath + "LeftNavigationBar.html");

		out.println("<body>");
		out.println("<form action=" + url + " method='get'>");
		out.println("<h3>Name: " + name + "</h3>");
		if (username != null) {
			out.println("<input type='hidden' name='username' value='" + username + "'/>");
		}
		out.println("<input type='hidden' name='id' value='" + carthashmap.get(id).getName() + "' />");
		out.println("<input type='hidden' name='price' value='" + carthashmap.get(id).getPrice() + "' />");
		// out.println("<input type='hidden' name='Category' value='"
		// +carthashmap.get(id). + "' />");
		// out.println("<input type='hidden' name='name' value='" + name + "'
		// />");
		out.println("<input type='hidden' name='retailer' value='" + carthashmap.get(id).getRetailer() + "' />");
		out.println(
				"<input type='hidden' name='RetailerCity' value='" + carthashmap.get(id).getRetailerCity() + "' />");
		out.println("<input type='hidden' name='RetailerZip' value='" + carthashmap.get(id).getRetailerZip() + "' />");
		out.println(
				"<input type='hidden' name='RetailerState' value='" + carthashmap.get(id).getRetailerState() + "' />");
		out.println(
				"<input type='hidden' name='ProductOnSale' value='" + carthashmap.get(id).getProductOnSale() + "' />");
		out.println("<input type='hidden' name='ManufacturerName' value='" + carthashmap.get(id).getName() + "' />");
		out.println("<input type='hidden' name='ManufacturerRebate' value='"
				+ carthashmap.get(id).getManufacturerRebate() + "' />");
		out.println("<input type='hidden' name='condition' value='" + carthashmap.get(id).getCondition() + "' />");
		// out.println("<input type='hidden' name='accessory1' value='" +
		// Accessory.get(0) + "' />");
		// out.println("<input type='hidden' name='accessory2' value='" +
		// Accessory.get(1) + "' />");

		out.println("<img src=" + carthashmap.get(id).getImage()
				+ "alt=\"Mountain View\" style=\"width:204px;height:228px;\">");
		out.println("<input type='submit' value='Add to Cart' />");

		out.println("<h5> Price:" + carthashmap.get(id).getPrice() + "<h5>");
		out.println("<h6>Retailer: " + carthashmap.get(id).getRetailer() + "<h6>");
		out.println("<h6>Condition: " + carthashmap.get(id).getCondition() + "<h6>");
		// out.println("<h6> Accessory1:" + Accessory.get(0) + "<h6>");
		// out.println("<h6> Accessory2:" + Accessory.get(1) + "<h6>");
		out.println("</form>");

		if (username != null && type.equals("customer")) {
			System.out.println("You are in customer product");
			out.println("<form action='/Best-Deal/review' method='get'>");
			out.println("<input type='hidden' name='id' value='" + carthashmap.get(id).getName() + "' />");
			out.println("<input type='hidden' name='price' value='" + carthashmap.get(id).getPrice() + "' />");
			// out.println("<input type='hidden' name='Category' value='"
			// +carthashmap.get(id). + "' />");
			// out.println("<input type='hidden' name='name' value='" + name +
			// "' />");
			out.println("<input type='hidden' name='retailer' value='" + carthashmap.get(id).getRetailer() + "' />");
			out.println("<input type='hidden' name='RetailerCity' value='" + carthashmap.get(id).getRetailerCity()
					+ "' />");
			out.println(
					"<input type='hidden' name='RetailerZip' value='" + carthashmap.get(id).getRetailerZip() + "' />");
			out.println("<input type='hidden' name='RetailerState' value='" + carthashmap.get(id).getRetailerState()
					+ "' />");
			out.println("<input type='hidden' name='ProductOnSale' value='" + carthashmap.get(id).getProductOnSale()
					+ "' />");
			out.println(
					"<input type='hidden' name='ManufacturerName' value='" + carthashmap.get(id).getName() + "' />");
			out.println("<input type='hidden' name='ManufacturerRebate' value='"
					+ carthashmap.get(id).getManufacturerRebate() + "' />");
			out.println("<input type='hidden' name='condition' value='" + carthashmap.get(id).getCondition() + "' />");
			// out.println("<input type='hidden' name='accessory1' value='"
			// + Accessory.get(0) + "' />");
			// out.println("<input type='hidden' name='accessory2' value='"
			// + Accessory.get(1) + "' />");
			out.println("<input type='submit' value='Review' />");
			out.println("</form>");

		}

		if (username != null && type.equals("admin")) {
			out.println("<input type='hidden' name='id' value='" + carthashmap.get(id).getName() + "' />");
			out.println("<input type='hidden' name='price' value='" + carthashmap.get(id).getPrice() + "' />");
			// out.println("<input type='hidden' name='Category' value='"
			// +carthashmap.get(id). + "' />");
			// out.println("<input type='hidden' name='name' value='" + name +
			// "' />");
			out.println("<input type='hidden' name='retailer' value='" + carthashmap.get(id).getRetailer() + "' />");
			out.println("<input type='hidden' name='RetailerCity' value='" + carthashmap.get(id).getRetailerCity()
					+ "' />");
			out.println(
					"<input type='hidden' name='RetailerZip' value='" + carthashmap.get(id).getRetailerZip() + "' />");
			out.println("<input type='hidden' name='RetailerState' value='" + carthashmap.get(id).getRetailerState()
					+ "' />");
			out.println("<input type='hidden' name='ProductOnSale' value='" + carthashmap.get(id).getProductOnSale()
					+ "' />");
			out.println(
					"<input type='hidden' name='ManufacturerName' value='" + carthashmap.get(id).getName() + "' />");
			out.println("<input type='hidden' name='ManufacturerRebate' value='"
					+ carthashmap.get(id).getManufacturerRebate() + "' />");
			out.println("<input type='hidden' name='condition' value='" + carthashmap.get(id).getCondition() + "' />");
			// out.println("<input type='hidden' name='accessory1' value='"
			// + Accessory.get(0) + "' />");
			// out.println("<input type='hidden' name='accessory2' value='"
			// + Accessory.get(1) + "' />");
			out.println("<input type='submit' value='Update Cart' />");
			out.println("</form>");

			out.println("<form action='/Best-Deal/adminchange' method='post'>");
			out.println("<input type='hidden' name='id' value='" + carthashmap.get(id).getName() + "' />");
			out.println("<input type='hidden' name='price' value='" + carthashmap.get(id).getPrice() + "' />");
			// out.println("<input type='hidden' name='Category' value='"
			// +carthashmap.get(id). + "' />");
			// out.println("<input type='hidden' name='name' value='" + name +
			// "' />");
			out.println("<input type='hidden' name='retailer' value='" + carthashmap.get(id).getRetailer() + "' />");
			out.println("<input type='hidden' name='RetailerCity' value='" + carthashmap.get(id).getRetailerCity()
					+ "' />");
			out.println(
					"<input type='hidden' name='RetailerZip' value='" + carthashmap.get(id).getRetailerZip() + "' />");
			out.println("<input type='hidden' name='RetailerState' value='" + carthashmap.get(id).getRetailerState()
					+ "' />");
			out.println("<input type='hidden' name='ProductOnSale' value='" + carthashmap.get(id).getProductOnSale()
					+ "' />");
			out.println(
					"<input type='hidden' name='ManufacturerName' value='" + carthashmap.get(id).getName() + "' />");
			out.println("<input type='hidden' name='ManufacturerRebate' value='"
					+ carthashmap.get(id).getManufacturerRebate() + "' />");
			out.println("<input type='hidden' name='condition' value='" + carthashmap.get(id).getCondition() + "' />");
			// out.println("<input type='hidden' name='accessory1' value='"
			// + Accessory.get(0) + "' />");
			// out.println("<input type='hidden' name='accessory2' value='"
			// + Accessory.get(1) + "' />");
			out.println("<input type='submit' value='Delete Product' />");
			out.println("</form>");

			out.println("<form action='/Best-Deal/AddProduct' method='post'>");

			out.println("<input type='submit' value='Add Product' />");
			out.println("</form>");
		}
		out.println("<h3> </h3>");
		out.println("</body>");
		out.println("</html>");
		utility.printHtml(basePath + "Footer.html");
	}

}
