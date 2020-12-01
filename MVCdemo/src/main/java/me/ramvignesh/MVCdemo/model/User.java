package me.ramvignesh.MVCdemo.model;

public class User {
	String username;
	String password;
	String name;
	String email;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	
	@Override
	public String toString() {
		return " "+username+" "+name+" "+email+" "+password+" ";
	}
}
