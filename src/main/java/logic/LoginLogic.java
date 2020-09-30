package logic;

public class LoginLogic {
	private static final String MANAGER_LOGIN = "admin";
	private static final String MANAGER_PASS = "Qwe123";
	
	public static boolean checkLogin(String enterLogin, String enterPass) {
		return MANAGER_LOGIN.equals(enterLogin) && MANAGER_PASS.equals(enterPass);
	}
}
