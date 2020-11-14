package com.teddie.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;
	
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public void add(Product item) {
		for (Product product: items) {
			if (item.getID() == product.getID()) {
				product.setNumber(product.getNumber()+1);
				return;
			}
		}
		
		items.add(item);
	}
	
	public void remove(int ID) {
		for (Product item: items) {
			if (item.getID() == ID) {
				items.remove(item);
				return;
			}
		}
	}

	public double getAmount() {
		double s = 0;
		
		for (Product product: items) {
			s += product.getPrice() * product.getNumber();
		}
		
		return Math.round(s * 100.0) / 100.0;
	}
	public List<Product> getItems() {
		return items;
	}
	
	public int getTotalItems() {
		int total = 0;
		
		for (Product item: items) {
			total += item.getNumber();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}
	

	
}
