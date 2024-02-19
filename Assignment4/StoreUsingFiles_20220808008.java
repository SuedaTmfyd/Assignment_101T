package Assignment4;

//@Mehtap Sueda Turkoglu @23.12.2022
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class StoreUsingFiles_20220808008 {
	public static void main(String[] args) {
		
		int count = countProducts(args[0]);
		String[] ItemID =  new String[count];
		String[] ItemName = new String[count];
		int[] Quantity =  new int[count];
		double[] Price =  new double[count];
		getProductInfo(ItemID, ItemName, Quantity, Price, args[0]);
		writeProductInfo(ItemID, ItemName, Quantity, Price, args[1]);
	}
	
	public static int countProducts(String filename) {
		int count = 0;
		 try {
			  File file = new File(filename);
		      Scanner sc = new Scanner(file);

		      while(sc.hasNextLine()) {
		        sc.nextLine();
		        count++;
		      }
		      sc.close();
		    } catch (Exception e) {
		      e.getStackTrace();
		    }
		 return count;
	}
	
	public static void getProductInfo(String[] ItemID, String[] ItemName, int[] Quantity, double[] Price, String filename) {
		int count = countProducts(filename);

		try {
			File file = new File(filename);
		
			Scanner inp = new Scanner(file);
			while(inp.hasNextLine()) {
				for(int i = 0; i < count; i++) {
					ItemID[i] = inp.next();
					ItemName[i] = inp.next();
					Quantity[i] = inp.nextInt();
					Price[i] = inp.nextDouble();
				}
				inp.nextLine();
			}	
			inp.close();
			
		}catch(Exception e){}
		
	}
	
	public static void writeProductInfo(String[] ItemID, String[] ItemName, int[] Quantity, double[] Price, String filename) {
		int count = countProducts(filename);
		String[] orderID =  new String[count];
		int[] orderQuantity =  new int[count];
		int[] totalItem = new int[ItemID.length];
		double total = 0;
		try {
			File file = new File(filename);
			Scanner inp = new Scanner(file);
			
			while(inp.hasNext()) {
				for(int i = 0; i < count; i++) {
					orderID[i] = inp.next();
					orderQuantity[i] = inp.nextInt();
				}
			}
			inp.close();
			
			PrintWriter error = new PrintWriter(new File("Assignment04.log"));
			for(int k = 0; k < orderID.length; k++)
				if(orderQuantity[k]<0)
					error.println("ERROR: Invalid amount request " + orderQuantity[k]);
				
				
			for(int j = 0; j < orderID.length; j++) {
				for(int i = 0; i < ItemID.length; i++) {
					if(orderID[j].equals(ItemID[i])) {
						int quantity = Quantity[i];
						int orderquantity = orderQuantity[j];
							
						if((quantity - orderquantity) >= 0 && orderQuantity[j] > 0) {
							total += Price[i] * orderQuantity[j]; 
							Quantity[i] -= orderQuantity[j];
							totalItem[i] += orderQuantity[j];
						}
						else
							error.println("ERROR: " + ItemName[i] + " " + orderQuantity[j] + " requested but only " + Quantity[i] + " remaining.");
					}
				}
			}
			
			for(int a = 0; a < orderID.length; a++) {
					if(Arrays.asList(ItemID).contains(orderID[a]))
						continue;
					else
						error.println("ERROR: Product " + orderID[a] + " not found.");
			}
			error.close();
			
			try {
			      PrintWriter output = new PrintWriter(new File("Assignment04_Receipt.txt"));

			      output.println("*****CUSTOMER TOTAL*****");
			      for(int k = 0; k < ItemID.length; k++) {
						if(totalItem[k] !=  0)
							output.println(ItemName[k] + " ("+ ItemID[k] + ") " + " - " + totalItem[k] + " * " + Price[k] + " = " + totalItem[k]*Price[k]);
					}
			      output.println("Total due - " + total);
			      output.println("*************************");
			      output.close();
			}catch (FileNotFoundException e) {}
			
			try {
				PrintWriter pw = new PrintWriter(new File("Assignment04_ProductInfoAfterOrder.txt"));
				for(int k = 0; k < ItemID.length; k++) {
					pw.print(ItemID[k] + " " + ItemName[k] + " " + Quantity[k] + " " + Price[k]);
					pw.println();	
				}
				pw.close();
			}catch(FileNotFoundException e){}
		}catch(Exception e){}
	}
}