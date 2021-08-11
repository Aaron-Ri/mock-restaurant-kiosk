package com.kiosk.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.model.Food;
import com.kiosk.service.FoodService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/food")
public class foodController {
	
	private FoodService foodService;
	
	@Autowired
	public foodController(FoodService foodService) {
		this.foodService = foodService;
	}

	
	
	@CrossOrigin("*")
	@GetMapping("/single")
	//@RolesAllowed({"kiosk-terminal","kiosk-admin"})
	@ResponseBody
	public Food get(@RequestParam long id) {
//		System.out.println("requesting single food item by the id of: "+id);
		return foodService.getFoodById(id);
	}
	
	@GetMapping("/all")
	//@RolesAllowed({"kiosk-terminal","kiosk-admin"})
	@ResponseBody
	public List<Food> getAllFood(){
//		System.out.println("inside send all food controller");
		return foodService.getAllFood();
	}
	
	@PostMapping("/new")
	//@RolesAllowed({"kiosk-admin"})
	@ResponseBody
	public Food insertEvent(@RequestBody Food food) {
		Food insertedFood;
		insertedFood = foodService.insertFood(food);
		return insertedFood;
	}
	
	@DeleteMapping("/remove")
	//@RolesAllowed({"kiosk-admin"})
	@ResponseBody
	public void deleteFood(@RequestBody Food food) {
		foodService.removeFood(food);;
	}
	
	

}
