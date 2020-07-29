package com.pkg.food.delivery.system.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodDeliveryService {

	@Autowired
	private FoodDeliveryRepository foodDeliveryRepository;
	
	private List<FoodEntity> foodList = new ArrayList<>(Arrays.asList(
            new FoodEntity("Spring","Spring Framework",190),
            new FoodEntity("Java","Core Java",100),
            new FoodEntity("Javascript","Javascript",90)));
	
	public List<FoodEntity> getAllFoodItems(){
		List<FoodEntity> foodList = new ArrayList<>();
		foodDeliveryRepository.findAll()
		               .forEach(foodList::add);
		return foodList;
	}
	
	public FoodEntity getFoodItemsById(String id) {
	    FoodEntity food = foodDeliveryRepository.findOne(id);
	    return food;
	}
	
	public void addFoodItem(FoodEntity food) {
		System.out.println("Orginal Add");
		foodDeliveryRepository.save(food);
	}

	//If id exists it return that topic otherwise create new one
	//Thats why save method used for both add and save
	public void updateFoodItem(FoodEntity food, String id) {
		foodDeliveryRepository.save(food);
		
	}

	public void removeFoodItem(String id) {
		foodDeliveryRepository.delete(id);
		
	}
}
