/**
 * Yovel Glisko
 * Nov 6, 2020
**/
import java.io.*;
import java.util.*;
public class Names {
	public static HashSet<String> names = new HashSet<String>();
	public static ArrayList<String> commonNames = new ArrayList<String>();
	public static void main(String[] args) {
		File boyFile = new File("boynames.txt");
		File girlFile = new File("girlnames.txt");
		int numBoys = 0;
		int numGirls = 0;
		int falseCount = 0;
		try {
			BufferedReader girlInput = new BufferedReader(new FileReader (girlFile));
			String line = girlInput.readLine();
			while (line != null) {
				String[] split = line.split(" ");
				names.add(split[0]);
				numGirls += Integer.parseInt(split[1]);
				line = girlInput.readLine();
			}
			girlInput.close();
			BufferedReader boyInput = new BufferedReader(new FileReader (boyFile));
			line = boyInput.readLine();
			while (line != null) {
				String[] split = line.split(" ");
				if(!add(split[0])) {
					falseCount++;
				}
				numBoys += Integer.parseInt(split[1]);
				line = boyInput.readLine();
			}
			boyInput.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		System.out.println("The number of common names is " + commonNames.size());
		System.out.println("The common names are: ");
		for(int i = 0; i < commonNames.size(); i++) {
			System.out.println(commonNames.get(i));
		}
		System.out.println("The total number of boys in this census is " + numBoys);
		System.out.println("The total number of girls in this census is " + numGirls);
		System.out.println("The total number of individuals in this census is " + (numBoys + numGirls));
		

	}
	public static boolean add(String name) {
		if(names.contains(name)) {
			commonNames.add(name);
			return false;
		}
		else {
			names.add(name);
			return true;
		}
	}

}
