package programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadReplace 
{
	public static void main(String[] args) throws IOException
	{
		String file = "C://Users//Krutarth//Documents//read.txt";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = reader.readLine();			
		System.out.println(str);
		System.out.println(str.replace(";", "\n"));
	}
}
