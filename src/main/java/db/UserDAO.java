package db;

public class UserDAO {
	private static final String SQL__FIND_USER_BY_LOGIN =
			"SELECT * FROM users WHERE login=?";

	private static final String SQL__FIND_USER_BY_ID =
			"SELECT * FROM users WHERE user_id=?";

	private static final String SQL_UPDATE_USER =
			"UPDATE users SET password=?, name=?, last_name=?, local=?" +
					" WHERE user_id=?";
	
	
	
}
