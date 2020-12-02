import java.io.*;
import java.util.Scanner;
public class DataFixer2 {
	public static void main(String[] args) {
		File readFile = new File("data.txt");
		try {
			BufferedReader input = new BufferedReader(new FileReader (readFile));
			String line = input.readLine();
			int lineCount = 1;
			while(line != null) {
				/**if(lineCount < 9) {
					String actor[] = line.split("&");
					System.out.println("INSERT INTO EMPLOYEE VALUES ('"+actor[0]+"', '"+actor[1] + "', '', '" + actor[2] + "', '" + actor[3] + "', '" + 
					actor[4] + "', '" + actor[5] + "', '" + actor[6] + "', '" + actor[7] + "', '1');");
				    } else if (lineCount < 14) {
					String actor[] = line.split("&");
					System.out.println("INSERT INTO EMPLOYEE VALUES ('"+actor[0]+"', '"+actor[1] + "', '', '" + actor[2] + "', '" + actor[3] + "', '" + 
							actor[4] + "', '" + actor[5] + "', '" + actor[6] + "', '" + actor[7] + "', '2');");
					} else if (lineCount < 20) {
					String actor[] = line.split("&");
					System.out.println("INSERT INTO EMPLOYEE VALUES ('"+actor[0]+"', '"+actor[1] + "', '', '" + actor[2] + "', '" + actor[3] + "', '" + 
							actor[4] + "', '" + actor[5] + "', '" + actor[6] + "', '" + actor[7] + "', '3');");
					} **/
					/**if(lineCount < 9 ) {
						String emp[] = line.split("&");
						System.out.println("INSERT INTO PHARMACIST(SSN, LicNo, LicExpDate) VALUES ('"+emp[0]+"', '"+emp[1] + "', '" + emp[2] + "');");
					} else {
						String emp[] = line.split("&");
						System.out.println("INSERT INTO NURSE(SSN, LicNo, LicExpDate) VALUES ('"+emp[0]+"', '"+emp[1] + "', '" + emp[2] + "');");
					} **/
				/**String emp[] = line.split("&");
				System.out.println("INSERT INTO ADMINISTRATIVE(SSN, JobTitle) VALUES ('"+emp[0]+"', '"+emp[1] + "');");
				**/
				/**String emp[] = line.split("&");
				System.out.println("INSERT INTO MEDICATION VALUES ('"+emp[0]+"', '"+emp[1]+"', '"+emp[2]+"', '"+emp[3]+"', '"+emp[4]+"', '"+emp[5]+"', '"+emp[6]+"', '"+emp[7] + "');");
				**/
				/**String emp[] = line.split("&");
				System.out.println("INSERT INTO CurrentDrugStock VALUES ('"+emp[0]+"', '"+emp[1]+"', '"+emp[2] + "');");
				**/
				/**String emp[] = line.split("&");
				System.out.println("INSERT INTO DrugStock VALUES ('"+emp[0]+"', '"+emp[1]+"', '"+emp[2] + "');");
				**/
				/**String emp[] = line.split("&");
				System.out.println("INSERT INTO Vendor VALUES ('"+emp[0]+"', '"+emp[1]+"', '"+emp[2]+"', '"+emp[3]+"', '"+emp[4]+"', '"+emp[5] +"', '"+emp[6]+"', '"+emp[7]+  "');");
				**/
				/**String emp[] = line.split("&");
				System.out.println("INSERT INTO Order VALUES ('"+emp[0]+"', '"+emp[1]+"', '"+emp[2]+"', '"+emp[3] + "');");
				**/
				String emp[] = line.split("&");
				System.out.println("INSERT INTO OrderLine VALUES ('"+emp[0]+"', '"+emp[1]+"', '"+emp[2]+"', '"+emp[3]+"', '"+emp[4]+"', '"+emp[5] + "');");
				
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
