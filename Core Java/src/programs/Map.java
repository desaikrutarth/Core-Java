package programs;

import java.util.HashMap;
import java.util.Scanner;

public class Map 
{
	public static void main(String [] args)
	{
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		System.out.println("Enter size of array");
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int arr[] = new int[size];
		
		System.out.println("Enter name and Number");	
		
		for(int i=0; i < size; i++)
		{
			Scanner s = new Scanner(System.in);
			String name = s.nextLine();
			int number = s.nextInt();
			
			if(hmap.containsKey(name))
			{
				int num = hmap.get(name);
				hmap.put(name, num);
			}
			else
			{
				hmap.put(name, number);
			}
		}
		
		System.out.println(size);
		System.out.println(hmap);
		
	}
}
