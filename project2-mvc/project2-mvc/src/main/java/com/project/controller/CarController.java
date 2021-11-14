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

import com.project.entity.BuyerNameAndPrice;
import com.project.entity.Car;
import com.project.entity.Transaction;
import com.project.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService c1;
	

	
	
	
	
	@GetMapping("/")
	public String welcome(Model model) {
		
		// test stuff
		
		LocalDate date = LocalDate.of(2021, 1, 1);
		Car carOne = new Car("infiniti", date, "80999", 10111.00, "g35", "stick and quick", "images/g35.jpeg", "2004");
		c1.addCarToInventory(carOne);
		Car carTwo = new Car("honda", date, "89888", 20111.00, "pilot", "no tints", "images/pilot.jpeg", "2007");
		c1.addCarToInventory(carTwo);
		Car carThree = new Car("volkswagen", date, "80979", 10161.00, "cabrio", "convertible", "images/cabrio.jpeg", "2002");
		c1.addCarToInventory(carThree);
		Car carFour = new Car("nissan", date, "86699", 10181.00, "cube", "right side drive", "images/cube.jpeg", "2002");
		c1.addCarToInventory(carFour);
		Car carFive = new Car("volkswagen", date, "96699", 13181.00, "golf", "european", "images/golf.jpeg", "2004");
		c1.addCarToInventory(carFive);
		Car carSix = new Car("toyota", date, "95699", 13381.00, "corolla", "automatic", "images/corolla.jpeg", "2008");
		c1.addCarToInventory(carSix);
		Car carSeven = new Car("toyota", date, "55699", 16381.00, "rav4", "automatic 4wd", "images/rav4.jpeg", "2009");
		c1.addCarToInventory(carSeven);
		Car carEight = new Car("toyota", date, "75699", 16381.00, "4runner", "automatic but big 4wd", "images/4runner.jpeg", "2019");
		c1.addCarToInventory(carEight);
		Car carNine = new Car("nissan", date, "115699", 16381.00, "juke", "sweet", "images/juke.jpeg", "2015");
		c1.addCarToInventory(carNine);
		Car carTen = new Car("nissan", date, "5699", 116381.00, "gt4", "car okay", "images/gtr.jpeg", "2018");
		c1.addCarToInventory(carTen);
//		Car carOne = new Car("infiniti", "Januray 1, 2019", "80999", 10111.00, "g35", "stick and quick", "images/g35.jpeg", "2004");
//		c1.addCarToInventory(carOne);
//		Car carTwo = new Car("honda", "February 1, 2019", "89888", 20111.00, "pilot", "no tints", "images/pilot.jpeg", "2007");
//		c1.addCarToInventory(carTwo);
//		Car carThree = new Car("volkswagen", "March 1, 2019", "80979", 10161.00, "cabrio", "convertible", "images/cabrio.jpeg", "2002");
//		c1.addCarToInventory(carThree);
//		Car carFour = new Car("nissan", "April 1, 2019", "86699", 10181.00, "cube", "right side drive", "images/cube.jpeg", "2002");
//		c1.addCarToInventory(carFour);
//		Car carFive = new Car("volkswagen", "May 1, 2019", "96699", 13181.00, "golf", "european", "images/golf.jpeg", "2004");
//		c1.addCarToInventory(carFive);
//		Car carSix = new Car("toyota", "June 1, 2019", "95699", 13381.00, "corolla", "automatic", "images/corolla.jpeg", "2008");
//		c1.addCarToInventory(carSix);
//		Car carSeven = new Car("toyota", "July 1, 2019", "55699", 16381.00, "rav4", "automatic 4wd", "images/rav4.jpeg", "2009");
//		c1.addCarToInventory(carSeven);
//		Car carEight = new Car("toyota", "August 1, 2019", "75699", 16381.00, "4runner", "automatic but big 4wd", "images/4runner.jpeg", "2019");
//		c1.addCarToInventory(carEight);
//		Car carNine = new Car("nissan", "September 1, 2019", "115699", 16381.00, "juke", "sweet", "images/juke.jpeg", "2015");
//		c1.addCarToInventory(carNine);
//		Car carTen = new Car("nissan", "October 1, 2019", "5699", 116381.00, "gt4", "car okay", "images/gtr.jpeg", "2018");
//		c1.addCarToInventory(carTen);
		return "index";
		
	}
	
	@GetMapping("/transactions")
	public String seeTransactions(Model model) {
		model.addAttribute("transactionsList", c1.getTransactions());	
		return "transactions";
	}
	
	@GetMapping("/add-car")
	public ModelAndView addCar(Model model) {
		return new ModelAndView("add-car", "car", new Car());
	}
	
	@PostMapping("/add-car")
	public String handleAddCar(Model model, @ModelAttribute("car") Car car, HttpSession session) {
		System.out.println(car.toString());
		c1.addCarToInventory(car);
		model.addAttribute("list", c1.getInventory());
		return "inventory";
		
	}
	
	// change
	// inventory page from "home/index"
	// need to add 10 car check and 3 over 120 day check
	@GetMapping("/inventory")
	public String showInventory(Model model) {
		model.addAttribute("list", c1.getInventory());	
		return "inventory";
	}
	
	// post method for inventory that shows car-purchase page
	@PostMapping("/inventory")
	public String seeCarDetails(Model model, @ModelAttribute("car") Car car, HttpSession session) {
		model.addAttribute("car", car);
		return "car-purchase";
		}
	
	// add single car object to be viewed
	// need post mapping?
	// try
	// comment out whole thing then later add post mapping for selling car
//	@GetMapping("/car-purchase")
//	public String showCarForPurchase(Model model) {
//		LocalDate date = LocalDate.of(2021, 1, 1);
//		Car carTen = new Car("nissan", date, "5699", 116381.00, "gt4", "car okay", "images/gtr.jpeg", "2018");
//		model.addAttribute("car", carTen);
//		
//		
//		return "car-purchase";
//	}
	
	
	@GetMapping("/car-purchase")
	public String showCarForPurchase(@RequestParam String carDescription, Model model, HttpSession session) {
		System.out.println("in cp");
		for (Car temp : c1.getInventory()) {
			if(temp.getCarDescription().equals(carDescription)) {
				model.addAttribute("car", temp);
				c1.setCarForPurchase(temp);
				System.out.println(temp);
				c1.setDaysBetween(ChronoUnit.DAYS.between(temp.getDateAddedToInventory(),LocalDate.now()));
				System.out.println(c1.getDaysBetween());
				
				// add message if over 120days
				if(c1.getDaysBetween() > 120) {
					model.addAttribute("over120message", "option to place a bid on the car, up to 10% off");
				}
				// then add form to car-purchase
				// form ruined this on car-purchase
				// fixing with new class BuyerNameAndPrice
				// may need to add attribute above
				// may need to delete silly BuyerNameAndPrice
				
			}
			
		}
		
		// add transaction object to model
		model.addAttribute("transaction", new Transaction());
		
				
		return "car-purchase";
	}
	
	@PostMapping("/car-purchase")
	public String purchase(Model model, @ModelAttribute("transaction") Transaction transaction, HttpSession session) {
		if(c1.getDaysBetween() > 120) {
			if(transaction.getPrice() > (c1.getCarForPurchase().getPrice() - (c1.getCarForPurchase().getPrice() * .10))) {
				
				transaction.setDate(LocalDate.now());
				transaction.setCar(c1.getCarForPurchase());
				// should delete print statements at some point
				System.out.println(transaction);
				c1.addTransaction(transaction);
				// fix transactions page
				// add outputs for inventory if not enough
			}else {
				return "index";
			}
			
		}else {
			if(transaction.getPrice() >= c1.getCarForPurchase().getPrice()) {
				transaction.setDate(LocalDate.now());
				transaction.setCar(c1.getCarForPurchase());
				// should delete print statements at some point
				System.out.println(transaction);
				// also need to delete from inventor
				c1.addTransaction(transaction);
				
			} else {
				return "index";
			}
		}
		
		// need to add deletion of car from inventory list once sold
		// clean jsp's clear out extra code
		// have proper links in nav
		model.addAttribute("transactionsList", c1.getTransactions());	
		
		
		return "transactions";
	}
	
//	@PostMapping("/car-purchase")
//	public String checkPurchase(Model model, @ModelAttribute("transaction") Transaction transaction, HttpSession session) {
//		if(c1.getDaysBetween() > 120) {
//			if(transaction.getPrice() >= (c1.getCarForPurchase().getPrice() - (c1.getCarForPurchase().getPrice()* .10))) {
//				// add date add car add to transaction sheet
//				transaction.setDate(LocalDate.now());
//				transaction.setCar(c1.getCarForPurchase());
//				c1.addTransaction(transaction);
//				return "transactions";
//			}
//			model.addAttribute("message", "no deal");
//			return"/car-purchase";
//		}else {
//			if(transaction.getPrice() >= c1.getCarForPurchase().getPrice()) {
//				transaction.setDate(LocalDate.now());
//				transaction.setCar(c1.getCarForPurchase());
//				c1.addTransaction(transaction);
//				return "transactions";
//			}
//			model.addAttribute("message", "no deal");
//			return"/car-purchase";
//			
//		}
//		
//		
//	}
	
	// issue seems to be arguments for ModelAndView()
	@GetMapping("/search-by-model")
	public ModelAndView searchByModel(Model model) {
		// using car even though proly only looking at model
		return new ModelAndView("search-by-model", "car", new Car());
	}
	
	// post
	@PostMapping("/search-by-model")
	public String handleSearch(Model model, @ModelAttribute("car") Car car, HttpSession session) {
		List<Car> searchResultArrayList = new ArrayList<Car>();
		for (Car temp : c1.getInventory()) {
			if(car.getModel().toLowerCase().equals(temp.getModel().toLowerCase())){
				searchResultArrayList.add(temp);
			}
		}
		model.addAttribute("list", searchResultArrayList);
		// search results page may need button or not
		return "search-results";
	}
	
	//need to add page for individual car display where car object will be passed and display

}
