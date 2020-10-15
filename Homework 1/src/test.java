/**
 * 
 * Yovel Glisko
 * 9/16/2020
 *
 */
import java.util.Scanner;

public class test {
	public static void main(String args[]) {
		
		// steve is an administrator being used to test the three argument constructor as well as the toString and the accessor methods
		Administrator steve = new Administrator("Director", "Production", "Jake");
		System.out.println(steve.toString());
		System.out.println(steve.getTitle());
		System.out.println(steve.getResponsibility());
		System.out.println(steve.getSupervisor());
		// maya is an administrator being used to test the six argument constructor and the toString
		Date mayaDate = new Date(12, 27, 1990);
		Administrator maya = new Administrator("Maya L", mayaDate, 27000, "President", "Production", "Bill");
		System.out.println(maya.toString());
		// admin is an administrator used to test the getData method which is what reads user input
		Administrator admin = Administrator.getData();
		System.out.println(admin.toString());
		// jason is an administrator used to test the mutator methods
		Administrator jason = new Administrator("Vice President", "Marketing", "Nate");
		jason.setTitle("Director");
		jason.setResponsibility("Personnel");
		jason.setSupervisor("Andy");
		System.out.println(jason.toString());
		
		/**
		// this part I was unsure about since the instructions say the main method of the tester class needs to use the Scanner
		// I think it means I need to do what I did earlier which is call the method from Administrator but just in case I implemented
		// the scanner here too. I apologize if this is not what I was supposed to do but I was genuinely confused by the wording of the question
		// this is mostly copied from the scanner code in Administrator as it is doing basically the same thing
		// however, java does not let this code work in conjunction with the other scanner so I had to comment this out. if you would like to test it
		// you can remove the comments on lines 32 and 79 but you must comment out lines 23 and 24 which are where the first scanner from Administrator come in.
		// sorry about how long and drawn out this is, I am trying to be thorough and want to make sure I do not miss points for some silly misunderstanding.
		
		
		// this creates the scanner object and asks for a name input before taking that input and storing it as a string
		Scanner test = new Scanner(System.in);
		System.out.println("Welcome! Please input your Name!");
		String name = test.nextLine();
		
		// getting the date is complicated so I simply had the user input the date in a string format such as 03/05/2010, split that string into an array based on the character "/"
		// and parsed each string in the array to an integer which I put all together to create the date object
		System.out.println("Thanks " + name + "! Now input your hire date in the format [month]/[day]/[four digit year] with them all being integers! An example would be 10/25/2009");
		String[] dateArray = test.nextLine().split("/");
		int month = Integer.parseInt(dateArray[0]);
		int day = Integer.parseInt(dateArray[1]);
		int year = Integer.parseInt(dateArray[2]);
		Date date = new Date(month, day, year);
				
		// this asks for a salary and assigns it to a double
		System.out.println("Thank you! Please now input your yearly salary!");
		double salary = Double.parseDouble(test.nextLine());
				
		// this asks for the title and assigns it to a string
		System.out.println("Thank you! Now please provide your title such as Director or Vice President!");
		String title = test.nextLine();
				
		// this asks for the area of responsibility and assigns it to a string
		System.out.println("Thank you! Please input what your area of responsibility is such as Accounting or Production!");
		String responsibility = test.nextLine();
				
		// this asks for the name of the supervisor and assigns it to a string
		System.out.println("Thank you! The last thing we need is the name of your immediate supervisor. Please input that now!");
		String supervisor = test.nextLine();
		
		// this thanks the user for the information and closes the scanner object which isn't strictly necessary but is good practice
		System.out.println("Thanks for using our system. Your data will be inputted now!");
		test.close();
		
		// this assigns all the info to a new object called admin that is created with the six argument constructor before printing it with toString
		Administrator adminInput = new Administrator(name, date, salary, title, responsibility, supervisor);
		System.out.println(adminInput.toString());
		**/
	}
}
