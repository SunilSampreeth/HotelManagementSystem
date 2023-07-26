package com.bitlabs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelManagementSystemImpl implements HotelManagementSystem {
	
	Scanner sc = new Scanner(System.in);
	Map<Integer, Food> db = new LinkedHashMap<Integer,Food>();
	int totalCost=0;


	@Override
	public void addFood() {
		db.put(1, new Food(1,"Doosa ", 50, 6));
		db.put(2, new Food(2,"Palav ", 60, 9));
		db.put(3, new Food(3,"Poori ", 50, 5));
		db.put(4, new Food(4,"Chicken biriyani ", 170, 6));
		db.put(5, new Food(5,"Mutton biriyani  ", 150, 3));
		db.put(6, new Food(6,"Fish biriyani    ", 150, 6));
		
		System.out.println("Food added successfully!");
		
	}

	@Override
	public void displayFood() {

		Set<Integer> keys = db.keySet();
		for(int key: keys) {
			System.out.println("Enter "+key+" ----> "+db.get(key));
		}
		
	}

	@Override
	public void orderFood() {
		System.out.println("Select Food");
		int id=sc.nextInt();
		Food food = db.get(id);
		System.out.println("Ordering food is "+food.getName());
		System.out.println("-------------------------------------");
		System.out.println("Select Quantity ");
		int qut=sc.nextInt();
		if(qut<=food.getQuantity()) {
			food.setQuantity(food.getQuantity()-qut);
			double currentCost=food.getCost()*qut;
			totalCost+=currentCost;
			System.out.println("Ordered " + qut +" "+ food.getName()+ "at the cost of Rs." + currentCost);
		}
		else {
				try {
					throw new InvalidQuantityException("Invalid Quantity Entered!!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}
		
		
	}

	@Override
	public void checkOut() {
		if(totalCost!=0) {
			System.out.println("Total Bill: Rs. "+ totalCost);
	
		}
		else {
			System.out.println("No food items added");
		}
	}

}
