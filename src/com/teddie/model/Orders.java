package com.teddie.model;

import java.util.Date;
import java.util.List;

public class Orders {
	private int ID;
	private String email;
	private float totalPrice;
	private int status;
	private String discount;
	private Date date;
	
	//customer's information
	private String address;
	private String phoneNumber;
	
	
	//customer's list product
	private List<ProductOrders> list;
	
	public Orders() {}
	
	public Orders(int iD, float totalPrice, int status, Date date, String address, String phoneNumber, String email,
			String discount, List<ProductOrders> list) {
		ID = iD;
		this.totalPrice = totalPrice;
		this.status = status;
		this.date = date;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.discount = discount;
		this.list = list;
	}
	
	
	public Orders(String email, int status, String discount, String address, String phoneNumber) {
		this.email = email;
		this.status = status;
		this.discount = discount;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public List<ProductOrders> getList() {
		return list;
	}
	public void setList(List<ProductOrders> list) {
		this.list = list;
	}
	
	

}
