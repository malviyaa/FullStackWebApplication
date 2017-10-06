import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MySqlDataStoreUtilities;

public class ReviewPage extends HttpServlet {
	ServletContext context = null;
	String message;
	String name, age, gender, occupation, price, retailer, condition, username, category, type, accessory1, accessory2,
			id, discount, rebate, ProductOnSale, RetailerState, RetailerZip, RetailerCity, ManufacturerName,
			ManufacturerRebate;

	static ArrayList<HashMap<String, String>> listoforder = new ArrayList<>();

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

		HashMap<String, HashMap<String, String>> userdetailHashmap = new HashMap<String, HashMap<String, String>>();
		username = (String) request.getSession().getAttribute("username");
		userdetailHashmap = MySqlDataStoreUtilities.getInstance().selectUser(username);

		name = request.getParameter("id");
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
		accessory1 = request.getParameter("accessory1");
		accessory2 = request.getParameter("accessory2");
		age = userdetailHashmap.get(username).get("age");
		gender = userdetailHashmap.get(username).get("gender");
		occupation = userdetailHashmap.get(username).get("occupation");
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

		out.println("<a href=/Best-Deal/home> Home </a>");

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>  </h1>\n\n" + "<h4> ProductModelName     :" + name + "</h4>" +  "</h4>" + "<h6> ProductPrice   		 :" + price + "</h6>"
				+ "<h6> RetailerName   		 :" + retailer + "</h6>" + "<h6> RetailerZip  	     :" + RetailerZip
				+ "</h6>" + "<h6> RetailerCity    	 :" + RetailerCity + "</h6>" + "<h6> RetailerState        :"
				+ RetailerState + "</h6>" + "<h6> ProductOnSale  		 :" + ProductOnSale + "</h6>"
				+ "<h6> ManufacturerName	 :" + ManufacturerName + "</h6>" + "<h6> ManufacturerRebate   :"
				+ ManufacturerRebate + "</h6>" + "<h6> UserID 				 :" + username + "</h6>"
				+ "<h6> UserAge 			 :" + age + "</h6>" + "<h6> UserGender  		 :" + gender + "</h6>"
				+ "<h6> UserOccupation       :" + occupation + "</h6>");

		out.append(sb.toString());
		out.println("<form action='/Best-Deal/reviewsuccess' method='get'>");
		out.println("<input type='hidden' name='price' value='" + price + "' />");
		out.println("<input type='hidden' name='name' value='" + name + "' />");
		//out.println("<input type='hidden' name='Category' value='" + category + "' />");
		out.println("<input type='hidden' name='retailer' value='" + retailer + "' />");
		out.println("<input type='hidden' name='RetailerCity' value='" + RetailerCity + "' />");
		out.println("<input type='hidden' name='RetailerZip' value='" + RetailerZip + "' />");
		out.println("<input type='hidden' name='RetailerState' value='" + RetailerState + "' />");
		out.println("<input type='hidden' name='ProductOnSale' value='" + ProductOnSale + "' />");
		out.println("<input type='hidden' name='ManufacturerName' value='" + ManufacturerName + "' />");
		out.println("<input type='hidden' name='ManufacturerRebate' value='" + ManufacturerRebate + "' />");
		out.println("<input type='hidden' name='age' value='" + age + "' />");
		out.println("<input type='hidden' name='gender' value='" + gender + "' />");
		out.println("<input type='hidden' name='occupation' value='" + occupation + "' />");
		out.println("<input type='hidden' name='username' value='" + username + "' />");

		out.println("<h4><br>Ratings:<br><h4>");
		out.println("<tr><select name='rating'>");
		out.println("<option value='1'>1</option>");
		out.println("<option value='2'>2</option>");
		out.println("<option value='3'>3</option>");
		out.println("<option value='4'>4</option>");
		out.println("<option value='5'>5</option>");
		out.println("</select></tr>");

		out.println("<h4><br>ReviewDate:<br><h4>");
		out.println("<tr><input type='text' name='date'></tr>");

		out.println("<h4><br>ReviewText:<br><h4>");
		out.println("<textarea rows='4' cols='50' name='textreview'>");
		out.println("</textarea>");
		out.println("<input type='submit' value='Submit Review' />");
		out.println("</form>");

		out.println("</div>");
		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		context = config.getServletContext();
	}

}
