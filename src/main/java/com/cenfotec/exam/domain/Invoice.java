package com.cenfotec.exam.domain;

public class Invoice {
	private float amount;
	private String shop;

	// Constructor
	public Invoice() {
	}

	// Getters & Setters
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

}
