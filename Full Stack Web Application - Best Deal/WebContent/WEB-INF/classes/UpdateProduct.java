
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateProduct extends HttpServlet {

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

		String name, price, image, retailer, condition, category, ProductOnSale, RetailerState, RetailerZip,
				RetailerCity, ManufacturerName, ManufacturerRebate;

		name = request.getParameter("name");
		image = request.getParameter("image");
		category = request.getParameter("Category");

		price = request.getParameter("price");
		retailer = request.getParameter("retailer");
		RetailerCity = request.getParameter("RetailerCity");
		RetailerZip = request.getParameter("RetailerZip");
		RetailerState = request.getParameter("RetailerState");
		ProductOnSale = request.getParameter("ProductOnSale");
		ManufacturerName = request.getParameter("ManufacturerName");
		ManufacturerRebate = request.getParameter("ManufacturerRebate");
		condition = request.getParameter("condition");

		pw.println(" <form action='Best-Deal/Message' method='get'>");

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>  </h1>\n\n" + "<img src=" + image + "alt=\"Mountain View\" style=\"width:204px;height:228px;\">"
				+ "<h4> ProductModelName     :" + name + "</h4>" + "<h4> ProductCategory      :" + category + "</h4>"
				+ "<h6> ProductPrice   		 :" + price + "</h6>" + "<h6> RetailerName   		 :" + retailer + "</h6>"
				+ "<h6> RetailerZip  	     :" + RetailerZip + "</h6>" + "<h6> RetailerCity    	 :" + RetailerCity
				+ "</h6>" + "<h6> RetailerState        :" + RetailerState + "</h6>" + "<h6> ProductOnSale  		 :"
				+ ProductOnSale + "</h6>" + "<h6> ManufacturerName	 :" + ManufacturerName + "</h6>"
				+ "<h6> ManufacturerRebate   :" + ManufacturerRebate + "</h6>");

		pw.println("  <input type='hidden' name='name' value=" + name + " />");
		pw.println("  <input type='hidden' name='Category' value=" + category + "/>");
		pw.println("  <input type='hidden' name='retailer' value=" + retailer + " />");
		pw.append(sb.toString());

		pw.println("  <h4><br>Update Price:<br><h4>");
		pw.println("  <tr><input type='text' name='price'></tr>");
		pw.println("  <input type='submit' value='Update' />");
		pw.println("  </form>");

		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		System.out.println("Printing context");
		context = config.getServletContext();
	}

}