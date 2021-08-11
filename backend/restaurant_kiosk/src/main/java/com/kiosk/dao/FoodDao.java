package com.kiosk.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kiosk.model.Food;

@Transactional
@Repository("foodDao")
public interface FoodDao extends CrudRepository<Food,Long>{

	// insert method
	public Food save(Food food);
	
	// find all food
	public List<Food> findAll();
	
	// find by food ID
	public Food findByFoodId(long id);
	
	// update uses same as save
	
	// remove the list
	public void delete(Food food);
	
	
}
