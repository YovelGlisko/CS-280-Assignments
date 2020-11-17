/**
 * Yovel Glisko
 * Nov 17, 2020
**/
import java.sql.*;
public class World {
	public static void main(String[] args) {
		// I start here by simply setting up the database connection utilizing the same method as illustrated in in class examples with a try with resources block and strings
		String URL = "jdbc:mysql://frodo.bentley.edu:3306/world";
		String username = "harry";
		String password = "harry";
		try (Connection con = DriverManager.getConnection(URL, username, password)) {
			// here I start actually setting up the first query using two basic objects and SQL code which checks for the name Nonsan from the assignment and returns all columns which is convenient
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM city WHERE Name = 'Nonsan';");
			// here I run an if else to see if there is actually a result. if there is, I move on and take the information I want: the country code and population by using the ResultSet object I created
			if (result.next()) {
         		String code = result.getString("CountryCode");
         		int population = result.getInt("Population");
         		// here I simply print out the information I received
         		System.out.println("The city of Nonsan has a country code of " + code + " and a population of " + population);
         		// now I set up the second query which uses a PreparedStatement meaning I set up a String called sql to use with it where I leave a ? in the where column to use my country code variable later
         		String sql = "SELECT * FROM country WHERE code=?;";
    			PreparedStatement prepared = con.prepareStatement(sql);
    			// after preparing the statement I inject the string "code" from earlier which is the country code of Nonsan to get the query to return the right information
    			prepared.setString(1,  code);
    			ResultSet countryResult = prepared.executeQuery();
    			// I do the same thing here as before using an if else to test for a result even though it is guaranteed there will be one based on the database structure layed out
    			if(countryResult.next()) {
    				// I receive the results in the same way as before with a ResultSet object and print the information.
    				String country = countryResult.getString("Name");
    				String continent = countryResult.getString("Continent");
    				System.out.println("The city of Nonsan is in the country of " + country + " which is on the continent of " + continent);
    			}
    		} else {
    			// in the case where there is no city of Nonsan I simply print this and exit the program with System.exit(0);
				System.out.println("The city of Nonsan doesn't exist");
				System.exit(0);
			}
			// here I do a simple job catching a possible SQLExpection to show me error info
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

}
