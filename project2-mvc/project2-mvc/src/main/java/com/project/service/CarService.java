package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Car;
import com.project.entity.Transaction;

@Service
public class CarService {
	
	private List<Car> carInventory = new ArrayList<Car>();
	
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	private Car carForPurchase;
	
	private long daysBetween;
	
	


	public Car getCarForPurchase() {
		return carForPurchase;
	}

	public void setCarForPurchase(Car carForPurchase) {
		this.carForPurchase = carForPurchase;
	}

	public long getDaysBetween() {
		return daysBetween;
	}

	public void setDaysBetween(long daysBetween) {
		this.daysBetween = daysBetween;
	}

	// called from CarController after jsp with form:form takes stuff in
	public void addCarToInventory(Car car) {
		carInventory.add(car);
	}
	
	// called when car is sold
	public void removeCarFromInventory(Car car) {
		carInventory.remove(car);
		// maybe eventually check to makes sure at least 3 cars in inventory
	}
	
	// get inventory for inventory jsp
	public List<Car> getInventory(){
		return carInventory;
	}
	
	// add transaction
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	// get transactions
	public List<Transaction> getTransactions(){
		return transactions;
	}


	
	

}
