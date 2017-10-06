
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserDetails;

public class createAccount extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String occupation = request.getParameter("occupation");
		String name = request.getParameter("Name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("Age");
		String salesmanId = request.getParameter("salesmanId");
		// String type = request.getParameter("type");

		if (username == null && address == null && gender == null && name == null) {
			if (username.trim() == null && address.trim() == null && gender.trim() == null && name.trim() == null) {
				showPage(response, "All fields are mandatory please sign up again.");
			}

		} else {
			UserDetails userdata = new UserDetails(username, password, name, address, occupation, gender, age,
					salesmanId);
			bean.MySqlDataStoreUtilities.getInstance().insertUser(userdata);

			response.sendRedirect("/Best-Deal/SignSuccess");

		}

	}

	private void showPage(HttpServletResponse response, String string) throws IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sign uP</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>" + "All fields are mandatory please sign up again." + "</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}
}
