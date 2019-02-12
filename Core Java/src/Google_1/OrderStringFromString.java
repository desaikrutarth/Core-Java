package Google_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
Given two lowercase strings, S1 and S2, sort S1 in same order as S2. 
If a character in S1 doesn't exist in S2, put them at the end.
If S1 is "program" and S2 is "grapo", then return "grrapom".
 */

public class OrderStringFromString 
{
	
	static String orderString(String str1, String str2)
	{
		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(char c : str1.toCharArray())
			hmap.merge(c, 1, Integer::sum);
		
		StringBuilder overlap = new StringBuilder();

		for(int i = 0; i<str2.length(); i++)
		{
			char c = str2.charAt(i);
			if(hmap.containsKey(c))
			{
				int val = hmap.get(c);
				while(val != 0)
				{
					overlap.append(c);
					val--;
				}
					
				hmap.remove(c);
			}
					
		}
		
		for(Entry<Character, Integer> e : hmap.entrySet())
		{
			for(int j=0;j<e.getValue();j++)
				overlap.append(e.getKey());
		}
        return overlap.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(orderString("program","grapo"));
	}
}
