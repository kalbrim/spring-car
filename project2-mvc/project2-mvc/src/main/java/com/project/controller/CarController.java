package com.project.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.project.entity.Car;
import com.project.entity.Transaction;
import com.project.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService c1;
	

	
	
	
	
	@GetMapping("/")
	public String welcome(Model model) {
		
		return "index";
		
	}
	
	// required: application should have a reporting section which displays information about all transactions, (the person who purchased the car)
	@GetMapping("/transactions")
	public String seeTransactions(Model model) {
		model.addAttribute("transactionsList", c1.getTransactions());	
		return "transactions";
	}
	
	// required: inventory should have an option to replenish the inventory by adding pictures and details of a car
	@GetMapping("/add-car")
	public ModelAndView addCar(Model model) {
		return new ModelAndView("add-car", "car", new Car());
	}
	
	// required: inventory should have an option to replenish the inventory by adding pictures and details of a car
	@PostMapping("/add-car")
	public String handleAddCar(Model model, @ModelAttribute("car") Car car, HttpSession session) {
		System.out.println(car.toString());
		c1.addCarToInventory(car);
		model.addAttribute("list", c1.getInventory());
		return "inventory";
		
	}
	

	// requirement: inventory with minimum 10 cars
	// required: minimum 3 cars with idle days of 120+
	@GetMapping("/inventory")
	public String showInventory(Model model, @ModelAttribute("minTenCars") String minTenCars,  @ModelAttribute("min120") String min120) {
		model.addAttribute("list", c1.getInventory());
		
		// requirement: inventory with minimum 10 cars
		String minTen = minTenCars;
		minTen = "";
		if(c1.getInventory().size() < 10) {
			minTen = "inventory needs minimum of 10 cars !!!!";
			
		}
		
		// required: minimum 3 cars with idle days of 120+
		String min120Days = min120;
		min120Days = "";
		int countFor120 = 0;
		for (Car temp : c1.getInventory()) {
			// set thing
			c1.setDaysBetween(ChronoUnit.DAYS.between(temp.getDateAddedToInventory(),LocalDate.now()));
			if(c1.getDaysBetween() > 120) {
				countFor120++;
			}
		}
		if(countFor120 < 3) {
			min120Days = "inventory needs at least 3 car idle for 120days!!!";
		}
		model.addAttribute("min120", min120Days);
		
		model.addAttribute("minTenCars", minTen);
		return "inventory";
	}
	
	// post method for inventory that shows car-purchase page
	@PostMapping("/inventory")
	public String seeCarDetails(Model model, @ModelAttribute("car") Car car, HttpSession session) {
		model.addAttribute("car", car);
		return "car-purchase";
		}
	
	
	
	// required: view details of a car we should display the car details
	@GetMapping("/car-purchase")
	public String showCarForPurchase(@RequestParam String carDescription, Model model, HttpSession session) {

		// pull correct car
		for (Car temp : c1.getInventory()) {
			if(temp.getCarDescription().equals(carDescription)) {
				model.addAttribute("car", temp);
				c1.setCarForPurchase(temp);
				System.out.println(temp);
				c1.setDaysBetween(ChronoUnit.DAYS.between(temp.getDateAddedToInventory(),LocalDate.now()));
				System.out.println(c1.getDaysBetween());
				
				// add message if over 120days
				// required: If a car is sitting in inventory for more than 120 days, there should be an option to place a bid on the car.

				if(c1.getDaysBetween() > 120) {
					model.addAttribute("over120message", "option to place a bid on the car, up to 10% off");
				}
				
			}
			
		}
		
		// add transaction object to model
		model.addAttribute("transaction", new Transaction());
		
				
		return "car-purchase";
	}
	
	// required: view details of a car we should display the car details
	@PostMapping("/car-purchase")
	public String purchase(Model model, @ModelAttribute("transaction") Transaction transaction, HttpSession session) {
		
		// required: If a car is sitting in inventory for more than 120 days, there should be an option to place a bid on the car.
		// required: discounted price up to 10% for 120
		if(c1.getDaysBetween() > 120) {
			if(transaction.getPrice() > (c1.getCarForPurchase().getPrice() - (c1.getCarForPurchase().getPrice() * .10))) {
				
				transaction.setDate(LocalDate.now());
				transaction.setCar(c1.getCarForPurchase());
				
				c1.addTransaction(transaction);
				// delete car from inventory
				// required: inventory should only have cars available to be sold
				c1.removeCarFromInventory(c1.getCarForPurchase());
				// fix transactions page
				// add outputs for inventory if not enough
			}else {
				return "index";
			}
			
		}else {
			if(transaction.getPrice() >= c1.getCarForPurchase().getPrice()) {
				transaction.setDate(LocalDate.now());
				transaction.setCar(c1.getCarForPurchase());
				
				c1.addTransaction(transaction);
				// required: inventory should only have cars available to be sold
				c1.removeCarFromInventory(c1.getCarForPurchase());
				
				
			} else {
				return "index";
			}
		}
		

		model.addAttribute("transactionsList", c1.getTransactions());	
		
		
		return "transactions";
	}
	

	
	
	// required: user should also be able to search for a type (model) 
	@GetMapping("/search-by-model")
	public ModelAndView searchByModel(Model model) {
		return new ModelAndView("search-by-model", "car", new Car());
	}
	
	// required: user should also be able to search for a type (model) 
	@PostMapping("/search-by-model")
	public String handleSearch(Model model, @ModelAttribute("car") Car car, HttpSession session) {
		List<Car> searchResultArrayList = new ArrayList<Car>();
		for (Car temp : c1.getInventory()) {
			if(car.getModel().toLowerCase().equals(temp.getModel().toLowerCase())){
				searchResultArrayList.add(temp);
			}
		}
		model.addAttribute("list", searchResultArrayList);
		// search results page 
		return "search-results";
	}
	


}
