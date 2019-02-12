package programs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileWordCount
{
	public static void main(String[] args) throws IOException
	{
		String file = "C://Users//Krutarth//Documents//read2.txt";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		int count=0;
		while((str = reader.readLine())!= null)
		{
			System.out.println(str);
			String[] splitt = str.split(" ");
			for(int i=0; i<splitt.length; i++)
			{
				count++;
			}
		}
		System.out.println("Total number of words in the file= "+count);	
	}
}
