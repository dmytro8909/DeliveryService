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

public class UserDAO implements AbstractDAO {
	
	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

	@Override
	public <User> List<User> getAll() {
		List users = new ArrayList();
		ResultSet rs = null;
		try (Connection connection = ConnectionPool.getConnection();
			 Statement stmt = connection.createStatement()) {
			
			rs = stmt.executeQuery(SQLConstants.GET_ALL_USERS);
			
			
		} catch (SQLException ex) {
			LOGGER.error("SQLException");
		}
		return users;
	}

	@Override
	public <User> User get(int id) {
		return null;
	}

	@Override
	public <User> User update(User user) {
		return null;
	}

	@Override
	public <User> User delete(User user) {
		return null;
	}
	
}
