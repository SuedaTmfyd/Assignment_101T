package Assignment3;
import java.util.Scanner;

//@Mehtap Sueda Turkoglu @04.12.2022

public class StoreUsingArrays_20220808008 {
	public static void main(String[] args) {
//		String[] item = {"bread", "COLA", "snickers", "AYRAN"}; 
//		int[] quantity = {10, 15, 12, 30};
//		double[] price = {.75, 2.5, 2.25, 1};
//		storeRun(item, quantity, price);
	}
	
	public static int menu(String[] item, double[] price, Scanner inp){
		capitalizeArrays(item);
		
		System.out.println("WELCOME TO OUR STORE! We have the following. Enter what you would like:");
		for(int i = 0; i < item.length; i++) 
			System.out.println((i + 1) + " - for " + item[i] +" ("+ price[i] + ") ");
		System.out.println("0 - to checkout");
		int choice = inp.nextInt();
				
		return choice;
	}
	
	
	public static void returnedAmounts(double amount){
		double[] bill= {200, 100, 50, 20, 10, 5, 1, 0.5, 0.25, 0.1, 0.05, 0.01};
		for(int i = 0; i < bill.length; i++) {
			int total = 0;
			if(amount / bill[i] > 1) {
				total = (int)(amount / bill[i]);
				System.out.println(total + " - " + bill[i]);
				amount -= total * bill[i];
			}
		}
	}

	
	public static void storeRun(String[] item, int[] quantity, double[] price) {
		Scanner inp = new Scanner(System.in);
		capitalizeArrays(item);
		int order = 0;
		double total = 0;
		int[] totalItem = new int[item.length];
		
		do {
			order = 0;
			int i = menu(item, price, inp);
			
			if(i != 0) {
				System.out.println("How many " + item[i - 1]  + " would you like?");
				order = inp.nextInt();
					if(order <= 0 || order > quantity[i - 1]) {
						System.out.println("Value is invalid.");
						continue;
					}
					else {
//						int[] sum = new int[item.length];
//						sum[i - 1] += price[i - 1] * order;
						total += price[i - 1] * order; 
						quantity[i - 1] -= order;
						totalItem[i - 1] += order;
					}
			}
			else 
				break;	
		}while(true);
		
		System.out.println("*****CUSTOMER TOTAL*****");
		for(int j = 0; j < totalItem.length; j++) {
			if(totalItem[j] !=  0)
				System.out.println(item[j] + " - " + totalItem[j] + " * " + price[j]);
		}
		System.out.println("************************");
		
		do {
			System.out.print("Enter amount given: ");
			double amountGiven = inp.nextDouble();
			
			if(amountGiven < total) {
				System.out.println("Not enough payment given!");
				continue;
			}
			else {
				System.out.println("Thank you! Your change given is:");
				returnedAmounts(amountGiven - total);
				break;
			}
		}while(true);	
		
		inp.close();
	}
	
	
	public static String capitalizeString(String text) {
		text = text.toUpperCase().charAt(0) + text.substring(1 , text.length()).toLowerCase();
		return text;
	}
	
	public static void capitalizeArrays(String[] item) {
		for(int i = 0; i < item.length; i++) {
			item[i] = capitalizeString(item[i]);
		}
	}
	
}