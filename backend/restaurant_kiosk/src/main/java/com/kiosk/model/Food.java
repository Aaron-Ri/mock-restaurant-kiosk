package com.kiosk.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	
	
	//=================================Fields=============================================
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="food_id", unique=true, nullable=false)
	private long foodId;
	
	@Column(name="food_name")
	private String foodName;
	
	@Column(name="food_price")
	private double foodPrice;
	
	@Column(name="food_catagory")
	private String foodCatagory;
	
	@Column(name="food_description")
	private String foodDescription;
	
	@Column(name="food_nutrition_info")
	private String foodNutritionInfo;
	
	@ManyToMany(mappedBy = "orderItems")
	private List<Order> orderList;
	
	
	//=============================Constructor(s)=========================================

	
	public Food() {
		
	}
	
	public Food(String foodName, double foodPrice, String foodCatagory, String foodDescription,
			String foodNutritionInfo) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodCatagory = foodCatagory;
		this.foodDescription = foodDescription;
		this.foodNutritionInfo = foodNutritionInfo;
	}
	

	//=============================Getters/setters========================================
	
	public long getFoodId() {
		return foodId;
	}


	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodCatagory() {
		return foodCatagory;
	}

	public void setFoodCatagory(String foodCatagory) {
		this.foodCatagory = foodCatagory;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public String getFoodNutritionInfo() {
		return foodNutritionInfo;
	}

	public void setFoodNutritionInfo(String foodNutritionInfo) {
		this.foodNutritionInfo = foodNutritionInfo;
	}

	
	
	//==============================toString override===============================
	
	
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodCatagory="
				+ foodCatagory + ", foodDescription=" + foodDescription + ", foodNutritionInfo=" + foodNutritionInfo
				+ "]";
	}
	
	
}
