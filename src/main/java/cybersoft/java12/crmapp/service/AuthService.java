package cybersoft.java12.crmapp.service;

import java.sql.SQLException;

import cybersoft.java12.crmapp.dao.AuthDao;

public class AuthService {
	private AuthDao dao;
	
	public AuthService() {
		dao = new AuthDao();
	}
	
	public boolean login(String email, String password) {
		int result;
		try {
			result = dao.login(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return result > 0;
	}

}
