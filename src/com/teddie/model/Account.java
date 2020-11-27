package com.teddie.model;

public class Account {
	private String username;
	private String password;
	private String phoneNumber;
	private String address;
	
	public Account() {}
	
	
	public Account(String username, String password, String phoneNumber, String address) {
		super();
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}


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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isEmpty() {
		return username.isEmpty();
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
	
	
	
	

}
