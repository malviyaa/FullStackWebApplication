import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Console;
import hashStore.ProductStore;

public class MobileProduct extends HttpServlet {

	ServletContext context = null;
	Console console;
	String name;
	List<String> accessories;
	String image;
	String condition;
	String price;
	String retailer;
	String discount;
	String rebate;
	String username;
	String RetailerCity;
	String RetailerZip;
	String RetailerState;
	String ProductOnSale;
	String ManufacturerName;
	String ManufacturerRebate;
	String accessory1, accessory2;
	String url;
	String type;
	String category = "Mobile";

	HashMap<String, Console> mobileidHash;
	Console mobiledetailsHash;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		username = (String) session.getAttribute("username");
		type = (String) session.getAttribute("type");

		if (username != null) {
			url = "/Best-Deal/usercart";

		} else {
			url = "/Best-Deal/cart";
		}
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());

		utility.printHtml(basePath + "LeftNavigationBar.html");
		java.io.PrintWriter out = response.getWriter();

		mobileidHash = ProductStore.getMobileProducts(request.getSession().getServletContext().getRealPath("SmartPhone.xml"), "SmartPhone");
		System.out.println("MobileHash value is not a" + mobileidHash);
		System.out.println("Hello Mobile products");
		for (String key : mobileidHash.keySet()) {
			mobiledetailsHash = mobileidHash.get(key);
			name = mobiledetailsHash.getName();

			image = mobiledetailsHash.getImage();
			// System.out.println(image);
			price = mobiledetailsHash.getPrice();
			retailer = mobiledetailsHash.getRetailer();
			condition = mobiledetailsHash.getCondition();
			RetailerCity = mobiledetailsHash.getRetailerCity();
			RetailerZip = mobiledetailsHash.getRetailerZip();
			RetailerState = mobiledetailsHash.getRetailerState();
			ProductOnSale = mobiledetailsHash.getProductOnSale();
			ManufacturerName = mobiledetailsHash.getManufacturerName();
			ManufacturerRebate = mobiledetailsHash.getManufacturerRebate();
			// List<String> Accessory = mobiledetailsHash.accessories;

			out.println("<body>");
			out.println("<form action=" + url + " method='get'>");
			out.println("<h3>Name: " + name + "</h3>");
			if (username != null) {
				out.println("<input type='hidden' name='username' value='" + username + "'/>");
			}
			out.println("<input type='hidden' name='id' value='" + key + "' />");
			out.println("<input type='hidden' name='price' value='" + price + "' />");
			out.println("<input type='hidden' name='Category' value='" + category + "' />");
			out.println("<input type='hidden' name='name' value='" + name + "' />");
			out.println("<input type='hidden' name='retailer' value='" + retailer + "' />");
			out.println("<input type='hidden' name='RetailerCity' value='" + RetailerCity + "' />");
			out.println("<input type='hidden' name='RetailerZip' value='" + RetailerZip + "' />");
			out.println("<input type='hidden' name='RetailerState' value='" + RetailerState + "' />");
			out.println("<input type='hidden' name='ProductOnSale' value='" + ProductOnSale + "' />");
			out.println("<input type='hidden' name='ManufacturerName' value='" + ManufacturerName + "' />");
			out.println("<input type='hidden' name='ManufacturerRebate' value='" + ManufacturerRebate + "' />");
			out.println("<input type='hidden' name='condition' value='" + condition + "' />");
			// out.println("<input type='hidden' name='accessory1' value='" +
			// Accessory.get(0) + "' />");
			// out.println("<input type='hidden' name='accessory2' value='" +
			// Accessory.get(1) + "' />");

			out.println("<img src='"+image+"' \"alt=\"Mountain View\" style=\"width:204px;height:228px;\">");
			out.println("<input type='submit' value='Add to Cart' />");

			out.println("<h5> Price:" + price + "<h5>");
			out.println("<h6>Retailer: " + retailer + "<h6>");
			out.println("<h6>Condition: " + condition + "<h6>");
			// out.println("<h6> Accessory1:" + Accessory.get(0) + "<h6>");
			// out.println("<h6> Accessory2:" + Accessory.get(1) + "<h6>");
			out.println("</form>");

			if (username != null && type.equals("customer")) {
				System.out.println("You are in customer product");
				out.println("<form action='/Best-Deal/review' method='get'>");
				out.println("<input type='hidden' name='price' value='" + price + "' />");
				out.println("<input type='hidden' name='Category' value='" + category + "' />");
				out.println("<input type='hidden' name='name' value='" + name + "' />");
				out.println("<input type='hidden' name='retailer' value='" + retailer + "' />");
				out.println("<input type='hidden' name='RetailerCity' value='" + RetailerCity + "' />");
				out.println("<input type='hidden' name='RetailerZip' value='" + RetailerZip + "' />");
				out.println("<input type='hidden' name='RetailerState' value='" + RetailerState + "' />");
				out.println("<input type='hidden' name='ProductOnSale' value='" + ProductOnSale + "' />");
				out.println("<input type='hidden' name='ManufacturerName' value='" + ManufacturerName + "' />");
				out.println("<input type='hidden' name='ManufacturerRebate' value='" + ManufacturerRebate + "' />");
				out.println("<input type='hidden' name='condition' value='" + condition + "' />");
				// out.println("<input type='hidden' name='accessory1' value='"
				// + Accessory.get(0) + "' />");
				// out.println("<input type='hidden' name='accessory2' value='"
				// + Accessory.get(1) + "' />");
				out.println("<input type='submit' value='Review' />");
				out.println("</form>");

			}

			if (username != null && type.equals("admin")) {
				out.println("<form action='/Best-Deal/UpdateProduct' method='get'>");
				out.println("<input type='hidden' name='price' value='" + price + "' />");
				out.println("<input type='hidden' name='Category' value='" + category + "' />");
				out.println("<input type='hidden' name='name' value='" + name + "' />");
				out.println("<input type='hidden' name='retailer' value='" + retailer + "' />");
				out.println("<input type='hidden' name='RetailerCity' value='" + RetailerCity + "' />");
				out.println("<input type='hidden' name='RetailerZip' value='" + RetailerZip + "' />");
				out.println("<input type='hidden' name='RetailerState' value='" + RetailerState + "' />");
				out.println("<input type='hidden' name='ProductOnSale' value='" + ProductOnSale + "' />");
				out.println("<input type='hidden' name='ManufacturerName' value='" + ManufacturerName + "' />");
				out.println("<input type='hidden' name='ManufacturerRebate' value='" + ManufacturerRebate + "' />");
				out.println("<input type='hidden' name='condition' value='" + condition + "' />");
				// out.println("<input type='hidden' name='accessory1' value='"
				// + Accessory.get(0) + "' />");
				// out.println("<input type='hidden' name='accessory2' value='"
				// + Accessory.get(1) + "' />");
				out.println("<input type='submit' value='Update Cart' />");
				out.println("</form>");

				out.println("<form action='/Best-Deal/DeleteProduct' method='post'>");
				out.println("<input type='hidden' name='price' value='" + price + "' />");
				out.println("<input type='hidden' name='name' value='" + name + "' />");
				out.println("<input type='hidden' name='retailer' value='" + retailer + "' />");
				out.println("<input type='hidden' name='RetailerCity' value='" + RetailerCity + "' />");
				out.println("<input type='hidden' name='RetailerZip' value='" + RetailerZip + "' />");
				out.println("<input type='hidden' name='RetailerState' value='" + RetailerState + "' />");
				out.println("<input type='hidden' name='ProductOnSale' value='" + ProductOnSale + "' />");
				out.println("<input type='hidden' name='ManufacturerName' value='" + ManufacturerName + "' />");
				out.println("<input type='hidden' name='ManufacturerRebate' value='" + ManufacturerRebate + "' />");
				out.println("<input type='hidden' name='condition' value='" + condition + "' />");
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

		}

		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		context = config.getServletContext();

	}

}
