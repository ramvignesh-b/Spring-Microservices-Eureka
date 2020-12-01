package me.ramvignesh.MVC2demo.model;

public class login {
	private String username, password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Username11: "+username+" 11: "+password;
	}
}
