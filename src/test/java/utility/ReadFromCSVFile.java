package utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;



public class ReadFromCSVFile {
	public static void main(String[] args) throws IOException, CsvException {
	        
	        // Create a CSV reader to read the test data
	        CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir") 
	        		+ "\\src\\test\\resources\\test_data.csv"));

	        // Read the CSV data into a list of arrays
	        List<String[]> data = reader.readAll();

	        // Loop through each row of data and execute the test case
	        for (String[] row : data) {
	            // Extract the test data from the row
	            String username = row[0];
	            String password = row[1];

	            System.out.println("username is " + username);
	            System.out.println("password is " + password);
	        }
	    }

}
