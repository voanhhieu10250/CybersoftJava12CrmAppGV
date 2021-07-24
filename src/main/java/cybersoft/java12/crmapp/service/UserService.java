package cybersoft.java12.crmapp.service;

import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

import cybersoft.java12.crmapp.dao.UserDao;
import cybersoft.java12.crmapp.dto.UserCreateDto;
import cybersoft.java12.crmapp.modal.User;
import cybersoft.java12.crmapp.util.PwdUtils;

public class UserService {
	private UserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}
	
	public List<User> findAll() {
		List<User> users = null;
		try {
			users = dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	public void deleteById(int id) {
		try {
			dao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(UserCreateDto dto) {
		String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		dto.setPassword(hashedPassword);
		try {
			dao.add(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
