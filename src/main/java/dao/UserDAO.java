package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import db.ConnectionPool;
import db.SQLConstants;
import entities.User;

public class UserDAO implements AbstractDAO<User> {
	
	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		ResultSet rs = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
			 Statement stmt = connection.createStatement()) {
			
			rs = stmt.executeQuery(SQLConstants.GET_ALL_USERS);
			
			
		} catch (SQLException ex) {
			LOGGER.error("SQLException");
		}
		return users;
	}

	@Override
	public User get(Long id) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public User delete(User user) {
		return null;
	}
	
}
