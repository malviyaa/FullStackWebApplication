import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MySQLDataStoreUtilities;
import vehiclePackage.Insurance;

public class AddInsuranceAdminServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		// Session and request variables
		HttpSession session = request.getSession(true);

		String insuranceName = request.getParameter("insuranceName");
		String insuranceType = request.getParameter("insuranceType");
		Double insuranceCostCovered = Double.parseDouble(request.getParameter("insuranceCostCovered"));
		String insuranceCompany = request.getParameter("insuranceCompany");
		Double insurancePrice = Double.parseDouble(request.getParameter("insurancePrice"));

		Insurance addInsuranceAdminObject = new Insurance(insuranceName, insuranceType, insuranceCostCovered,
				insuranceCompany, insurancePrice);

		MySQLDataStoreUtilities.enterInsurance(addInsuranceAdminObject);

		RequestDispatcher rd;
		ServletContext sc = getServletContext();

		// session.setAttribute("firstName", firstName);
		// session.setAttribute("lastName", lastName);
		// Retrieving vehicles Info from vehiclesInfo table

		rd = sc.getRequestDispatcher("/AddVehicleAdminMessage.jsp");
		rd.forward(request, response);

	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		processRequest(request, response);
	}
}
