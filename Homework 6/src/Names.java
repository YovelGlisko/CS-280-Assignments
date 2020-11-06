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
		int falseCount = 0;
		try {
			BufferedReader girlInput = new BufferedReader(new FileReader (girlFile));
			String line = girlInput.readLine();
			while (line != null) {
				String[] split = line.split(" ");
				names.add(split[0]);
			}
			BufferedReader boyInput = new BufferedReader(new FileReader (boyFile));
			line = boyInput.readLine();
			while (line != null) {
				String[] split = line.split(" ");
				if(!add(split[0])) {
					falseCount++;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}

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
