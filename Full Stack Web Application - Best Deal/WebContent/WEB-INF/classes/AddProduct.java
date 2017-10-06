
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProduct extends HttpServlet {

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

		pw.println(" <form action='ProductAddSuccess.jsp' method='get'> ");
		pw.println(" <h4><br>name:<br><h4> ");
		pw.println("	 <tr><input type='text' name='name'></tr> ");
		pw.println(" <h4><br>image:<br><h4> ");
		pw.println("		 <tr><input type='text' name='image'></tr> 		");
		pw.println(" <h4><br>price:<br><h4> ");
		pw.println("		 <tr><input type='text' name='price'></tr> ");
		pw.println(" <h4><br>retailer:<br><h4> ");
		pw.println("			 <tr><input type='text' name='retailer'></tr> ");
		pw.println(" <h4><br>conditions:<br><h4> ");
		pw.println("				 <tr><input type='text' name='conditions'></tr> ");
		pw.println(" <h4><br>RetailerCity:<br><h4> ");
		pw.println("				 <tr><input type='text' name='RetailerCity'></tr> ");
		pw.println("<h4><br>RetailerZip:<br><h4> ");
		pw.println("	 <tr><input type='text' name='RetailerZip'></tr> ");
		pw.println("	 <h4><br>type:<br><h4> ");
		pw.println(" <tr><input type='text' name='type'></tr> ");
		pw.println("	 <h4><br>RetailerState:<br><h4> ");
		pw.println("	 <tr><input type='text' name='RetailerState'></tr>");
		pw.println(" <h4><br>ProductOnSale:<br><h4> ");
		pw.println("			 <tr><input type='text' name='ProductOnSale'></tr> ");
		pw.println(" <h4><br>ManufacturerName:<br><h4> ");
		pw.println("			 <tr><input type='text' name='ManufacturerName'></tr> ");
		pw.println(" <h4><br>ManufacturerRebate:<br><h4> ");
		pw.println("	 <tr><input type='text' name='ManufacturerRebate'></tr> ");
		pw.println(" <h4><br>accessory1:<br><h4> ");
		pw.println("	 <tr><input type='text' name='accessory1'></tr> ");
		pw.println(" <h4><br>accessory2:<br><h4> ");
		pw.println("  <tr><input type='text' name='accessory2'></tr> ");
		pw.println(" <h4><br>ID:<br><h4> ");
		pw.println("	 <tr><input type='text' name='id'></tr> ");
		pw.println(" <h4><br>Catagory:<br><h4> ");
		pw.println("			 <tr><input type='text' name='Catagory'></tr> ");
		pw.println(" <input type='submit' value='Update' /> ");
		pw.println(" 	 </form> ");

		utility.printHtml(basePath + "Footer.html");

	}

	public void init(ServletConfig config) {
		System.out.println("Printing context");
		context = config.getServletContext();
	}

}