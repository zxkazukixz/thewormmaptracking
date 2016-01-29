package com.theworm.mymap.model;

public class Item {
	private Map map;
	private int quantity;
	public Item() {
		super();
	}
	public Item(Map map, int quantity) {
		super();
		this.map = map;
		this.quantity = quantity;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [map=" + map + ", quantity=" + quantity + "]";
	}
	
	
}
