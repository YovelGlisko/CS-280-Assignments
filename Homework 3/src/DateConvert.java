/**
 * 
 * Yovel Glisko
 * 10/1/2020
 *
 */
import java.util.Scanner;
public class DateConvert {
	public static void main(String[] args) {
		System.out.println("Please input a day in the format MM/DD/YYYY. As an example: September 3rd, 2000 would be 9/3/2000");
		Scanner scanner = new Scanner(System.in);
		// here I create an array that takes the user input and splits by the / to get the month, day, and year separated
		String[] dateString = scanner.nextLine().split("/");
		// I use these three booleans to make the loops function properly so that for each impossible user input, they get a chance to specifically fix that one input. this works for multiple incorrect inputs too
		boolean runMonth = true;
		boolean runYear = false;
		boolean runDay = false;
		// these are the three ints that the user is setting. I set them all to 0 by default since that is an impossible number for any of them to actually have, not that it particularly matters
		int day = 0;
		int month = 0;
		int year = 0;
		// this is the first loop. it checks if runMonth is true which it is by default to get the program running before going into a try which lets me catch month exceptions since this loop is simply for the month
		while(runMonth) {
		try{
			// here I use a method I made to check if the inputted month is even an integer at all and if it is it moves on and assigns it to the month variable and if not it throws an exception.
			if(checkIntCompatibility(dateString[0])){
			month = Integer.parseInt(dateString[0]);
			// here it checks if the month is over 12 or under 1 which are both obviously impossible. if it is it throws an exception.
			if(month > 12 || month < 1) {
				throw new MonthException();
			} else {
				// this part is reached when the month is confirmed valid and is assigned. it changes runYear to true so the year loop runs next and sets runMonth to false so it stops running.
				runYear = true;
				runMonth = false;
			}
		} else {
			throw new MonthException();
		}
			// here is what happens when I catch the exception. I send a message out saying the month was invalid and then use the scanner to get another input from the user that it puts back in the original array so when the loop restarts it works perfectly.
		} catch (MonthException m) {
			System.out.println(m.getMessage());
			dateString[0] = scanner.nextLine();
		}
		}
		// this is the start of the second loop. it operates practically identically to the first. it starts the while loop based on runYear which was set to true at the end of the month loop.
		while(runYear) {
			// it starts the try and checks if the year is an int. if not it throws an exception and if it is then it sets year to the inputted year.
			try {
			if(checkIntCompatibility(dateString[2])) {
			year = Integer.parseInt(dateString[2]);
			// it checks if the year is not between 1000 and 3000 as instructed and if it is not between those years it throws an exception and if it is it sets the booleans to move on to the next section.
			if(year > 3000 || year < 1000) {
				throw new YearException();
				} else {
					runDay = true;
					runYear = false;
				}
		} else {
			throw new YearException();
		} 
			// this catch is the same as before effectively. it catches the exception and sends a message prompting for a new year before taking the user input for the year and putting it in the array so the loop can start again
		} catch (YearException y) {
			System.out.println(y.getMessage());
			dateString[2] = scanner.nextLine();
		}
		}
		// this is the day loop which has some differences from the previous ones. it starts with the same while loop and try situation where it checks if the day is an int before assigning it to day and throwing an exception if necessary
		while(runDay) {
		try {
		if(checkIntCompatibility(dateString[1])) {
			day = Integer.parseInt(dateString[1]);
			// here the loop uses another method I created, numDays which takes a month and a year and returns the number of days in that month. if the day is not a valid number of days, it throws an exception and if it is valid, it moves on.
			if (day < 1 || day > numDays(month, year)) {
				throw new DayException();
					} else {
						// when it moves on, it uses another method I made which takes an int month and returns the string of the full name. this part prints that method's string result along with the day and year converted to strings and sets runDay to false to finsih the program.
					System.out.println(monthName(month) + " " + Integer.toString(day) + ", " + Integer.toString(year));
					runDay = false;
					}
						} else {
							throw new DayException();
						}
				// here I catch the day exceptions which like before sends a prompting message to fix the day and takes the new input and assigns it to the array
					} catch (DayException d) {
						System.out.println(d.getMessage());
						dateString[1] = scanner.nextLine();
				}
			}
		scanner.close();
			}
		
	// this is my method to check if something is an integer. it does this by using a try on Integer.parseInt and if there is an error it simply returns false. if there is not that means the string is an int and it returns true.
	public static boolean checkIntCompatibility(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	// this is my method used to find if a year is a leap year. it is used in the numDays method later. basically it checks if a number mod another number has a remainder of 0 which means it is evenly divisble. it uses this with standard rules for leap years to return
	// if the year is a leap year or not through a true or false.
	public static boolean isLeapYear(int year) {
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			} 
		} else {
			return false;
		}
	}
	// this is my method used to find the number of days in a given month of a given year. it checks if the month is any month with 31 days and returns 31 if it is. it then checks if the month is any of the months with 30 days and returns 30 if it is
	// if not, it is clear the month is february so it simply checks if it is a leap year using the above method. if it is, it returns 29. if not, it returns 28.
	public static int numDays(int month, int year) {
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else if (isLeapYear(year)) {
			return 29;
		} else {
			return 28;
		}
	}
	// this is my method used to take an int month and return the string of the English name of the month. it basically just checks if the month is the same int as each month one by one and returns a String for each.
	public static String monthName(int month) {
		if(month == 1) {
			return "January";
		} else if(month == 2) {
			return "February";
		} else if(month == 3) {
			return "March";
		} else if(month == 4) {
			return "April";
		} else if(month == 5) {
			return "May";
		} else if(month == 6) {
			return "June";
		} else if(month == 7) {
			return "July";
		} else if(month == 8) {
			return "August";
		} else if (month == 9) {
			return "September";
		} else if (month == 10) {
			return "October";
		} else if (month == 11) {
			return "November";
		} else {
			return "December";
		}
	}
}