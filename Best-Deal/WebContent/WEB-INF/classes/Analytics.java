import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MongoDBDataStoreUtilities;

public class Analytics extends HttpServlet {

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
		ArrayList<HashMap<String, Double>> ratedReviews = new ArrayList<>();
		ArrayList<HashMap<String, Integer>> nonratedReviews = new ArrayList<>();
		ArrayList<HashMap<String, Integer>> bestlocation = new ArrayList<>();
		ratedReviews = MongoDBDataStoreUtilities.getInstance().getBestratedproduct();
		nonratedReviews = MongoDBDataStoreUtilities.getInstance().getBestnonRatedproduct();
		bestlocation = MongoDBDataStoreUtilities.getInstance().getBestlocation();

		System.out.println(ratedReviews);
		System.out.println(nonratedReviews);
		System.out.println(bestlocation);

		showPage(response, request, bestlocation, nonratedReviews, ratedReviews);

	}

	protected void showPage(HttpServletResponse response, HttpServletRequest request,
			ArrayList<HashMap<String, Integer>> bestlocation, ArrayList<HashMap<String, Integer>> nonratedReviews,
			ArrayList<HashMap<String, Double>> ratedReviews) throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		int i = 1;
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(pw);
		String basePath = context.getRealPath("") + "/";
		utility.printHeader(basePath + "Header.html", request.getSession());
		utility.printHtml(basePath + "LeftNavigationBar.html");
		PrintWriter out = response.getWriter();
		out.println("<h4>Today's Trending </h4>");

		out.println("<table>" + "<tr>" + " <th>Product Name       &nbsp;   &nbsp;  &nbsp; </th>"
				+ "  <th>          Average Rating</th>" + "</tr>");
		for (HashMap<String, Double> item : ratedReviews) {
			StringBuilder sb = new StringBuilder();
			sb.append(" <tr><th>" + item.keySet().toString().substring(1, item.keySet().toString().length() - 1)
					+ "  &nbsp;  &nbsp;  &nbsp;</th>" + "  <th>"
					+ item.values().toString().substring(1, item.values().toString().length() - 1) + "</th></tr>");
			out.append(sb.toString());

		}
		out.println("<h4>Top five most liked products. </h4>");
		out.println("<table>" + "<tr>" + " <th>Product Name       &nbsp;   &nbsp;  &nbsp; </th>"
				+ "  <th>        Number of product sold</th>" + "</tr>");
		for (HashMap<String, Integer> item : nonratedReviews) {
			StringBuilder sb = new StringBuilder();
			sb.append(" <tr><th>" + item.keySet().toString().substring(1, item.keySet().toString().length() - 1)
					+ "  &nbsp;  &nbsp;  &nbsp;</th>" + "  <th>"
					+ item.values().toString().substring(1, item.values().toString().length() - 1) + "</th></tr>");
			out.append(sb.toString());

		}
		out.println("<h4> Top five number of times the product has been reviewed .</h4>");

		out.println("<table>" + "<tr>" + " <th>Zip Codes      &nbsp;   &nbsp;  &nbsp; </th>"
				+ "  <th>          Number of Product sold</th>" + "</tr>");
		for (HashMap<String, Integer> item : bestlocation) {
			StringBuilder sb = new StringBuilder();
			sb.append(" <tr><th>" + item.keySet().toString().substring(1, item.keySet().toString().length() - 1)
					+ "  &nbsp;  &nbsp;  &nbsp;</th>" + "  <th>"
					+ item.values().toString().substring(1, item.values().toString().length() - 1) + "</th></tr>");
			out.append(sb.toString());

		}
		out.println("<h4>Top five zip-codes where maximum number of products reviewed. </h4>");

		out.println("</table>");
		out.println("</div>");
		utility.printHtml(basePath + "Footer.html");

	}

}
