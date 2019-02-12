package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapHashMap 
{
	public static void main(String[] args)
	{
		HashMap<String, HashMap<String, ArrayList<String>>> hmap = new HashMap<String, HashMap<String, ArrayList<String>>>();
		HashMap<String, ArrayList<String>> map1 = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> map2 = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		
		String fruits = "Fruits";
		String vegetables = "Vegetables";
		String flowers = "Flowers";
		
		list1.add("apple");
		list1.add("banana");
		
		map1.put(fruits,list1);
		
		list2.add("chili");
		list2.add("potato");
		
		map1.put(vegetables,list2);
		
		list3.add("rose");
		list3.add("blossom");
		
		map1.put(flowers, list3);
		
		ArrayList<String> list4 = new ArrayList<String>();
		ArrayList<String> list5 = new ArrayList<String>();
		ArrayList<String> list6 = new ArrayList<String>();
		
		String mobile = "Mobile";
		String TV = "TV";
		String laptop = "Laptop";
		
		list4.add("Apple");
		list4.add("Samsung");
		
		map2.put(mobile, list4);
		
		list5.add("Sony");
		list5.add("Sharp");
		
		map2.put(TV, list5);
		
		list6.add("HP");
		list6.add("Dell");
		
		map2.put(laptop, list6);
		
		String grocery = "Grocery";
		String electronics = "Electronics";

		hmap.put(grocery, map1);
		hmap.put(electronics, map2);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Select categories from 'Grocery' and 'Electronics'");
		String category = scan.nextLine();
		
		HashMap<String, ArrayList<String>> hm = hmap.get(category);
		System.out.println(hm.keySet());
		
		System.out.println("Select Sub Category");
		String subCategory = scan.nextLine();
		
		ArrayList<String> ls = null;
		
		if(category.equals(grocery))
		{
			ls= map1.get(subCategory);
		}
		else
		{
			ls = map2.get(subCategory);
		}
		System.out.println(ls);	
		
	}
}
