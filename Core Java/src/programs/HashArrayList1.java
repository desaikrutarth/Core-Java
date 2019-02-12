package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;
import java.util.Map;
import java.util.Scanner;

public class HashArrayList1
{
	public static void main(String args[])
	{
		HashMap<String,ArrayList<String>> hmap1 = new HashMap<String,ArrayList<String>>();

		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		
		String fruits = "fruits";
		String flowers = "flowers";
		String vegetables = "vegetables";
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Fruits");
		for(int i=0; i < 3; i++)
		{
			String str1 = scan.nextLine();
			list1.add(str1);
			hmap1.put(fruits,list1);
		}
		
		System.out.println("Enter flowers");
		for(int i=0; i < 3; i++)
		{
			String str2 = scan.nextLine();
			list2.add(str2);
			hmap1.put(flowers,list2);
		}
		
		System.out.println("Enter Vegetables");
		for(int i=0; i < 3; i++)
		{
			String str3 = scan.nextLine();
			list3.add(str3);
			hmap1.put(vegetables,list3);
		}
		
		System.out.println("Select your category");
		String category = scan.nextLine();
		
		ArrayList<String> al = hmap1.get(category);
		System.out.println(al);
		
		
	}		
}
