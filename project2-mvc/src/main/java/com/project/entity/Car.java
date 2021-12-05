package com.project.entity;

import java.time.LocalDate;




public class Car {
	
	// requirement: Every detail of a vehicle like manufacturer name
	// test git upload
	private String manufacturer;
	private LocalDate dateAddedToInventory;
	private String kilometers;
	private double price;
	private String model;
	private String carDescription;
	private String pictureUrl;
	private String year;

	public Car() {

	}

	public Car(String manufacturer, LocalDate dateAddedToInventory, String kilometers, double price, String model,
			String carDescription, String pictureUrl, String year) {

		this.manufacturer = manufacturer;
		this.dateAddedToInventory = dateAddedToInventory;
		this.kilometers = kilometers;
		this.price = price;
		this.model = model;
		this.carDescription = carDescription;
		this.pictureUrl = pictureUrl;
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LocalDate getDateAddedToInventory() {
		return dateAddedToInventory;
	}

	public void setDateAddedToInventory(LocalDate dateAddedToInventory) {
		this.dateAddedToInventory = dateAddedToInventory;
	}

	public String getKilometers() {
		return kilometers;
	}

	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", dateAddedToInventory=" + dateAddedToInventory + ", kilometers="
				+ kilometers + ", price=" + price + ", model=" + model + ", carDescription=" + carDescription
				+ ", pictureUrl=" + pictureUrl + ", year=" + year + "]";
	}

}
