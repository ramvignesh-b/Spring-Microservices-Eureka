package me.ramvignesh.MVCdemo.model;

public class Login {
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Username: "+username+" Password: "+password;
	}
}
