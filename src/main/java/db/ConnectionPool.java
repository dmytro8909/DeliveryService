package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

	private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	private static ConnectionPool instance = null;

	private ConnectionPool() {}
	
	public static synchronized ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Context initContext;
		Context envContext;
		Connection connection = null;
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:comp/env");
			
			DataSource ds = 
					(DataSource)envContext.lookup("jdbc/delivery_service");
			connection = ds.getConnection();
		} catch (NamingException e) {
			LOGGER.error("Naming exception");
		} catch (SQLException e) {
			LOGGER.error("SQLException");
		}
		return connection;
	}
	
}
