package Assignment;

//@Mehtap Süeda Türkoğlu @18.10.2022

import java.util.Scanner;

public class BreadStore_20220808008 {

	public static void main(String[] args) {		

		//question2
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter dozen of donut we have: ");
		int DozenOfDonuts = in.nextInt();
			
		System.out.println("Enter cost of a donut: ");
		double CostOfDonuts = in.nextDouble();
			
		if (DozenOfDonuts < 0 || CostOfDonuts < 0) {
			System.out.println("error: Value can't be negative.");
		}else {
			System.out.println("Welcome to MyDonut store! We have " + DozenOfDonuts + " dozen of donuts. Please enter how many dozen would you like: ");
			int Requested = in.nextInt();
			
			if(Requested < 1) {
					System.out.println("error: Value can't be negative");
					System.out.println("Now we have " + DozenOfDonuts + " dozen of donuts left!");
					System.out.println("Thanks for shopping from us!");
			}else if(Requested > DozenOfDonuts) {
					System.out.println("error: We don't have that much donut!");
					System.out.println("Now we have " + DozenOfDonuts + " dozen of donuts left!");
					System.out.println("Thanks for shopping from us!");	
			}else if(DozenOfDonuts >= 0 && CostOfDonuts >= 0) {
				System.out.println("Total cost is: " + Requested * CostOfDonuts);
				System.out.println("Now we have " + (DozenOfDonuts - Requested) + " dozen of donuts left!");
				System.out.println("Thanks for shopping from us!");
			}
		}
		
		in.close(); 
		
	}
}
