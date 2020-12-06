import java.io.*;
import java.util.Scanner;
public class DataFixer3 {
	public static void main(String[] args) {
		File readFile = new File("data.txt");
		try {
			BufferedReader input = new BufferedReader(new FileReader (readFile));
			String line = input.readLine();
			int lineCount = 1;
			while(line != null) {
				
				//String course[] = line.split(" ");
				//System.out.println("INSERT INTO STUDENT VALUES ('"+course[0]+"', '"+course[1]+"', '"+course[2]+"', '"+course[3] + "');");
				//String course[] = line.split(" ");
				//System.out.println("INSERT INTO CLASS VALUES ('"+course[0]+"', '"+course[1]+"', '"+course[2]+"', '"+course[3]+"', '"+course[4]+"', '"+course[5]+"', '"+course[6] + "');");
				//String course[] = line.split(" ");
				//System.out.println("INSERT INTO COMPONENT VALUES ('"+course[0]+"', '"+course[1]+"', '"+course[2]+"', '"+course[3]+"', '"+course[4] + "');");
				//String course[] = line.split(" ");
				//System.out.println("INSERT INTO ENROLL VALUES ('"+course[0]+"', '"+course[1]+"', '"+course[2] + "');");
				String course[] = line.split(" ");
				System.out.println("INSERT INTO SCORES VALUES ('"+course[0]+"', '"+course[1]+"', '"+course[2]+"', '"+course[3]+"', '"+course[4] + "');");
				
				
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
