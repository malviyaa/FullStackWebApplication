import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MySQLDataStoreUtilities;
import vehiclePackage.Location;

public class UpdateLocationAdminServlet extends HttpServlet {

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
		int locationId = Integer.parseInt(request.getParameter("locationId"));
		String locationName = request.getParameter("locationName");
		String locationPin = request.getParameter("locationPin");
		String locationCity = request.getParameter("locationCity");
		String locationState = request.getParameter("locationState");
		String locationCountry = request.getParameter("locationCountry");
		String locationAddress = request.getParameter("locationAddress");
		String locationHours = request.getParameter("locationHours");
		int locationPhone = Integer.parseInt(request.getParameter("locationPhone"));

		Location addLocationAdminObject = new Location(locationId, locationName, locationPin, locationCity,
				locationState, locationCountry, locationAddress, locationHours, locationPhone);

		MySQLDataStoreUtilities.updateLocation(addLocationAdminObject);
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
