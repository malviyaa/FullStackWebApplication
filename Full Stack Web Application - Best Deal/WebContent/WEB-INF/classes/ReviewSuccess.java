import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MongoDBDataStoreUtilities;

public class ReviewSuccess extends HttpServlet {

	ServletContext context = null;

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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		ArrayList<HashMap<String, String>> allreviewlist = new ArrayList<>();
		String price = request.getParameter("price").substring(1);
		String name = request.getParameter("name");
		String Category = request.getParameter("Category");
		String retailer = request.getParameter("retailer");
		String RetailerCity = request.getParameter("RetailerCity");
		String RetailerZip = request.getParameter("RetailerZip");
		String RetailerState = request.getParameter("RetailerState");
		String ProductOnSale = request.getParameter("ProductOnSale");
		String ManufacturerName = request.getParameter("ManufacturerName");
		String ManufacturerRebate = request.getParameter("ManufacturerRebate");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String occupation = request.getParameter("occupation");
		String username = request.getParameter("username");
		Double rating = Double.parseDouble(request.getParameter("rating"));
		String date = request.getParameter("date");
		String Productreview = request.getParameter("textreview");

		MongoDBDataStoreUtilities.getInstance().insertReview(price, name, Category, rating, date, Productreview,
				RetailerZip, RetailerState, ProductOnSale, ManufacturerName, ManufacturerRebate, age, gender,
				occupation, username, date, Productreview);
		allreviewlist = MongoDBDataStoreUtilities.getInstance().getallReviews();
		System.out.println(allreviewlist);

		showPage(response, request, allreviewlist);
		// else
		// {
		//
		// MySqlDataStoreUtilities.getInstance().insertUser(username, password,
		// name, address, phone, gender, age,salesmanId);
		//
		// response.sendRedirect("/Best-Deal/SignSuccess");
		//
		//
		// }

	}

	private void showPage(HttpServletResponse response, HttpServletRequest request,
			ArrayList<HashMap<String, String>> allreviewlist) throws IOException {
		response.setContentType("text/html");
		HttpSession admin = ((HttpServletRequest) request).getSession();
		String name = (String) admin.getAttribute("name");
		System.out.println(name);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", ((HttpServletRequest) request).getSession());

		utility.printHtml(basePath + "LeftNavigationBar.html");
		utility.printHtml(basePath + "ReviewSuccess.html");

		utility.printHtml(basePath + "Footer.html");

	}

}
