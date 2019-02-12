package programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reader
{
	

	public static void main(String args[]) throws IOException
	{
	    try {
	    	 String file = "C://Users//Krutarth//Documents//read.txt";

	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Krutarth//Documents//write.txt"));
	 
	        String str;

	        while ((str=reader.readLine()) != null){
	        	System.out.println(str);
	        	writer.write(str);
	        	
	        }
	       writer.write("Hey hi..");
	       reader.close();
	       writer.close();


	    }
	    catch (FileNotFoundException e) {
	       e.printStackTrace();
	    }		
	}
}