package Interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PrinterImplement implements Printer 
{
	public void print(InputStream in)
	{
		try
		{
			StringBuffer buffer = new StringBuffer();
			long startTime =  System.currentTimeMillis();	// Get the start time in milliseconds
			int readBytes;
		    char ch;
		    
		    while((readBytes = in.read())!= -1)
		    {
		    	long currentTime =  System.currentTimeMillis();		// Get the current time in milliseconds
		    	
	            ch = (char)readBytes;	 // converts integer to character
	            buffer.append(ch);		 // Append each characters in the buffer
	            
	            //If buffer size is 1024 then it is considered as full, then print data
	            // If difference between start time and current is more than 10000 milliseconds that is 10 seconds, then print data
	            if(buffer.length() == 1024 || (currentTime - startTime >= 10000))
	            {
	            	System.out.println(buffer.toString());		// Print data
	            	buffer = new StringBuffer();				// Reset the buffer to print remaining data of file
	            	startTime =  System.currentTimeMillis();	// Reset the start time to check if data is 10 seconds old
	            }
	        }
		    in.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Printer printer = new PrinterImplement();
		printer.print(new FileInputStream("C:\\Users\\kruta\\Downloads\\labels.txt"));
	}

}
