package bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CheckDatabase {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		insert();

	}

	private static void insert() throws ClassNotFoundException, SQLException {
		String user_first_name = "Ankit1";
		String user_last_name = "Ankitjn,2";
		String user_email = "Ankit4kldsdml4";
		String user_password = "Ankit4";
		System.out.println("Program started");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://ankit1.c9vfq8had7xm.us-west-2.rds.amazonaws.com:3306/android", "ankit1", "ankitankit");
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("INSERT INTO register (first_name, last_name,username,password ) VALUES (?,?,?,?);");
		ps.setString(1, user_first_name);
		ps.setString(2, user_last_name);
		ps.setString(3, user_email);
		ps.setString(4, user_password);
		ps.execute();

	}
}
