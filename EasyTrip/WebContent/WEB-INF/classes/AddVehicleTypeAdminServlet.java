import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MySQLDataStoreUtilities;
import vehiclePackage.VehicleInfo;

public class AddVehicleTypeAdminServlet extends HttpServlet {

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

		String vehicleMake = request.getParameter("vehicleMake");
		String vehicleModel = request.getParameter("vehicleModel");
		Double vehiclePrice = Double.parseDouble(request.getParameter("vehiclePrice"));
		String vehicleMilage = request.getParameter("vehicleMilage");
		int vehiclePassenger = Integer.parseInt(request.getParameter("vehiclePassenger"));
		int vehicleSLuggage = Integer.parseInt(request.getParameter("vehicleSLuggage"));
		int vehicleLLuggage = Integer.parseInt(request.getParameter("vehicleLLuggage"));
		String vehicleTransmission = request.getParameter("vehicleTransmission");
		String vehicleImage = request.getParameter("vehicleImage");

		VehicleInfo addVehicleInfoAdminObject = new VehicleInfo(vehicleMake + vehicleModel, vehiclePrice, vehicleMilage,
				vehiclePassenger, vehicleSLuggage, vehicleLLuggage, vehicleTransmission, vehicleImage, vehicleMake,
				vehicleModel);

		MySQLDataStoreUtilities.enterVehicleInformation(addVehicleInfoAdminObject);
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
