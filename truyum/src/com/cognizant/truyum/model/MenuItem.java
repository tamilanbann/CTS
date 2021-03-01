package com.cognizant.truyum.model;

import java.time.LocalDate;

public class MenuItem {

	private long id;
	private String name;
	private float price;
	private boolean active;
	private LocalDate date;
	private String category;
	private boolean freeDelivery;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public MenuItem(long id, String name, float price, boolean active, LocalDate date, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.date = date;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("%-15s %7.2f %-15s %-15s %-15s %-15s", name, price, active ? "Yes" : "No", date, category,
				freeDelivery ? "Yes" : "No");
	}
}
