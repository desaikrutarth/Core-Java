package programs;

import java.util.*;

public class StringHashMap
{
	public static void main(String args[])
	{
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		String str = "Hello Hello Hi";
		String[] split = str.split(" ");
		
		for(int i=0; i<split.length; i++)
		{
			if(hmap.containsKey(split[i]))
			{
				int val = hmap.get(split[i]);
				val++;
				hmap.put(split[i],val);
			}
			else
			{
				hmap.put(split[i],1);
			}
		}
		System.out.println(hmap);
		
		
	}
}
