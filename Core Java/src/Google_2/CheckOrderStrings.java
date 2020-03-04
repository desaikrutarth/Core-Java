package Google_2;

import java.util.HashMap;
import java.util.TreeMap;

/*
 * given a string p, called order, such as abc, means a in front of b, and so on
given a second string s, to determine whether it is follow the order of p, return boolean, 
example:
	If aaa return true, 
	If cba is false 
	If aaxyc is true, the letters that have not been seen in the order are skipped
 */
public class CheckOrderStrings 
{
	public static boolean checkOrder(String order, String str)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<order.length(); i++) {
			map.put(order.charAt(i), i);
		}

	for(char ch : str.toCharArray())
	{
		if(map.containsKey(ch))
		{
			int index = str.lastIndexOf(ch);
			int orderIndex = map.get(ch);

			if(index < orderIndex) {
				return false;
			}
		}
		}
		return true;
	}

/*	static boolean checkOrder(String str1, String str2)
	{
		HashMap<Character, Integer> hmap1 = new HashMap<>();
		HashMap<Character, Integer> hmap2 = new HashMap<>();
		
		for(int i=0; i<str1.length(); i++)
			hmap1.put(str1.charAt(i), i);
		
		for(int i=0; i<str2.length(); i++)
			hmap2.put(str2.charAt(i), i);

		System.out.println(hmap2);
		for(char ch: hmap2.keySet())
		{
			if(hmap1.containsKey(ch))
			{
				int val1 = hmap1.get(ch);
				int val2 = hmap2.get(ch);
				
				if(val2 < val1)
					return false;
			}
		}
		return true;
	}*/
	
	public static void main(String[] args)
	{
		String s = "abc";
		String p = "aaxyc";
		System.out.println(checkOrder(s, p));
	}
}
