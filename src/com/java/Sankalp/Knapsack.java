package com.java.Sankalp;

import java.util.Scanner;

public class Knapsack {

	public static Scanner sc = new Scanner(System.in);
	public int items, weight[], profit[], knapsackWeight;

	Knapsack() {
		System.out.println("Enter the number of items");
		items = sc.nextInt();
		
		weight = new int[items];
		profit = new int[items];
		
		System.out.println("Enter " + items + " items weights");
		for(int i = 0; i<items; i++) {
			weight[i] = sc.nextInt();
		}
		
		System.out.println("Enter the profit for " + items + " items");
		for(int i = 0; i<items; i++) {
			profit[i] = sc.nextInt();
		}
		
		System.out.println("Enter the Knapsack Capacity");
		knapsackWeight = sc.nextInt();

			
		createTable();
	}
	
	public void createTable() {
		int newItem[][] = new int[items + 1][knapsackWeight + 1];
		
		for(int i = 0; i<(knapsackWeight+1); i++) {
			newItem[0][i] = 0;
		}
		
		for(int i = 0; i<(items+1); i++) {
			newItem[i][0] = 0;
		}

		
		for(int i = 1; i<(items+1); i++) { 
			for(int j = 1; j<(knapsackWeight+1); j++){
				// INDEX for Weight and Profit will be (i-1) since it start from zeroth index
				// But for newItem table will be from one 
				// Since we're filling it from 1st index
				
				if((j - weight[(i-1)]) < 0) {
					newItem[i][j] = newItem[i-1][j];
					
				}
				else if((j - weight[(i-1)]) >= 0) {
					newItem[i][j] = Math.max(newItem[i-1][j], (profit[(i-1)] + newItem[i-1][j-(weight[(i-1)])]));
				}
			}
		
		}
		
		System.out.println("The maximum profit: " + newItem[items][knapsackWeight]);
		System.out.print("Items Selected: " );
		for(int i = (items-1); i>=1; i--, knapsackWeight--) {
			if((newItem[(i+1)][knapsackWeight]) == (newItem[(i)][knapsackWeight])) {				
				continue;
			} 
			else {
				System.out.print((i) + " " );
			}
		}
		
	}
	
	public static void main(String[] args) {
		Knapsack kp = new Knapsack();
	

	}

}
