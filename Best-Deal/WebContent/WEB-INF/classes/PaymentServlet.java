import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentServlet extends HttpServlet {

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
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			Utilities utility = new Utilities(pw);
			String basePath = context.getRealPath("") + "/";
			utility.printHeader(basePath + "Header.html", request.getSession());

			//utility.printHtml(basePath + "LeftNavigationBar.html");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(" <form action='/Best-Deal/paymentsuccess' method='get'>"+"<h1> Payment by Credit Card  </h1>\n\n" + "<h5> Enter your card details</h5>"
					+ "<h4>  Name :</h4>" +"<input type=\"text\">"+ "<h4>Card number :</h4>"+"<input type=\"text\">"
					+ "<h4>  Expiry date :</h4>" +"<input type=\"text\">"+ "<h4>Cvv :</h4>"+"<h4>Shipping Adress :</h4>"+"<input type=\"text\">"+"<input type=\"text\">"
					+  "<input  name=\"action\" type=\"submit\" value='Pay now'></form>");
			

					
			out.append(sb.toString());
			utility.printHtml(basePath + "Footer.html");
		}
	

	

			
		

		protected void showPage(HttpServletResponse response, String message) throws ServletException, java.io.IOException {
			response.setContentType("text/html");
			java.io.PrintWriter out = response.getWriter();
		

			
			  
	

		}

}
