package com.kiosk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiosk.dao.FoodDao;
import com.kiosk.model.Food;

@Service
public class FoodService {

	private FoodDao foodDao;
	
	@Autowired
	public FoodService(FoodDao foodDao) {
		this.foodDao = foodDao;
	}
	
	public Food insertFood(Food food) {
		Food newFood = foodDao.save(food);
		return newFood;
	}
	
	public List<Food> getAllFood(){
//		System.out.println("inside get all food in foodservice");
		List<Food> FoodList = new ArrayList<>();
		FoodList = foodDao.findAll();
//		System.out.println("this ist he full food list: \n    "+FoodList);
		return FoodList;
	}
	
	public Food getFoodById(long id) {
//		System.out.println("foodService, id being searched: "+id);
		Food food;
		food = foodDao.findByFoodId(id);
//		System.out.println("foodService, food item found: "+food);
		return food;
	}
	
	public void removeFood(Food food) {
		foodDao.delete(food);
	}
	
}
