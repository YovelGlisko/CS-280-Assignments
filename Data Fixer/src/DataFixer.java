import java.io.*;
import java.util.Scanner;
public class DataFixer {
	public static void main(String[] args) {
		File readFile = new File("data.txt");
		try {
			BufferedReader input = new BufferedReader(new FileReader (readFile));
			String line = input.readLine();
			int lineCount = 1;
			while(line != null) {
				if(lineCount < 18) {
					String actor[] = line.split(" ");
					System.out.println("INSERT INTO ACTOR VALUES ('"+actor[0]+"', '"+actor[1] + " " + actor[2] + "', '" + actor[3] + "');");
				} else if (lineCount < 36) {
					String role[] = line.split(" ");
					System.out.println("INSERT INTO ROLE VALUES ('"+role[0]+"', '"+role[1] + "', '" + role[2] + "', '" + role[3] +  "');");
				} else if (lineCount < 44) {
					String movie[] = line.split(" ");
					System.out.println("INSERT INTO MOVIE VALUES ('"+movie[0]+"', '"+movie[1] + "', '" + movie[2] + "', '" + movie[3] +  "');");
				} else if (lineCount < 52) {
					String director[] = line.split(" ");
					System.out.println("INSERT INTO DIRECTOR VALUES ('"+director[0]+"', '"+director[1] + " " + director[2] + "', '" + director[3] + "');");
				} else if (lineCount < 60) {
					String showing[] = line.split(" ");
					System.out.println("INSERT INTO SHOWING VALUES ('"+showing[0]+"', '"+showing[1] + "', '" + showing[2] + "', '" + showing[3] +  "');");
				} else {
					String theater[] = line.split(" ");
					System.out.println("INSERT INTO THEATER VALUES ('"+theater[0]+"', '" + theater[1] +  "');");
					
				}
				lineCount++;
				line = input.readLine();
			}
			line = input.readLine();
			
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file");
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
	}
}
