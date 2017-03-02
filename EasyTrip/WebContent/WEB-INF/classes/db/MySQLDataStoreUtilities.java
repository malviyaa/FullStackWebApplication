package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import com.mysql.jdbc.PreparedStatement;

import admin.Customer;
import vehiclePackage.Accessory;
import vehiclePackage.Insurance;
import vehiclePackage.Location;
import vehiclePackage.Vehicle;
import vehiclePackage.VehicleInfo;

public class MySQLDataStoreUtilities {

	static Connection conn = null;
	static PreparedStatement ps = null;

	static Connection getConnection() {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easytrip", "root", "root");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// *************************************************************************************************************
	public static void enterCustomerInformation(Customer addCustomerAdminBeanObject) {
		try {

			ps = (PreparedStatement) getConnection()
					.prepareStatement("insert into customer(first_name,last_name,password,email_id,phone,license_no)"
							+ "VALUES (?,?,?,?,?,?);");

			ps.setString(1, addCustomerAdminBeanObject.getFirstName());
			ps.setString(2, addCustomerAdminBeanObject.getLastName());
			ps.setString(3, addCustomerAdminBeanObject.getPassword());
			ps.setString(4, addCustomerAdminBeanObject.getEmailId());
			ps.setString(5, addCustomerAdminBeanObject.getPhone());
			ps.setString(6, addCustomerAdminBeanObject.getLicense());

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Customer is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************
	public static void updateCustomerInformation(Customer addCustomerAdminBeanObject) {
		try {

			ps = (PreparedStatement) conn.prepareStatement("UPDATE customer SET first_name='"
					+ addCustomerAdminBeanObject.getFirstName() + "',last_name='"
					+ addCustomerAdminBeanObject.getLastName() + "',password='"
					+ addCustomerAdminBeanObject.getPassword() + "',email_id='"
					+ addCustomerAdminBeanObject.getEmailId() + "',phone='" + addCustomerAdminBeanObject.getPhone()
					+ "',license_no='" + addCustomerAdminBeanObject.getLicense() + "' WHERE id='"
					+ addCustomerAdminBeanObject.getCustomerid() + "'");

			ps.execute();

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Customer is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in customer database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************

	public static HashMap<Integer, Customer> getAllCustomerList() {
		HashMap<Integer, Customer> hashmap = new HashMap<Integer, Customer>();
		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				Customer addCustomerAdminBeanObject = new Customer(rs.getInt("id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email_id"), rs.getString("password"),
						rs.getString("phone"), rs.getString("license_no"));
				hashmap.put(rs.getInt("id"), addCustomerAdminBeanObject);

			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		return hashmap;
	}

	// *********************************************************************************************************************

	public static void deleteCustomer(int customerId) {

		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("Delete FROM customer where id=" + customerId);
			ps.execute();

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	// *********************************************************************************************************************

	public static void enterVehicleInformation(VehicleInfo addVehicleInfoAdminObject) {
		try {

			ps = (PreparedStatement) getConnection().prepareStatement(
					"insert into vehicle_info(vehicle_id,vehicle_price,vehicle_milage,vehicle_passenger,vehicle_sluggage,vehicle_lluggage,vehicle_transmission,vehicle_IMAGE,vehicle_make,vehicle_model)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?);");

			ps.setString(1, addVehicleInfoAdminObject.getVehicleId());
			ps.setDouble(2, addVehicleInfoAdminObject.getVehiclePrice());
			ps.setString(3, addVehicleInfoAdminObject.getVehicleMilage());
			ps.setInt(4, addVehicleInfoAdminObject.getVehiclePassenger());
			ps.setInt(5, addVehicleInfoAdminObject.getVehicleSLuggage());
			ps.setInt(6, addVehicleInfoAdminObject.getVehicleLLuggage());
			ps.setString(7, addVehicleInfoAdminObject.getVehicleTransmission());
			ps.setString(8, addVehicleInfoAdminObject.getVehicleImage());
			ps.setString(9, addVehicleInfoAdminObject.getVehicleMake());
			ps.setString(10, addVehicleInfoAdminObject.getVehicleModel());

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Vehicle is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in database. Problem: " + e2);
		}

	}

	public static void updateVehicleInformation(VehicleInfo updateVehicleAdminBeanObject) {
		try {

			ps = (PreparedStatement) conn.prepareStatement(
					"UPDATE vehicle_info SET vehicle_price='" + updateVehicleAdminBeanObject.getVehiclePrice()
							+ "',vehicle_milage='" + updateVehicleAdminBeanObject.getVehicleMilage()
							+ "',vehicle_passenger='" + updateVehicleAdminBeanObject.getVehiclePassenger()
							+ "',vehicle_sluggage='" + updateVehicleAdminBeanObject.getVehicleSLuggage()
							+ "',vehicle_lluggage='" + updateVehicleAdminBeanObject.getVehicleLLuggage()
							+ "',vehicle_transmission='" + updateVehicleAdminBeanObject.getVehicleTransmission()
							+ "' WHERE vehicle_id='" + updateVehicleAdminBeanObject.getVehicleId() + "'");

			ps.execute();

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : VehicleInfo is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in VehicleInfo database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************

	public static void deleteVehicleInfo(String vehicleId) {

		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("Delete FROM vehicle_info where vehicle_id=" + vehicleId);
			ps.execute();

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	// *********************************************************************************************************************

	public static void enterVehicle(Vehicle addVehicleAdminObject) {
		try {

			ps = (PreparedStatement) getConnection().prepareStatement(
					"insert into vehicles(vehicle_id,vehicle_vin,vehicle_model,vehicle_make,location_id,vehicle_type)"
							+ "VALUES (?,?,?,?,?,?);");

			ps.setString(1, addVehicleAdminObject.getVehicleId());
			ps.setString(2, addVehicleAdminObject.getVehicleVin());
			ps.setString(3, addVehicleAdminObject.getVehicleModel());
			ps.setString(4, addVehicleAdminObject.getVehicleMake());
			ps.setString(5, addVehicleAdminObject.getLocationId());
			ps.setString(6, addVehicleAdminObject.getVehicleType());

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Vehicle is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************

	public static HashMap<String, Vehicle> getAllVehicleList() {
		HashMap<String, Vehicle> hashmap = new HashMap<String, Vehicle>();
		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM vehicles");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				Vehicle addVehicleAdminObject = new Vehicle(rs.getString("vehicle_id"), rs.getString("vehicle_vin"),
						rs.getString("vehicle_model"), rs.getString("vehicle_make"), rs.getString("location_id"),
						rs.getString("vehicle_type"));

				hashmap.put(rs.getString("vehicle_id"), addVehicleAdminObject);

			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		return hashmap;
	}

	// ****************************************************************************************************************
	public static void updateVehicle(Vehicle updateVehicleAdminBeanObject) {
		try {

			ps = (PreparedStatement) conn
					.prepareStatement("UPDATE vehicles SET location_id='" + updateVehicleAdminBeanObject.getLocationId()
							+ "',vehicle_model='" + updateVehicleAdminBeanObject.getVehicleModel() + "',vehicle_make='"
							+ updateVehicleAdminBeanObject.getVehicleMake() + "',vehicle_type='"
							+ updateVehicleAdminBeanObject.getVehicleType() + "' WHERE vehicle_vin='"
							+ updateVehicleAdminBeanObject.getVehicleVin() + "'");

			ps.execute();

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Vehicle is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in Vehicle database. Problem: " + e2);
		}

	}
	// *********************************************************************************************************************

	public static void deleteVehicle(String vehicleVin) {

		try {

			conn = getConnection();

			ps = (PreparedStatement) conn
					.prepareStatement("Delete FROM vehicles where vehicle_vin='" + vehicleVin + "'");
			ps.execute();

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}
	// *********************************************************************************************************************

	public static HashMap<String, VehicleInfo> getAllVehicleTypeList() {
		HashMap<String, VehicleInfo> hashmap = new HashMap<String, VehicleInfo>();
		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM vehicle_info");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				VehicleInfo addVehicleTypeAdminObject = new VehicleInfo(rs.getString("vehicle_id"),
						rs.getDouble("vehicle_price"), rs.getString("vehicle_milage"), rs.getInt("vehicle_passenger"),
						rs.getInt("vehicle_sluggage"), rs.getInt("vehicle_lluggage"),
						rs.getString("vehicle_transmission"), rs.getString("vehicle_IMAGE"),
						rs.getString("vehicle_make"), rs.getString("vehicle_model"));

				hashmap.put(rs.getString("vehicle_id"), addVehicleTypeAdminObject);

			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		return hashmap;
	}

	// *********************************************************************************************************************

	public static void enterInsurance(Insurance addInsuranceAdminObject) {
		try {

			ps = (PreparedStatement) getConnection().prepareStatement(
					"insert into insurance(insurance_name,insurance_type,cost_covered,insurance_company,insurance_price)"
							+ "VALUES (?,?,?,?,?);");

			ps.setString(1, addInsuranceAdminObject.getInsuranceName());
			ps.setString(2, addInsuranceAdminObject.getInsuranceType());
			ps.setDouble(3, addInsuranceAdminObject.getCostCovered());
			ps.setString(4, addInsuranceAdminObject.getInsuranceCompany());
			ps.setDouble(5, addInsuranceAdminObject.getInsurancePrice());

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Insurance is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in database. Problem: " + e2);
		}

	}

	// ****************************************************************************************************************
	public static void updateInsuranceInformation(Insurance updateInsuranceAdminBeanObject) {
		try {

			ps = (PreparedStatement) conn.prepareStatement("UPDATE insurance SET insurance_name='"
					+ updateInsuranceAdminBeanObject.getInsuranceName() + "',insurance_type='"
					+ updateInsuranceAdminBeanObject.getInsuranceType() + "',cost_covered='"
					+ updateInsuranceAdminBeanObject.getCostCovered() + "',insurance_company='"
					+ updateInsuranceAdminBeanObject.getInsuranceCompany() + "',insurance_price='"
					+ updateInsuranceAdminBeanObject.getInsurancePrice() + "' WHERE policy_number='"
					+ updateInsuranceAdminBeanObject.getInsurancePolicyNumber() + "'");

			ps.execute();

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : INsurance is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in INsurance database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************

	public static HashMap<String, Insurance> getAllInsuranceList() {
		HashMap<String, Insurance> hashmap = new HashMap<String, Insurance>();
		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM insurance");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				Insurance addVehicleTypeAdminObject = new Insurance(rs.getInt("policy_number"),
						rs.getString("insurance_name"), rs.getString("insurance_type"), rs.getDouble("cost_covered"),
						rs.getString("insurance_company"), rs.getDouble("insurance_price")

				);

				hashmap.put(rs.getString("policy_number"), addVehicleTypeAdminObject);

			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		return hashmap;
	}

	// *********************************************************************************************************************

	public static void deleteInsurance(int insuranceId) {

		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("Delete FROM insurance where policy_number=" + insuranceId);
			ps.execute();

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	// *********************************************************************************************************************

	public static void enterAccessory(Accessory addAccessoryAdminObject) {
		try {

			ps = (PreparedStatement) getConnection().prepareStatement(
					"insert into accessory(acc_name,total_number,available_number,hour_price)" + "VALUES (?,?,?,?);");

			ps.setString(1, addAccessoryAdminObject.getAccName());
			ps.setInt(2, addAccessoryAdminObject.getTotalNumber());
			ps.setInt(3, addAccessoryAdminObject.getAvailableNumber());
			ps.setDouble(4, addAccessoryAdminObject.getHourPrice());

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Accessory is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in database. Problem: " + e2);
		}

	}

	// ****************************************************************************************************************
	public static void updateAccessory(Accessory updateAccessoryObject) {
		try {

			ps = (PreparedStatement) conn.prepareStatement("UPDATE insurance SET acc_name='"
					+ updateAccessoryObject.getAccName() + "',total_number='" + updateAccessoryObject.getTotalNumber()
					+ "',available_number='" + updateAccessoryObject.getAvailableNumber() + "',hour_price='"
					+ updateAccessoryObject.getHourPrice() + "' WHERE acc_id='" + updateAccessoryObject.getAccId()
					+ "'");

			ps.execute();

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Accessory is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in Accessory database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************

	public static void deleteAccessory(int accessoryId) {

		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("Delete FROM accessory where acc_id=" + accessoryId);
			ps.execute();

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}
	// *********************************************************************************************************************

	public static HashMap<String, Accessory> getAllAccessoryList() {
		HashMap<String, Accessory> hashmap = new HashMap<String, Accessory>();
		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM accessory");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				Accessory addAccessoryAdminObject = new Accessory(rs.getInt("acc_id"), rs.getString("acc_name"),
						rs.getInt("total_number"), rs.getInt("available_number"), rs.getDouble("hour_price")

				);

				hashmap.put(rs.getString("acc_id"), addAccessoryAdminObject);

			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		return hashmap;
	}

	// *********************************************************************************************************************

	public static void enterLocation(Location addLocationAdminObject) {
		try {

			ps = (PreparedStatement) getConnection().prepareStatement(
					"insert into location(location_name,location_pin,location_city,location_country,location_state,location_address,location_hours,location_phone)"
							+ "VALUES (?,?,?,?,?,?,?,?);");

			ps.setString(1, addLocationAdminObject.getLocationName());
			ps.setString(2, addLocationAdminObject.getLocationPin());
			ps.setString(3, addLocationAdminObject.getLocationCity());
			ps.setString(4, addLocationAdminObject.getLocationState());
			ps.setString(5, addLocationAdminObject.getLocationCountry());
			ps.setString(6, addLocationAdminObject.getLocationAddress());
			ps.setString(7, addLocationAdminObject.getLocationHours());
			ps.setInt(8, addLocationAdminObject.getLocationPhone());
			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Location is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in Location  database. Problem: " + e2);
		}

	}

	// *********************************************************************************************************************

	public static HashMap<String, Location> getAllLocationList() {
		HashMap<String, Location> hashmap = new HashMap<String, Location>();
		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM location");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				Location addLocationAdminObject = new Location(rs.getInt("location_id"), rs.getString("location_name"),
						rs.getString("location_pin"), rs.getString("location_city"), rs.getString("location_state"),
						rs.getString("location_country"), rs.getString("location_address"),
						rs.getString("location_hours"), rs.getInt("location_phone")

				);

				hashmap.put(rs.getString("location_id"), addLocationAdminObject);

			}
		} catch (Exception e2) {
			System.out.println(e2);
		}

		return hashmap;
	}

	// ****************************************************************************************************************
	public static void updateLocation(Location updateLocationAdminBeanObject) {
		try {

			ps = (PreparedStatement) conn.prepareStatement(
					"UPDATE location SET location_name='" + updateLocationAdminBeanObject.getLocationName()
							+ "',location_pin='" + updateLocationAdminBeanObject.getLocationPin() + "',location_city='"
							+ updateLocationAdminBeanObject.getLocationCity() + "',location_state='"
							+ updateLocationAdminBeanObject.getLocationState() + "',location_address='"
							+ updateLocationAdminBeanObject.getLocationAddress() + "',location_hours='"
							+ updateLocationAdminBeanObject.getLocationHours() + "',location_phone='"
							+ updateLocationAdminBeanObject.getLocationPhone() + "' WHERE location_id='"
							+ updateLocationAdminBeanObject.getLocationid() + "'");

			ps.execute();

			Boolean i = ps.execute();

			if (i) {
				System.out.println("LOG : Location is successfully registered!");
			}

		} catch (Exception e2)

		{
			System.out.println("LOG: Something is wrong in Location database. Problem: " + e2);
		}

	}
	// *********************************************************************************************************************

	public static void deleteLocation(int locationId) {

		try {

			conn = getConnection();

			ps = (PreparedStatement) conn.prepareStatement("Delete FROM location where location_id=" + locationId);
			ps.execute();

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}