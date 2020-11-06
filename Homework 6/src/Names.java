/**
 * Yovel Glisko
 * Nov 6, 2020
**/
import java.io.*;
import java.util.*;
public class Names {
	// here I start by setting up some objects that I will use in the program. I create names which is the HashSet I will use to store all of the unique names from the text file. I create 
	// commonNames which is the ArrayList I will use to store all of the common names
	public static HashSet<String> names = new HashSet<String>();
	public static ArrayList<String> commonNames = new ArrayList<String>();
	public static void main(String[] args) {
		// here I set up the two files as well as three integers to be counters for the number of boys, number of girls, and number of common names
		File boyFile = new File("boynames.txt");
		File girlFile = new File("girlnames.txt");
		int numBoys = 0;
		int numGirls = 0;
		int falseCount = 0;
		try {
			// here I create the reader for the girlnames file and take the first line and assign it to a string called line. I use a while loop that checks if there is anything on the line so that it can keep going
			BufferedReader girlInput = new BufferedReader(new FileReader (girlFile));
			String line = girlInput.readLine();
			while (line != null) {
				// since the line is a word and a number separated by a space I create an array split on the space
				String[] split = line.split(" ");
				// since no names are in names, there is no need to check for duplicates so I just add the names to names. I also add to the counter of the number of girls and set the next line to make the loop work
				names.add(split[0]);
				numGirls += Integer.parseInt(split[1]);
				line = girlInput.readLine();
			}
			// here I close the girlInput reader before doing mostly the same thing but for the boynames file
			girlInput.close();
			BufferedReader boyInput = new BufferedReader(new FileReader (boyFile));
			line = boyInput.readLine();
			while (line != null) {
				String[] split = line.split(" ");
				// a difference is here where I use a helper method which returns a boolean of true for a successful add and false for a failed add, or common name. if false is returned I add one to the counter
				if(!add(split[0])) {
					falseCount++;
				}
				numBoys += Integer.parseInt(split[1]);
				line = boyInput.readLine();
			}
			boyInput.close();
			// here I catch two possible errors and provide basic info about what happened
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		// here I simply print out the results of the program basically with a simple for loop and some basic addition
		System.out.println("The number of common names is " + falseCount);
		System.out.println("The common names are: ");
		for(int i = 0; i < commonNames.size(); i++) {
			System.out.println(commonNames.get(i));
		}
		System.out.println("The total number of boys in this census is " + numBoys);
		System.out.println("The total number of girls in this census is " + numGirls);
		System.out.println("The total number of individuals in this census is " + (numBoys + numGirls));
		

	}
	// this is my helper method for adding names when there is a chance of duplicates
	public static boolean add(String name) {
		// I check if the names HashSet contains the name and if so, I add it to the commonNames arraylist and return false to indicate it has not been added to the HashSet
		if(names.contains(name)) {
			commonNames.add(name);
			return false;
		}
		// if names doesn't contain the name, I add it to names and return true to indicate it has been added to names.
		else {
			names.add(name);
			return true;
		}
	}

}
