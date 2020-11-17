
import java.sql.*;
public class World {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://frodo.bentley.edu:3306/world";
		String username = "harry";
		String password = "harry";
		try (Connection con = DriverManager.getConnection(URL, username, password)) {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM city WHERE Name = 'Nonsan';");
			if (result.next()) {
         		String code = result.getString("CountryCode");
         		int population = result.getInt("Population");
         		System.out.println("The city of Nonsan has a country code of " + code + " and a population of " + population);
         		String sql = "SELECT * FROM country WHERE code=?;";
    			PreparedStatement prepared = con.prepareStatement(sql);
    			prepared.setString(1,  code);
    			ResultSet countryResult = prepared.executeQuery();
    			if(countryResult.next()) {
    				String country = countryResult.getString("Name");
    				String continent = countryResult.getString("Continent");
    				System.out.println("The city of Nonsan is in the country of " + country + " which is on the continent of " + continent);
    			}
    		} else {
				System.out.println("The city of Nonsan doesn't exist");
				System.exit(0);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

}
