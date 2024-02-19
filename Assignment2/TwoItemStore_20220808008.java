package Assignment2;
//@Mehtap Süeda Türkoğlu
//@since 1.0.0 
import java.util.Scanner;

public class TwoItemStore_20220808008 {
	public static void main (String[] args) {
	Scanner inp = new Scanner(System.in);
	
	int sum1 = 0;
	int sum2 = 0;
	int orderedAmount1 = 0;
	int orderedAmount2 = 0;
	float prize1;
	float prize2;
	
	System.out.print("Enter the name of first product: ");
	String product10 = inp.next();
		product10 = product10.toLowerCase();
		String product1 = product10.toUpperCase().charAt(0) + product10.substring(1 , product10.length());
	
	System.out.print("Enter number of " + product1 + " we have: ");
	int quantity1 = inp.nextInt();
		if(quantity1<0)
			System.out.println("Value cannot be negative. Exiting.");
		else {
			System.out.print("Enter the cost of " + product1 + " :");
			prize1 = inp.nextFloat();
			if(prize1<0)
				System.out.println("Value cannot be negative. Exiting.");
			else {
				System.out.print("Enter the name of second product: ");
				String product20 = inp.next();
					product20 = product20.toLowerCase();
					String product2 = product20.toUpperCase().charAt(0) + product20.substring(1 , product20.length());
				System.out.print("Enter number of " + product2 + " we have: ");
				int quantity2 = inp.nextInt();
				if(quantity2<0)
					System.out.println("Value cannot be negative. Exiting.");
				else {
					System.out.print("Enter the cost of " + product2 + " :");
					prize2 = inp.nextFloat();
					if(prize2<0)
						System.out.println("Value cannot be negative. Exiting.");
					else {
						
						do {
							System.out.println("Products we have are the followings. Enter your order: ");
							System.out.println("1) " + product1);
							System.out.println("2) " + product2);
							System.out.println("0) Chechout ");
						
							
							int order = inp.nextInt();
								if(order != 0 && order != 1 && order != 2) {
									System.out.println("Invalid menu option.");
									continue;
								}
								if(order == 1) {
									System.out.println("How many " + product1 + " would you like?" );
									orderedAmount1 = inp.nextInt();
										if(orderedAmount1 <= 0 || orderedAmount1 > quantity1) {
											System.out.println("Value is invalid.");
											continue;
										}
										else {
											sum1 += orderedAmount1;
											quantity1 -= orderedAmount1;
										}
								}
								else if(order == 2) {
									System.out.println("How many " + product2 + " would you like?" );
									orderedAmount2 = inp.nextInt();
										if(orderedAmount2 <= 0 || orderedAmount2 > quantity2) {
											System.out.println("Value is invalid.");
											continue;
										}
										else {
											sum2 += orderedAmount2;
											quantity2 -= orderedAmount2;
										}
								}
								else if(order == 0)
									break;
							}while(true);
						
						System.out.println("Your total:");
						System.out.println(product1 + ": " + sum1 + " * " + prize1 + " = " + sum1*prize1);
						System.out.println(product2 + ": " + sum2 + " * " + prize2 + " = " + sum2*prize2);
						System.out.println("Total due: " + (sum1*prize1 + sum2*prize2));
						System.out.println("We now have the remaining amount of products:" );
						System.out.println(product1 + ": " + quantity1);
						System.out.println(product2 + ": " + quantity2);
						
						
						}
					}
				}	
			}
	inp.close();
	}	
}
