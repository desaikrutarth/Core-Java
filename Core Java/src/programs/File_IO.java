package programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_IO 
{
	public static void main(String args[])throws IOException
	{
		String file = "C://Users//Krutarth//Documents//read.txt";
		String i;
		Scanner s = new Scanner(System.in);
		System.out.println("Write your content in the file");
		i = s.nextLine();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Krutarth//Documents//writeFile.txt"));
		String str;
		while((str = reader.readLine()) != null)
		{
			System.out.println(str);
		}
		writer.write(i);
		reader.close();
	    writer.close();
	}
}
