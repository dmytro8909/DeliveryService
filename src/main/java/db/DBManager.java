package db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBManager {
	
	private static final Logger LOGGER = LogManager.getLogger(DBManager.class);

	public String getUserLogin() {
		String login = null;
		
		return login;
	}
	
	public String getUserPassword() {
		String password = null;
		
		return password;
	}
	
	// //////////////////////////////////////////////////////////
	// DB util methods
	// //////////////////////////////////////////////////////////

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
	
}
