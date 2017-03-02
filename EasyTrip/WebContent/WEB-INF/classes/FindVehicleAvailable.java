
/*
 * FindVehicleAvailable.java
 * Author: Bijay Sharma
 */

import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vehiclePackage.Vehicle;

public class FindVehicleAvailable extends HttpServlet {

	/**
	 * Initializes the servlet with some usernames/password
	 */
	public void init() {

	}

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
		String pickupLocation = request.getParameter("pickUpLocation");
		String returnLocation = request.getParameter("returnLocation");
		String pickUpDate = request.getParameter("pickUpDate");
		String returnDate = request.getParameter("returnDate");
		String pickUpTime = request.getParameter("pickupTime");
		String returnTime = request.getParameter("returnTime");
		String ageSelector = request.getParameter("customerAge");
		String carType = request.getParameter("carType");

		// HashMap to store availableVehicle
		HashMap<String, Vehicle> availableVehicle = new HashMap<String, Vehicle>();

		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

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
