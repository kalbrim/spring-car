package com.project.entity;

import java.time.LocalDate;

public class Transaction {
	private double price;
	private String buyer;
	private LocalDate date;
	private Car car;

	public Transaction() {

	}

	public Transaction(double price, String buyer, LocalDate date, Car car) {
		this.price = price;
		this.buyer = buyer;
		this.date = date;
		this.car = car;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Transaction [price=" + price + ", buyer=" + buyer + ", date=" + date + ", car=" + car + "]";
	}
	
	

}
