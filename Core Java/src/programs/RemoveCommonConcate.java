package programs;

import java.util.LinkedHashMap;

/*
 * Two strings are given. Modify 1st string such that all the common characters of the 2nd strings have to be removed 
 * and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.
 */
class Implement
{
	public void removeCommon(String str1, String str2)
	{
		LinkedHashMap<Character, Integer> hmap = new LinkedHashMap<Character,Integer>();
		
		for(int i=0; i < str1.length(); i++)
		{
			hmap.merge(str1.charAt(i), 1, Integer::sum);
		}	
		
		for(int j=0; j < str2.length();j++)
		{
			
			hmap.merge(str2.charAt(j), 1, Integer::sum);
		}		
		
		String newString = "";		
		for(char ch : hmap.keySet())
		{
			int val = hmap.get(ch);
			if(val == 1)
				newString += ch;
		}
		
		System.out.println(newString);
		
	}
}

public class RemoveCommonConcate 
{
	public static void main(String[] args)
	{
		Implement imp = new Implement();
		String str1 = "aacdb";
		String str2 = "gafd";
		imp.removeCommon(str1, str2);
	}
}
