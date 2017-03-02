import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MySQLDataStoreUtilities;

public class DeleteAdminServlet<E> extends HttpServlet {

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

		Enumeration<E> obj = (Enumeration<E>) request.getParameterNames();
		while (obj.hasMoreElements()) {

			String type = (String) obj.nextElement();

			if (type.equals("customerId")) {
				MySQLDataStoreUtilities.deleteCustomer(Integer.parseInt(request.getParameter("customerId")));
			}
			if (type.equals("insuranceId")) {
				MySQLDataStoreUtilities.deleteInsurance(Integer.parseInt(request.getParameter("insuranceId")));
			}

			if (type.equals("locationId")) {
				MySQLDataStoreUtilities.deleteLocation(Integer.parseInt(request.getParameter("locationId")));
			}
			if (type.equals("vehicleVin")) {
				MySQLDataStoreUtilities.deleteVehicle(request.getParameter("vehicleVin"));
			}

			if (type.equals("vehicleId")) {
				MySQLDataStoreUtilities.deleteVehicleInfo(request.getParameter("vehicleId"));
			}
			if (type.equals("accId")) {
				MySQLDataStoreUtilities.deleteAccessory(Integer.parseInt(request.getParameter("accId")));
			}
		}

		//
		// Vehicle addVehicleAdminObject = new Vehicle(vehicleId, vehicleVin,
		// vehicleModel, vehicleMake, locationId,
		// vehicleType, vehicleImage);
		//
		// MySQLDataStoreUtilities.enterVehicle(addVehicleAdminObject);

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
