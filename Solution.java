package com.bitlabs;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		HotelManagementSystem h = new HotelManagementSystemImpl();
		int input=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to 5 star hotel");
		System.out.println("=============================");
		h.addFood();
		System.out.println("----------------------");
		while(input==1) {

			System.out.println("1.Order Food\n2.Check out\n3.Exit\nEnter the choice");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: h.displayFood();
			h.orderFood();
			break;
			case 2: h.checkOut();
			break;
			case 3: System.out.println("Thank You!!");
			System.exit(0);
			break;
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice ");
				}
				catch(Exception e ) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Enter 1 to continue , Any number to Exit");
			input=sc.nextInt();
			
		}
		h.checkOut();
		System.out.println("Thank You!!");
		
        

	}
		
	}


