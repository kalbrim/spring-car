package com.project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.entity.Car;
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
	@GetMapping("/inventory")
	public String showInventory(Model model) {
		model.addAttribute("list", c1.getInventory());	
		return "inventory";
	}
	
	// add single car object to be viewed
	// need post mapping?
	// try
	@GetMapping("/car-purchase")
	public String showCarForPurchase(Model model) {
		LocalDate date = LocalDate.of(2021, 1, 1);
		Car carTen = new Car("nissan", date, "5699", 116381.00, "gt4", "car okay", "images/gtr.jpeg", "2018");
		model.addAttribute("car", carTen);
		return "car-purchase";
	}
	
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
		return "search-results";
	}
	
	//need to add page for individual car display where car object will be passed and display

}
