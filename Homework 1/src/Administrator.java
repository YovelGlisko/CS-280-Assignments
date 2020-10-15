/**
 * 
 * Yovel Glisko
 * 9/16/2020
 *
 */
import java.util.Scanner;
public class Administrator extends SalariedEmployee {
	// creates the three instance variables for the class
	private String Title;
	private String Responsibility;
	private String Supervisor;
	// accessor that returns the title
	public String getTitle() {
		return Title;
	}
	// mutator that sets the title
	public void setTitle(String title) {
		Title = title;
	}
	
	// accessor that returns the area of responsibility
	public String getResponsibility() {
		return Responsibility;
	}
	// mutator that sets the area of responsibility
	public void setResponsibility(String responsibility) {
		Responsibility = responsibility;
		
	}
	// accessor that returns the name of the supervisor
	public String getSupervisor() {
		return Supervisor;
	}
	// mutator that sets the name of the supervisor
	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}
	
	// three argument constructor that initializes the three variables using the mutators and the super method
	public Administrator(String title, String responsibility, String supervisor) {
		super();
		setTitle(title);
		setResponsibility(responsibility);
		setSupervisor(supervisor);
		
	}
	
	// six argument constructor that initializes the three administrator variables using the mutators and the three other variables using the super method
	public Administrator(String name, Date date, double salary , String title, String responsibility, String supervisor) {
		super(name, date, salary);
		setTitle(title);
		setResponsibility(responsibility);
		setSupervisor(supervisor);
	}
	
	// method that uses the superclass's toString and some simple addition with the accessor methods to compile all the info for an administrator into a string
	public String toString() {
		return (super.toString() + ", " + getTitle() + " in charge of " + getResponsibility() + " and supervised by " + getSupervisor());
	}
	
	// method that creates a scanner object to get the data for the adminstrator's information. the method prints a prompt and then records the input into variables 
	// and sets them through the super method and the mutator methods.
	public static Administrator getData() {
		// this creates the scanner object and asks for a name input before taking that input and storing it as a string
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome! Please input your Name!");
		String name = keyboard.nextLine();
		
		// getting the date is complicated so I simply had the user input the date in a string format such as 03/05/2010, split that string into an array based on the character "/"
		// and parsed each string in the array to an integer which I put all together to create the date object
		System.out.println("Thanks " + name + "! Now input your hire date in the format [month]/[day]/[four digit year] with them all being integers! An example would be 10/25/2009");
		String[] dateArray = keyboard.nextLine().split("/");
		int month = Integer.parseInt(dateArray[0]);
		int day = Integer.parseInt(dateArray[1]);
		int year = Integer.parseInt(dateArray[2]);
		Date date = new Date(month, day, year);
		
		// this asks for a salary and assigns it to a double
		System.out.println("Thank you! Please now input your yearly salary!");
		double salary = Double.parseDouble(keyboard.nextLine());
		
		// this asks for the title and assigns it to a string
		System.out.println("Thank you! Now please provide your title such as Director or Vice President!");
		String title = keyboard.nextLine();
		
		// this asks for the area of responsibility and assigns it to a string
		System.out.println("Thank you! Please input what your area of responsibility is such as Accounting or Production!");
		String responsibility = keyboard.nextLine();
		
		// this asks for the name of the supervisor and assigns it to a string
		System.out.println("Thank you! The last thing we need is the name of your immediate supervisor. Please input that now!");
		String supervisor = keyboard.nextLine();
		
		// this thanks the user for the information and closes the scanner object which isn't strictly necessary but is good practice
		System.out.println("Thanks for using our system. Your data will be inputted now!");
		keyboard.close();
		
		// this assigns all the info to a new object called admin that is created with the six argument constructor before returning it at the end
		Administrator admin = new Administrator(name, date, salary, title, responsibility, supervisor);
		return admin;
	}
}
