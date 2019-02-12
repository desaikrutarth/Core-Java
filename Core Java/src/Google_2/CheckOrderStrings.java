package Google_2;

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
	static boolean checkOrder(String str1, String str2)
	{
		TreeMap<Character, Integer> map1 = new TreeMap<>();
		TreeMap<Character, Integer> map2 = new TreeMap<>();
		
		for(int i=0; i<str1.length(); i++)
		{
			if(map1.containsKey(str1.charAt(i)))
			{
				map1.remove(str1.charAt(i));
				map1.put(str1.charAt(i), i);
			}
			else
				map1.put(str1.charAt(i), i);
		}
		
		for(int i=0; i<str2.length(); i++)
		{
			if(map2.containsKey(str2.charAt(i)))
			{
				map2.remove(str2.charAt(i));
				map2.put(str2.charAt(i), i);
			}
			else
				map2.put(str2.charAt(i), i);
		}
		
		for(char key : map1.keySet())
		{
			if(map2.containsKey(key))
			{
				int val1 = map1.get(key);
				int val2 = map2.get(key);
				if(val2 - val1 < 0)
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String s = "abc";
		String p = "aaxyc";
		System.out.println(checkOrder(s, p));
	}
}
