package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashArrayList 
{
	public static void main(String[] args)
	{
		HashMap<String,ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		
		String str1 = "fruits";
		String str2 = "flowers";
		String str3 = "vegitables";
		
		list1.add("apple");
		list1.add("banana");
		list1.add("grape");
		
		hmap.put(str1,list1);
		
		list2.add("Rose");
		list2.add("Jasmine");
		list2.add("Lotus");
		
		hmap.put(str2,list2);
		
		list3.add("Chili");
		list3.add("Cauliflower");
		list3.add("Okra");
		
		hmap.put(str3,list3);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Choose any from fruits, flowers and vegitable");
		String str = s.nextLine();
		
		ArrayList<String> al = hmap.get(str);
		System.out.println(al);
	}
}
