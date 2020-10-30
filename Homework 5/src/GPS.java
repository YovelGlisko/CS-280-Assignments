/**
 * 
 * Yovel Glisko
 * 10/30/2020
 *
 */
import java.util.*;
public class GPS {
	// here I set the map scale in a convenient location which would allow it to be altered without breaking everything
	final static double mapScale = 0.1;
	public static void main(String[] args) {
		// here I start creating some important parts such as the ArrayList of Waypoint objects, a scanner to read inputs, a double to maintain a count of distance, and a boolean used to get the while loop to run
		ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
		Scanner scan = new Scanner(System.in);
		double totalDistance = 0;
		boolean run = true;
		// the instructions say that the GPS starts at 0, 0, 0 so here I add this as the first coordinate before starting the loop
		waypoints.add(new Waypoint(0, 0, 0));
		while(run) {
			// in this loop, based on the boolean run from earlier, I have the user input the x coordinate first with a simple scanner method and then I check this for being less than zero. if it is, that means the user is done and it stops the loop.
			// if not, the rest continues and I check for the y coordinate and the timestamp in seconds
			System.out.println("Enter coordinates (X < 0 to stop): \nX coordinate: ");
			double xInput = scan.nextDouble();
			if(xInput < 0) {
				run = false;
			} else {
			System.out.println("Y coordinate: ");
			double yInput = scan.nextDouble();
			System.out.println("Enter timestamp in seconds: ");
			int timeInput = scan.nextInt();
			// here I take the newly acquired information to add a Waypoint to the ArrayList storing the information. I also add to the totalDistance variable by taking the new Waypoint and the prior one and putting it in my helped method distance.
			waypoints.add(new Waypoint(xInput, yInput, timeInput));
			totalDistance += distance(waypoints.get(waypoints.size() - 2), waypoints.get(waypoints.size() - 1));
			}
		}
		// here I close the scanner and round my total distance to 2 decimal places before printing this result
		scan.close();
		totalDistance = Math.round(totalDistance * 100.0) / 100.0;
		System.out.println("The total distance traveled is " + totalDistance + " miles.");
		// here I calculate the miles per hour by taking the total distance and the timestamp of the last Waypoint in the ArrayList. I also round this the same way as the total distance and print it.
		double mph = totalDistance/waypoints.get(waypoints.size() - 1).getTime();
		mph = Math.round(mph * 100.0) / 100.0;
		System.out.println("The average speed is " + mph + " miles per hour.");
	}
	// this is my helper method used to calculate distance. it takes in two Waypoint objects and uses the accessor methods build in to get the x and y position for each Waypoint. this x and y position are multiplied by the variable mapScale from earlier to 
	// make adjustments simple. the difference between each scaled x position is taken and squared. this is added to the squared difference of the scaled y positions. finally getting the square root of this whole value gets one the distance between these two points.
	public static double distance(Waypoint point1, Waypoint point2) {
		return Math.sqrt(Math.pow((point1.getPosX()*mapScale - point2.getPosX()*mapScale), 2) + 
			   Math.pow((point1.getPosY()*mapScale - point2.getPosY()*mapScale), 2));
	}
	
	// this is my Waypoint class which is used to set up how Waypoint objects will function. I start by creating the three basic variables, posX for x position, posY for y position, and time for timestamp
	static class Waypoint {
		private double posX;
		private double posY;
		private int time;
		// this accessor method simply returns the x position
		public double getPosX() {
			return posX;
		}
		// this mutator method simply sets the x position
		public void setPosX(double posX) {
			this.posX = posX;
		}
		// this accessor method simply returns the y position
		public double getPosY() {
			return posY;
		}
		// this mutator method simply sets the y position
		public void setPosY(double posY) {
			this.posY = posY;
		}
		// this accessor method simply returns the timestamp
		public int getTime() {
			return time;
		}
		// this mutator method simply sets the timestamp
		public void setTime(int time) {
			this.time = time;
		}
		// this constructor is used to set up the Waypoint objects and assign the variables correctly.
		public Waypoint(double x, double y, int t) {
			posX = x;
			posY = y;
			time = t;
		}
	}
}