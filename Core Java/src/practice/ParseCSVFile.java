package practice;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ParseCSVFile
{
	private void parseCSV(String file) 
	{
		try 
		{ 
	        // Have to import Opencsv library 
	        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file))
	        										.withSkipLines(1)	  // Skipping first row
	        										.build();  
	        
	        List<String[]> allData = csvReader.readAll(); 		// Parse csv and store into List
	  
	        // print Data 
	        for (String[] row : allData)
	        { 
	            for (String cell : row)
	            { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}
	
	public static void main(String[] args)
	{
		ParseCSVFile csv = new ParseCSVFile();
		csv.parseCSV("C:\\Users\\kdesai\\Downloads\\csv_file_test.csv");
	}

}
