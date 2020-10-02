package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.User;
import exception.Messages;

public class DBManager {
	
	private static ConnectionPool pool = ConnectionPool.getInstance();
	private static SQLConstants sqlConstants = new SQLConstants();
	private static final Logger LOGGER = LogManager.getLogger(DBManager.class);

	public String getManagerLogin() {
		String login = null;
		try (Connection con = pool.getConnection();
			 Statement statement = con.createStatement();
			 ResultSet resultSet = 
					 statement.executeQuery(sqlConstants.FIND_MANAGER_LOGIN)) {
				
			if(resultSet.next()) {
    			login = resultSet.getString("login");
    		}	
			
		} catch (SQLException e) {
			LOGGER.error("SQLException");
		}
		return login;
	}
	
	public String getManagerPassword() {
		String password = null;
		try (Statement statement = 
				pool.getConnection().createStatement();
			 ResultSet resultSet = 
				statement.executeQuery(sqlConstants.FIND_MANAGER_PASSWORD)) {
				
			if(resultSet.next()) {
				password = resultSet.getString("password");
    		}	
			
		} catch (SQLException e) {
			LOGGER.error("SQLException");
		}
		return password;
	}
	
	public User findUserByLogin(String login) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = pool.getConnection();
			pstmt = con.prepareStatement(sqlConstants.SQL_FIND_USER_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
		} finally {
			close(con, pstmt, rs);
		}
		return user;
	}
	
//	public String getUserLogin() {
//		
//	}
//	
//	public String getUserPassword() {
//		
//	}
	
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
	
	// //////////////////////////////////////////////////////////
	// DB util methods
	// //////////////////////////////////////////////////////////

	private void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				LOGGER.error("Cannot rollback transaction", ex);
			}
		}
	}
	
	/**
	 * Closes a connection.
	 * 
	 * @param con
	 *            Connection to be closed.
	 */
	private void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
			}
		}
	}

	/**
	 * Closes a statement object.
	 */
	private void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_STATEMENT, ex);
			}
		}
	}
	
	/**
	 * Closes a result set object.
	 */
	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				LOGGER.error(Messages.ERR_CANNOT_CLOSE_RESULTSET, ex);
			}
		}
	}
	
	/**
	 * Closes resources.
	 */
	private void close(Connection con, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(con);
	}
	
	/**
	 * Commits and close the given connection.
	 * 
	 * @param con
	 *            Connection to be committed and closed.
	 */
	public void commitAndClose(Connection con) {
		try {
			con.commit();
			con.close();
		} catch (SQLException ex) {
			LOGGER.error("SQLException");
		}
	}

	/**
	 * Rollbacks and close the given connection.
	 * 
	 * @param con
	 *            Connection to be rollbacked and closed.
	 */
	public void rollbackAndClose(Connection con) {
		try {
			con.rollback();
			con.close();
		} catch (SQLException ex) {
			LOGGER.error("SQLException");
		}
	}
	
	public static void main(String[] args) {
		DBManager dbManager = new DBManager();
		System.out.println(dbManager.getManagerLogin());
		System.out.println(dbManager.getManagerPassword());
	}
	
}
