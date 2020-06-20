package com.carsome.portal.model;



import java.io.Serializable;

public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8330557027642483424L;

	private String email;
	private String password;

	private Long phone;
	
	private boolean userFound;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public boolean isUserFound() {
		return userFound;
	}

	public void setUserFound(boolean userFound) {
		this.userFound = userFound;
	}
	

}

