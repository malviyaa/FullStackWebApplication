
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class Utilities extends HttpServlet {

	PrintWriter pw = null;
	String newUser = "New User";
	String signIn = "Hello, Sign In";
	static String type;
	static String create = "";

	public Utilities(PrintWriter pw) {
		this.pw = pw;
	}

	public void printHtml(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) {
			pw.append(line);
		}
	}

	public void printHeader(String fileName, HttpSession session) throws IOException {
		printHtml(fileName);

		// java.io.PrintWriter out = response.getWriter();

		if (session.getAttribute("username") == null) {
			System.out.println("username == null");
			pw.append("<head>\n"
					+ "<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
					+ "</head>\n" + "<body>\n" + "<nav class=\"navbar navbar-inverse navbar-right\">\n"
					+ "<div class=\"container-fluid\">\n" + "<div class=\"navbar-header\">\n" +

					"<ul class=\"nav navbar-nav\">\n" +

					"<li><a href=\"/Best-Deal/signup\">" + newUser + "</a></li>\n" + "<li><a href=\"/Best-Deal/Login\">"
					+ signIn + "</a></li>\n" + "<li><select name=\"forma\" onchange=\"location = this.value;\">\n"
					+ "<option value=\"/Best-Deal/Login\" type='hidden' name=\"Customer\">Customer</option>\n"
					+ "<option value=\"/Best-Deal/Login\" type='hidden' name=\"Admin\">Admin</option>\n"
					+ " <option value=\"/Best-Deal/Login\" type='hidden' name=\"Salesman\">Salesman</option>\n"
					+ "</select></li>\n" + "</ul>\n" + "</div>\n" + "</div>\n" + "</nav>\n");

		} else {

			System.out.println("Logged in == Yes");
			session.setAttribute("logged", "Yes");

			pw.append("<head>\n"
					+ "<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
					+ "</head>\n" + "<body>\n" + "<nav class=\"navbar navbar-inverse navbar-right\">\n"
					+ "<div class=\"container-fluid\">\n" + "<div class=\"navbar-header\">\n"
					+ "<ul class=\"nav navbar-nav\">\n" +

					"<li><a>Hello, " + session.getAttribute("username") + "</a></li>\n" +

					"<li><a href=\"/Best-Deal/Logout\">" + "Logout" + "</a></li>\n"
					+ "<li href=\"/Best-Deal/accountinfo\"><a>AccountInfo</a></li>\n"
					+ "<li><a href=\"/Best-Deal/orderlist\">" + "Orders" + "</a></li>\n"
					+ "<li><a href=\"/Best-Deal/usercart\">" + "MyCart" + "</a></li>\n"

			);

			if (session.getAttribute("type").equals("salesman")) {
				String create = "Create Customer";
				System.out.println(create);
				pw.append("<li><a href=\"/Best-Deal/signup\">" + "Create Customer" + "</a></li>\n"
						+ "<li><a href=\"/Best-Deal/customerlist\">" + "Customer details" + "</a></li>\n" + "</ul>\n"
						+ "</div>\n" + "</div>\n" + "</nav>\n");

			} else if (session.getAttribute("type").equals("admin")) {
				String create = "Create Customer";
				System.out.println(create);
				pw.append("<li><a href=\"/Best-Deal/analytics\">" + "Data Analytics" + "</a></li>\n" +

						"</ul>\n" + "</div>\n" + "</div>\n" + "</nav>\n");

			}

			else {
				pw.append("</ul>\n" + "</div>\n" + "</div>\n" + "</nav>\n");
			}

		}
	}
}