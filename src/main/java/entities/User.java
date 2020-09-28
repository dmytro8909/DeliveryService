package entities;

public class User extends Entity {

	private static final long serialVersionUID = 6176729694708676630L;

	private String name;
	private String lastName;
	private String login;
	private String password;
	private String role;
	private String local;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}
	
	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", lastName=" + lastName + 
			   ", login=" + login + ", password=" + password +
			   ", role=" + role + ", local=" + local + "]";
	}
	
}
