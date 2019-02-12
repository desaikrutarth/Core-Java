package programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class fileHashMap
{
	public static void main(String args[]) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Krutarth//Documents//notes.txt"));
		Scanner s = new Scanner(System.in);
		System.out.println("enter contains of the file");
		String str = s.nextLine();
		writer.write(str);
		writer.close();
		
		BufferedReader reader = new BufferedReader(new FileReader("C://Users//Krutarth//Documents//notes.txt"));
		String str1;
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		while(( str1= reader.readLine()) != null)
		{
			System.out.println(str1);
			String splitter[] = str1.split("\\s+");
			for(String str2:splitter)
			{
				if(hmap.containsKey(str2))
				{
					int i = hmap.get(str2);
					i++;
					hmap.put(str2, i);
				}
				else
				{
					hmap.put(str2,1);
				}
			}
	
		}
		System.out.println(hmap);
		reader.close();
	}
}
