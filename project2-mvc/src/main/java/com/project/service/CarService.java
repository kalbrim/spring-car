package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Car;

@Service
public class CarService {
	
	private List<Car> carInventory = new ArrayList<Car>();
	
	


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


	
	

}
