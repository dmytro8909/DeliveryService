package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import db.DBManager;
import entities.User;
import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

public class LoginCommand implements ActionCommand {
	
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private UserDAO userDAO = new UserDAO();
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
	
		User user = userDAO.findUserByLogin(login);
		String userRole = user.getRole();
		
		if (user == null || !pass.equals(user.getPassword())) {
			throw new Exception("Cannot find user with such login/password");
		}
		
		if (LoginLogic.checkLogin(login, pass) && "manager".equals(user.getRole())) {
			session.setAttribute("user", user);
			session.setAttribute("userRole", userRole);
			page = ConfigurationManager.getProperty("path.page.manager");
		} else if (LoginLogic.checkLogin(login, pass) && "user".equals(user.getRole())) { 
			session.setAttribute("user", user);
			session.setAttribute("userRole", userRole);
			page = ConfigurationManager.getProperty("path.page.client");
		} else {
			session.setAttribute("errorLoginPassMessage",
			MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}
