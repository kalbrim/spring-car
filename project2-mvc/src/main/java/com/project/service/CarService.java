package com.project.service;

import java.time.LocalDate;
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
	
	// requirement: inventory with minimum 10 cars
	public CarService(){
		LocalDate date = LocalDate.of(2021, 1, 1);
		Car carOne = new Car("infiniti", date, "80999", 10111.00, "g35", "stick and quick", "images/g35.jpeg", "2004");
		carInventory.add(carOne);
		Car carTwo = new Car("honda", date, "89888", 20111.00, "pilot", "no tints", "images/pilot.jpeg", "2007");
		carInventory.add(carTwo);
		Car carThree = new Car("volkswagen", date, "80979", 10161.00, "cabrio", "convertible", "images/cabrio.jpeg", "2002");
		carInventory.add(carThree);
		Car carFour = new Car("nissan", date, "86699", 10181.00, "cube", "right side drive", "images/cube.jpeg", "2002");
		carInventory.add(carFour);
		Car carFive = new Car("volkswagen", date, "96699", 13181.00, "golf", "european", "images/golf.jpeg", "2004");
		carInventory.add(carFive);
		Car carSix = new Car("toyota", date, "95699", 13381.00, "corolla", "automatic", "images/corolla.jpeg", "2008");
		carInventory.add(carSix);
		Car carSeven = new Car("toyota", date, "55699", 16381.00, "rav4", "automatic 4wd", "images/rav4.jpeg", "2009");
		carInventory.add(carSeven);
		Car carEight = new Car("toyota", date, "75699", 16381.00, "4runner", "automatic but big 4wd", "images/4runner.jpeg", "2019");
		carInventory.add(carEight);
		Car carNine = new Car("nissan", date, "115699", 16381.00, "juke", "sweet", "images/juke.jpeg", "2015");
		carInventory.add(carNine);
		Car carTen = new Car("nissan", date, "5699", 116381.00, "gt4", "car okay", "images/gtr.jpeg", "2018");
		carInventory.add(carTen);
		
	}
	
	


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
