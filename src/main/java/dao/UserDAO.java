package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import db.ConnectionPool;
import db.SQLConstants;
import db.DBManager;
import entities.User;

public class UserDAO implements AbstractDAO<User> {
	
	private DBManager dbManager = new DBManager();
	private ConnectionPool pool = ConnectionPool.getInstance();
	private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		ResultSet rs = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
			 Statement stmt = connection.createStatement()) {
			
			rs = stmt.executeQuery(SQLConstants.GET_ALL_USERS);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("user_id"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("last_name"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setLocal(rs.getString("local"));
			}
			
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
	
	public User findUserByLogin(String login) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = pool.getConnection();
			pstmt = con.prepareStatement(SQLConstants.SQL_FIND_USER_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			dbManager.rollback(con);
		} finally {
			dbManager.close(con, pstmt, rs);
		}
		return user;
	}
	
	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("user_id"));
		user.setLogin(rs.getString("login"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setLastName(rs.getString("last_name"));
		user.setRole(rs.getString("role"));
		return user;
	}
	
}
