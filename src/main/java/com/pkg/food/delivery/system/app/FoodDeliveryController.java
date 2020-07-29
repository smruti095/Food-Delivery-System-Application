package com.pkg.food.delivery.system.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodDeliveryController {
 
	@Autowired
	private FoodDeliveryService foodDeliveryService;
	
	@RequestMapping("/foods")
	public List<FoodEntity> getAllFoodItems(){
		return foodDeliveryService.getAllFoodItems();
	}
	
	
	//if variable name is same no need specify as @PathVariable("id")
		@RequestMapping("/foods/{id}")
		public FoodEntity getFoodItemsById(@PathVariable String id) {
			return foodDeliveryService.getFoodItemsById(id);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/foods")
		public void addFoodItem(@RequestBody FoodEntity food) {
			System.out.println("ADD");
			foodDeliveryService.addFoodItem(food);
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/foods/{id}")
		public void updateFoodItem(@RequestBody FoodEntity food,@PathVariable String id) {
			foodDeliveryService.updateFoodItem(food,id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/foods/{id}")
		public void removeFoodItem(@PathVariable String id)throws Exception {
			List<FoodEntity> foodList = foodDeliveryService.getAllFoodItems();
			for(FoodEntity foodDetails : foodList) {
				System.out.println("Hello" + foodDetails.getFoodId());
			}
			for(FoodEntity foodDetails : foodList) {
				if(id.equals(foodDetails.getFoodId()))
				   foodDeliveryService.removeFoodItem(id);
				else
					throw new Exception("Food Item No Found with this foodId" + id);
			}
			
		}

}
