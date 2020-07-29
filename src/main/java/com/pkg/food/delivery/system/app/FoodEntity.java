package com.pkg.food.delivery.system.app;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FoodEntity {
    
	@Id
	private String foodId;
	private String foodName;
	private int foodPrice;
	
	public FoodEntity() {
	}
    
	public FoodEntity(String foodId, String foodName, int foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	
}
