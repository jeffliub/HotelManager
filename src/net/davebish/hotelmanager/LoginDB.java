package net.davebish.hotelmanager;

import java.sql.*;
import java.util.Properties;

public class LoginDB {
	private static final String dbClassName = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://127.0.0.1/HotelManager?user=hmuser&password=hmpwd";
	private Connection c = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public LoginDB() throws ClassNotFoundException, SQLException {
		// Class.forName(xxx) loads the jdbc classes and
		// creates a drivermanager class factory
		Class.forName(dbClassName);
		Properties p = new Properties();
		p.put("user", "hmuser");
		p.put("password", "hmpwd");

		c = DriverManager.getConnection(CONNECTION, p);
	}

	public boolean isValidUser(String UName, String Pwd) throws Exception {
		preparedStatement = c
				.prepareStatement("SELECT * FROM Login WHERE UserName = ? AND Password = ?");
		preparedStatement.setString(1, UName);
		preparedStatement.setString(2, Pwd);
		resultSet = preparedStatement.executeQuery();
		// result.next() = true if data is returned; false otherwise
		return resultSet.next();
	}
}
