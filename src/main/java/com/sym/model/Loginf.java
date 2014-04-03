package com.sym.model;

public class Loginf {
	String username;
	String password;
	public Loginf(String usr,String pwd)
	{
		this.username=usr;
		this.password=pwd;
		
	}
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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


}
