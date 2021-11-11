package com.project.entity;

public class Transaction {
	private double price;
	private Buyer buyer;

	public Transaction() {

	}

	public Transaction(double price, Buyer buyer) {

		this.price = price;
		this.buyer = buyer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}
