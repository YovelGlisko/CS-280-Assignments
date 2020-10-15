/**
 * 
 * Yovel Glisko
 * 9/24/2020
 *
 */
import java.util.Scanner;
public class MultiItemSale {
	public static void main(String[] args) {
		// here I set up some variables I will be using. I create a boolean run which is used to run the while loop. I create the sales array which holds the sales. I create the total
		// which is used to find the total at the end. I create the arrayCount which keeps track of position within the array
		Boolean run = true;
		Sale[] sales = new Sale[100];
		double total = 0;
		int arrayCount = 0;
		// here I set up the scanner and send the user a message about how to format their messages and use the program.
		System.out.println("Please enter sales in the format [name] [price] [discount]%. As an example: bell 5.00 5%. Continue entering sales until done and type 'end' to end");
		Scanner scanner = new Scanner(System.in);
		// I open the while loop here. this loop has a lot of moving parts. first it checks the line and assigns it to a string. it is checked if the user typed "end". if they did, the
		// ending sequence is ran. if not, the sale they entered is added to the array.
		while(run) {
		String line = scanner.nextLine();
		if(line.toLowerCase().equals("end") ) {
			// this for loop is what is mostly used for the end sequence. it goes through each item that the array has by going up to the index of the counter, not inclusive. for each of 
			// these it checks if the object is the type DiscountSale using instanceOf and if it is it adds the total to itself plus the bill of the DiscountSale. it has to cast the object to a 
			// DiscountSale to allow it to run even though it is impossible for it to be a regular Sale at this point. if it is not a DiscountSale, the total is added to itself with the price from getPrice
			for(int i = 0; i < arrayCount;i++) {
				if(sales[i] instanceof DiscountSale) {
					total = total + ((DiscountSale) sales[i]).bill();
				} else {
				total = total + sales[i].getPrice();
				}
			}
			// the end sequence ends by printing out the total with printf and critically uses ".2f" to format the total with two decimal places. finally it sends run to false to end the while loop and the program.
			System.out.printf("The total sale price is $%.2f", total);
			run = false;
		} else {
			// here is the sequence used to add the sales to the array. first the line that is inputted it split into an array of strings via saleInfo which is then split into a string and two doubles. the discount 
			// is actually split again to remove the % sign from it to make it just a normal double
			String[] saleInfo = line.split(" ");
			String itemName = saleInfo[0];
			Double itemPrice = Double.parseDouble(saleInfo[1]);
			Double itemDiscount = Double.parseDouble(saleInfo[2].split("%")[0]);
			// here it is determined if the sale is a DiscountSale by seeing if the discount inputted is non-zero. if it is zero, a Sale object is created with the name and price and inserted into the array sales
			// at the point the arrayCount is. the arrayCount is raised by one using arrayCount++ to make sure the value is still accurate.
			if(itemDiscount == 0) {
				Sale sale = new Sale(itemName, itemPrice);
				sales[arrayCount] = sale;
				arrayCount++;
			} 
			// in this case, the sale is a DiscountSale so a DiscountSale object is made with the name, price, and discount and inserted into the sales array. as with regular sales, it is inserted at the point of
			// arrayCount and arrayCount is raised by one to keep it up to date.
			else {
				DiscountSale discountSale = new DiscountSale(itemName, itemPrice, itemDiscount);
				sales[arrayCount] = discountSale;
				arrayCount++;
			}
		}
		}
		// here after the while loop is over, the scanner is closed which is always good practice.
		scanner.close();
	}
}
