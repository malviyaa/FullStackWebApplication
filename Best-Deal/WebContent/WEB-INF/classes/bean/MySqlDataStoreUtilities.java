package bean;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class MySqlDataStoreUtilities {

	static java.sql.Connection conn = null;
	static java.sql.PreparedStatement ps = null;

	private MySqlDataStoreUtilities() {
	}

	private static MySqlDataStoreUtilities instance = new MySqlDataStoreUtilities();

	public void insertXmlProductData(Console console, String category) {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement(
					"insert into XMLProducts(name,image,price,retailer,conditions,RetailerCity,RetailerZip,type,RetailerState,ProductOnSale,ManufacturerName,ManufacturerRebate,accessory1,accessory2,id,Catagory)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			ps.setString(1, console.getName());
			ps.setString(2, console.getImage());
			ps.setString(3, console.getPrice());
			ps.setString(4, console.getRetailer());
			ps.setString(5, console.getCondition());
			ps.setString(6, console.getRetailerCity());
			ps.setString(7, console.getRetailerZip());
			ps.setString(8, "customer");
			ps.setString(9, console.getRetailerState());
			ps.setString(10, console.getProductOnSale());
			ps.setString(11, console.getManufacturerName());
			ps.setString(12, console.getManufacturerRebate());
			ps.setString(13, console.getAccessory1());
			ps.setString(14, console.getAccessory2());
			ps.setString(15, console.getId());
			ps.setString(16, category);
			Boolean i = ps.execute();

			if (i) {
				System.out.println("You are successfully registered...");
			}

		} catch (Exception e2)

		{
			System.out.println(e2);
		}
	}

	public void insertXmlProductuserInputData(String name, String image, String price, String retailer,
			String conditions, String RetailerCity, String RetailerZip, String type, String RetailerState,
			String ProductOnSale, String ManufacturerName, String ManufacturerRebate, String accessory1,
			String accessory2, String id, String Catagory) {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement(
					"insert into XMLProducts(name,image,price,retailer,conditions,RetailerCity,RetailerZip,type,RetailerState,ProductOnSale,ManufacturerName,ManufacturerRebate,accessory1,accessory2,id,Catagory)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, retailer);
			ps.setString(5, conditions);
			ps.setString(6, RetailerCity);
			ps.setString(7, RetailerZip);
			ps.setString(8, "customer");
			ps.setString(9, RetailerState);
			ps.setString(10, ProductOnSale);
			ps.setString(11, ManufacturerName);
			ps.setString(12, ManufacturerRebate);
			ps.setString(13, accessory1);
			ps.setString(14, accessory2);
			ps.setString(15, id);
			ps.setString(16, Catagory);
			Boolean i = ps.execute();

			if (i) {
				System.out.println("You are successfully registered...");
			}

		} catch (Exception e2)

		{
			System.out.println(e2);
		}
	}

	public HashMap<String, Console> getAllProducts() {
		HashMap<String, Console> hashmap = new HashMap<String, Console>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("SELECT * FROM XMLProducts");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{
				Console s = new Console(rs.getString("name"), rs.getString("image"), rs.getString("price"),
						rs.getString("retailer"), rs.getString("conditions"), rs.getString("RetailerCity"),
						rs.getString("RetailerZip"), rs.getString("type"), rs.getString("RetailerState"),
						rs.getString("ProductOnSale"), rs.getString("ManufacturerName"),
						rs.getString("ManufacturerRebate"), rs.getString("accessory1"), rs.getString("accessory2"),
						rs.getString("id"));

				hashmap.put(s.getId(), s);
			}
		} catch (Exception e) {

		}
		return hashmap;
	}

	public HashMap<String, Console> getXmlProducts(String catagory) {
		HashMap<String, Console> hashmap = new HashMap<String, Console>();

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("SELECT * FROM XMLProducts where Catagory= '" + catagory + "'");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{
				Console s = new Console(rs.getString("name"), rs.getString("image"), rs.getString("price"),
						rs.getString("retailer"), rs.getString("conditions"), rs.getString("RetailerCity"),
						rs.getString("RetailerZip"), rs.getString("type"), rs.getString("RetailerState"),
						rs.getString("ProductOnSale"), rs.getString("ManufacturerName"),
						rs.getString("ManufacturerRebate"), rs.getString("accessory1"), rs.getString("accessory2"),
						rs.getString("id"));

				hashmap.put(s.getId(), s);

			}
		} catch (Exception e2)

		{
			System.out.println(e2);
		}

		return hashmap;
	}

	public void getUpdateProducts(String name, String category, String price) {

		try {

			System.out.println(name);
			System.err.println(category);
			System.out.println(price);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("UPDATE XMLProducts SET price='" + price + "' WHERE name='" + name + "'");
			ps.execute();

		} catch (Exception e2)

		{
			System.out.println(e2);
		}

	}

	public void deleteProduct(String name) {

		try {

			System.out.println(name);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("Delete  FROM XMLProducts WHERE name = '" + name + "'");
			ps.execute();

		} catch (Exception e2)

		{
			System.out.println(e2);
		}

	}

	public void insertUser(UserDetails obj) {

		try {
			System.out.println("Hello DB");

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement(
					"insert into Registration(name,gender,age,address,occupation,username,password,type,salesmanId)"
							+ "VALUES (?,?,?,?,?,?,?,?,?);");

			ps.setString(1, obj.getName());
			ps.setString(2, obj.getGender());
			ps.setString(3, obj.getAge());
			ps.setString(4, obj.getAddress());
			ps.setString(5, obj.getOccupation());
			ps.setString(6, obj.getUsername());
			ps.setString(7, obj.getPassword());
			ps.setString(8, "customer");
			ps.setString(9, obj.getSalesmanId());
			Boolean i = ps.execute();

			if (i) {
				System.out.println("You are successfully registered...");
			}

		} catch (Exception e2)

		{
			System.out.println(e2);
		}

	}

	public ArrayList<HashMap<String, String>> getBestnonRatedproduct() {
		ArrayList<HashMap<String, String>> listofbestnonratedproduct = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement(
					"select name, count(*) from OrderDetails group by name order by count(*) desc limit 5");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HashMap<String, String> bestproductsaleMap = new HashMap<String, String>();
				bestproductsaleMap.put("ProductName", rs.getString("name"));
				bestproductsaleMap.put("count", rs.getString("count(*)"));
				listofbestnonratedproduct.add(bestproductsaleMap);

			}
		} catch (Exception e) {

		}
		return listofbestnonratedproduct;
	}

	public ArrayList<HashMap<String, String>> getBestlocation() {
		ArrayList<HashMap<String, String>> listofbestlocation = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement(
					"  select  RetailerZip, count(*) from OrderDetails group by RetailerZip order by count(*) desc limit 5");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HashMap<String, String> bestlocationmap = new HashMap<String, String>();
				bestlocationmap.put("RetailerZip", rs.getString("RetailerZip"));
				bestlocationmap.put("count", rs.getString("count(*)"));
				listofbestlocation.add(bestlocationmap);

			}
		} catch (Exception e) {

		}

		return listofbestlocation;
	}

	public HashMap<String, HashMap<String, String>> selectUser(String username) {
		HashMap<String, HashMap<String, String>> singleusermap = new HashMap<String, HashMap<String, String>>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("SELECT * FROM Registration WHERE username = '" + username + "'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				HashMap<String, String> usernameMapValue = new HashMap<String, String>();

				usernameMapValue.put("address", rs.getString("address"));
				usernameMapValue.put("password", rs.getString("password"));
				usernameMapValue.put("name", rs.getString("name"));
				usernameMapValue.put("occupation", rs.getString("occupation"));
				usernameMapValue.put("gender", rs.getString("gender"));
				usernameMapValue.put("username", rs.getString("username"));
				usernameMapValue.put("age", rs.getString("age"));
				usernameMapValue.put("type", rs.getString("type"));

				singleusermap.put(username, usernameMapValue);

			}

		} catch (Exception e2)

		{
			System.out.println(e2);
		}

		return singleusermap;
	}

	public ArrayList<HashMap<String, String>> getorderdetails(String username) {
		ArrayList<HashMap<String, String>> listoforder = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("SELECT * FROM OrderDetails WHERE username = '" + username + "'");
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				HashMap<String, String> orderMapValue = new HashMap<String, String>();
				orderMapValue.put("name", rs.getString("name"));
				orderMapValue.put("id", rs.getString("id"));
				orderMapValue.put("price", rs.getString("price"));
				orderMapValue.put("retailer", rs.getString("retailer"));
				orderMapValue.put("idOrderdetail", rs.getString("idOrderdetail"));
				orderMapValue.put("username", rs.getString("username"));
				System.out.println("order value hash" + orderMapValue);
				listoforder.add(orderMapValue);

			}
		} catch (Exception e2)

		{
			System.out.println(e2);
		}

		return listoforder;
	}

	public ArrayList<HashMap<String, String>> removeOrder(String orderid) {
		ArrayList<HashMap<String, String>> listoforder = new ArrayList<>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("Delete  FROM OrderDetails WHERE idOrderdetail = '" + orderid + "'");
			ps.execute();

		} catch (Exception e2)

		{
			System.out.println(e2);
		}

		return listoforder;
	}

	public ArrayList<HashMap<String, String>> getsalesmanclients(String username) {
		ArrayList<HashMap<String, String>> listofcustomer = new ArrayList<>();

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("SELECT * FROM Registration WHERE SalesmanId = '" + username + "'");

			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{
				HashMap<String, String> customerMapValue = new HashMap<String, String>();

				customerMapValue.put("address", rs.getString("address"));
				customerMapValue.put("password", rs.getString("password"));
				customerMapValue.put("name", rs.getString("name"));
				customerMapValue.put("occupation", rs.getString("occupation"));
				customerMapValue.put("gender", rs.getString("gender"));
				customerMapValue.put("username", rs.getString("username"));
				customerMapValue.put("age", rs.getString("age"));
				customerMapValue.put("type", rs.getString("type"));
				System.out.println("Customer value hash" + customerMapValue);
				listofcustomer.add(customerMapValue);

			}
			System.out.println("List of customer" + listofcustomer);
		} catch (Exception e2)

		{
			System.out.println(e2);
		}

		return listofcustomer;
	}

	public ArrayList<HashMap<String, String>> removesalesmanclients(String itemName) {
		ArrayList<HashMap<String, String>> listofcustomer = new ArrayList<>();

		try {

			System.out.println("=====3======" + itemName);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("DELETE  FROM Registration WHERE username = '" + itemName + "'");

			ps.execute();

		} catch (Exception e2)

		{
			System.out.println(e2);
		}

		return listofcustomer;
	}

	public void insertItemDetails(ArrayList<HashMap<String, String>> userList, String idOrderdetail,
			String deliverydate) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			for (HashMap<String, String> item : userList) {
				ps = conn.prepareStatement(
						"insert into OrderDetails(idOrderdetail,deliverydate,id,name,price,ManufacturerName,retailer,RetailerCity,ManufacturerRebate,RetailerZip,ProductOnSale,ItemCondition, RetailerState, accessory1,accessory2,username )"
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

				ps.setString(1, idOrderdetail);
				ps.setString(2, deliverydate);

				ps.setString(3, item.get("id"));
				ps.setString(4, item.get("name"));
				ps.setString(5, item.get("price"));
				ps.setString(6, item.get("ManufacturerName"));
				ps.setString(7, item.get("retailer"));
				ps.setString(8, item.get("RetailerCity"));
				ps.setString(9, item.get("ManufacturerRebate"));
				ps.setString(10, item.get("RetailerZip"));
				ps.setString(11, item.get("ProductOnSale"));
				ps.setString(12, item.get("condition"));
				ps.setString(13, item.get("RetailerState"));
				ps.setString(14, item.get("accessory1"));
				ps.setString(15, item.get("accessory2"));
				ps.setString(16, item.get("username"));

				ps.execute();
				System.out.println("Storing values");
			}

		} catch (Exception e2)

		{
			System.out.println(e2);
		}
	}

	public static MySqlDataStoreUtilities getInstance() {
		if (instance == null) {
			instance = new MySqlDataStoreUtilities();
		}
		return instance;
	}

	public HashMap<String, Console> getSearchProducts(String id, String name) {
		HashMap<String, Console> hashmap = new HashMap<String, Console>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BestDeal", "root", "root");

			ps = conn.prepareStatement("SELECT * FROM XMLProducts WHERE id=" + id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{
				Console s = new Console(rs.getString("name"), rs.getString("image"), rs.getString("price"),
						rs.getString("retailer"), rs.getString("conditions"), rs.getString("RetailerCity"),
						rs.getString("RetailerZip"), rs.getString("type"), rs.getString("RetailerState"),
						rs.getString("ProductOnSale"), rs.getString("ManufacturerName"),
						rs.getString("ManufacturerRebate"), rs.getString("accessory1"), rs.getString("accessory2"),
						rs.getString("id"));

				hashmap.put(s.getId(), s);
			}
		} catch (Exception e) {

		}
		return hashmap;
	}

}