package programs;

import java.util.*;

public class StringHashMap2
{
	public static void main(String args[])
	{
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter String");
		String str;
		str = scan.nextLine();
		String splitter[] = str.split("\\s+");
		for(String s:splitter)
		{		
			if(hmap.containsKey(s))
			{
				hmap.get(s);
				int i = hmap.get(s);
				i++;
				hmap.put(s, i);
			}
			else
			{
				hmap.put(s, 1);
			}
			
		}
		System.out.println(hmap);
		
		for(String s1:hmap.keySet())
		{
			System.out.println(hmap.get(s1));
		}

	}
}
