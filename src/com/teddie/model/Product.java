package com.teddie.model;

public class Product {
	private int ID;
	private String name;
	private String description;
	private Double price;
	private String src; //location of the product image
	private String type; //type of product (for future purpose)
	private String brand; //product's category (future purpose)
	private int number;
	
	public Product() {}

	public Product(int ID, String name, String description, Double price, String src, String type, String brand,
			int number) {
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
		this.number = number;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", description=" + description + ", price=" + price + ", src="
				+ src + ", type=" + type + ", brand=" + brand + ", number=" + number + "]";
	}

}
