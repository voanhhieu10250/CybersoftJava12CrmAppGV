package cybersoft.java12.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cybersoft.java12.crmapp.dbconnection.MySQLConnection;

public class AuthDao {

	public int login(String email, String password) throws SQLException {
		Connection connection = MySQLConnection.getConnection();
		String query = "SELECT count(id) AS result FROM user WHERE email = ? AND password = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(!resultSet.next())
				return 0;
			
			return resultSet.getInt(1);
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return 0;
	}

}
