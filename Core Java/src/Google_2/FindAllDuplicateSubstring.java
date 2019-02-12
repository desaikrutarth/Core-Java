package Google_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Give a string, finds all duplicate substrings of length k
 */
public class FindAllDuplicateSubstring 
{
	static void findDuplicateSubstring(String str, int k)
	{
		HashMap<String, Integer> hmap = new HashMap<>();
		
		for(int i=0; i<str.length()-k+1; i++)
		{
			int j = i+k;
			String substring = str.substring(i, j);
			hmap.merge(substring, 1, Integer::sum);
		}
		
		for(String key : hmap.keySet())
		{
			if(hmap.get(key) > 1)
				System.out.println(key);
		}
	}
	
/*	Method 2
 * static void findDuplicateSubstring(String str, int k)
	{
		List<String> list = new ArrayList<>();
		int j=k;
		for(int i=0; i<str.length()-k+1; i++)
		{
			String substring = str.substring(i, j);
			if(list.contains(substring))
				System.out.println(substring);
			list.add(substring);
			j++;
		}
	}*/
	
	public static void main(String[] args)
	{
		String str= "abcdeabcd";
		int k = 3;
		findDuplicateSubstring(str, k);
	}
}
