/**
 * Yovel Glisko
 * Oct 6, 2020
**/
// I start by importing java.io.* since I need to import a few different parts of java.io and it saves space to just import them at once. I also import Scanner to be able to get user input for the file name
import java.io.*;
import java.util.Scanner;
public class BlankFixer {
	public static void main(String[] args) {
		// here I start setting up some objects and variables that I will use in the program. I create fileName which is the String for the name of the temporary file that will be created which starts as tempFile0.txt but
		// changes depending on what files exist. I create a File object called testFile based on this fileName. I set up a counter which will be used to find a file name that is not already taken. I create a PrintWriter which
		// will be used to write to the temporary file. 
		String fileName = "tempFile0.txt";
		File testFile = new File(fileName);
		int count = 1;
		PrintWriter output = null;
		// I use this while loop here to find the file name which is not taken. first I use a while loop to check if there is a file that exists with the name fileName. if it does, I replace the regex of the integer count minus 
		// one with the regex of the integer count. I then raise count by one and set the testFile to a file object with the new fileName. the while loop then starts again, checking if the file already exists. if it does, it goes again.
		// this repeats until it ends with a fileName that is unique and formatted in an easily understandable way with "tempFile" followed by an incrementing number. 
		while (testFile.exists()) {
			fileName = fileName.replaceAll(Integer.toString(count - 1), Integer.toString(count));
			count++;
			testFile = new File(fileName);
		}
		// this is where I assign the PrintWriter from earlier to the testFile which is now known to be not conflicting with an existing file. I use a try catch to catch a potential error of FileNotFoundException even though I already 
		// am pretty much certain it exists. regardless, it tries to set the object output to a PrintWriter on the file testFile using a FileOutputStream to make sure it is all assigned correctly.
		try {
			output = new PrintWriter(new FileOutputStream(testFile));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		// here I create a Scanner object called user which is to be used to find the file name that needs to be fixed. I have a print that asks for the file name and I assign the file name to a String userFile
		Scanner user = new Scanner(System.in);
		
		System.out.println("Please write the name of the file that needs to be edited.");
		String userFile = user.nextLine();
		// I use a while loop here to make sure I have a valid file. inside the while statement is !checkFile(userFile) which means that it is looking for there not to be a file that exists with that name by using a method I made called checkFile. 
		// inside the while loop there is an if else statement. this checks if the user inputed the file name without a ".txt" by checking if the checkFile works with this added. if it is, it adds ".txt" to the String userFile which will end the while loop
		// on the next run through. in the else, it prompts the user for a new file name and sets userFile to this new name before checking the while and running the loop again.
		while(!checkFile(userFile)) {
			if(checkFile(userFile + ".txt")) {
				userFile = userFile + ".txt";
			} else {
				System.out.println("File name was invalid. Please input another one.");
				userFile = user.nextLine();
			}
		}
		
		// at this point, I finally have both the temporary file and the user file so I can start the process of copying everything over to the new temporary file without the extra spaces. I accomplish this with a big try catch
		try {
			// here I create a new BufferedReader to read through the user file that needs to be fixed. I use FileReader to assist this to work correctly before assigning the first line to a String called line. I also create an int called multiSpace
			// that I set to 0 to assist later in finding the multiple spaces
			BufferedReader input = new BufferedReader(new FileReader (userFile));
			String line = input.readLine();
			int multiSpace = 0;
			// here I start the while loop which will go through the user file and bring it over to the temporary file without the extra spaces. it checks if the line is not null since if it is null, that means the reader has reached the end of the file
			while(line != null) {
				// I then use a for loop which goes through each character in the String line. for each of these characters an if else is used. the if checks if the character is not a space. if it is not a space, it uses the Object output from earlier to 
				// write this character to the temporary file. it also sets multiSpace to 0 to indicate a character has been reached. 
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) != ' ') {
					multiSpace = 0;
					output.print(line.charAt(i));
				// in the else here, it checks if multiSpace is greater than or equal to one. this is because it knows that the character is a space and if it is, it wants to know if there are more before it. if there are, it raises multiSpace by one
				// and does not print anything to the temp file, moving on to the new character. if multiSpace is not greater than or equal to 1 then it indicates that it is the first consecutive space meaning it writes this space character to the temp
				// file and raises multiSpace by one. iterating through the line like this writes the entire line with only one consecutive space at each part.
				} else {
					if(multiSpace >= 1) {
						multiSpace++;
					} else {
						multiSpace++;
						output.print(line.charAt(i));
					}
				}
			}
			// here, after finishing an entire line, it prints a new line marker to the temp file to make sure the line spacing is correct. it then sets line to the next line from the reader.
			output.print("\n");
			line = input.readLine();
			}
			// here I close the objects input and output and the Scanner user since they are no longer necessary. the entire file has been copied over without the extra spaces.
			input.close();
			output.close();
			user.close();
			
			// here I create a new reader and writer in the same way as earlier to read from the temp file and write to the user file with the changes.
			BufferedReader copyRead = new BufferedReader(new FileReader (fileName));
			PrintWriter copyWrite = new PrintWriter(new FileOutputStream(userFile));
			
			// this is a more simple version of the previous while loop. I set line to the first line from the reader of the temp file and create a while loop to check for when those lines are not null since when they are the file is done. 
			// in the loop I simply write a full line with a new line marker using println and set the String line to the next line.
			line = copyRead.readLine();
			while (line != null) {
				copyWrite.println(line);
				line = copyRead.readLine();
			}
			// after these lines have all been written to the user file, I can close the new reader and writer and use .delete() to delete the temporary file. 
			copyRead.close();
			copyWrite.close();
			testFile.delete();
			// here I catch too potential errors and simply print out the problem associated.
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
		
	}
	// this is the helper method I created to return a boolean showing if a file exists. it accomplishes this by trying to read from the file. if it works then it returns true and if it does not then presumably the file does not exist or is invalid in some way
	// so it returns false. 
	public static boolean checkFile(String fileName) {
		try {
			BufferedReader input = new BufferedReader(new FileReader (fileName));
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} 
	}
}
