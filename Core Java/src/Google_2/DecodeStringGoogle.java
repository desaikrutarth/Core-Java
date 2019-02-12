package Google_2;

import java.util.HashMap;
import java.util.HashSet;
/*
 * Given an integer, figure out the total number of ways to decode it.
 * You are given a dictionary that maps a string with a unique integer n where 0 <= n < 1000.	
	For example,
	‘A’ -> 1
	‘AB’ -> 2
	 .....
	‘ZEX’ -> 221
	
	e.g.
	Input: 221
	Output: 2 (since 221 can be decoded as ‘ZEX’ or ‘ABABA’)
 */
public class DecodeStringGoogle 
{
	static void decode(int input)
	{
		String strInput = String.valueOf(input);
		char[] charArray = strInput.toCharArray();
		HashSet<String> set = new HashSet<>();
		
		int i = 0;
		int j =0 ;
		while(i < charArray.length && j < charArray.length)
		{
			String s = String.valueOf(charArray[j]);
			set.add(s);
			
			if(j == charArray.length-1)
			{
				i++;
				j=0;
				
			}
			else
				j++;
		}
		System.out.println(set);
		HashMap<String, String> hmap = new HashMap<>();
		hmap.put("1","A");
		hmap.put("2","AB");
		hmap.put("221","ZEX");
		
		String newString1 = "";
		String newString2 = "";
		String keyString = "";
		int numberOfWay = 0;
	/*	for(int i=0; i<str.length(); i++)
		{	
			
			if(hmap.containsKey(str.substring(i, i+1)))
			{
				String subString = str.substring(i, i+1);
				String val = hmap.get(subString);
				newString1 += val;
			}
			
			keyString += str.charAt(i);
			if(hmap.containsKey(keyString))
			{
				String val = hmap.get(keyString);
				newString2 += val;
			}
		}*/
		
		System.out.println(newString1);
		System.out.println(newString2);
	}
	
	public static void main(String[] args)
	{
		decode(221);
	}
}
