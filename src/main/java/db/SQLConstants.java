package db;

public class SQLConstants {
	public static final String FIND_MANAGER_LOGIN = 
			"SELECT `login` FROM `users` WHERE `role`='manager'";
	public static final String FIND_MANAGER_PASSWORD = 
			"SELECT `password` FROM `users` WHERE `role`='manager'";
	public static final String SQL_FIND_USER_BY_LOGIN =
			"SELECT * FROM `users` WHERE `login`=?";
}
