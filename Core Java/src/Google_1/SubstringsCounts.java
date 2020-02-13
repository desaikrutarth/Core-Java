package Google_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
/*
 * Given a set of strings (denoting URLs), like: 

1. abc.pqr.google.com 
2. pqr.google.com 
3. pqr.google.net 
4. yahoo.com 
5. abc.yahoo.com 
etc... 

find an efficient way to find out how many times a particular string appears as a substring.
For e.g., given the above set of strings, "google.com" appears twice; ".com" appears four times, "pqr.google.com" appears twice, and so on. 

Follow up: How would you do this, if the input was no longer a URL (So, "abc.pqr.google.com" and "pqr.abc.google.com", both are valid)?
 */

public class SubstringsCounts 
{
	static void findAllSubstrings(String[] arr)
	{
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String str : arr)
		{
			StringBuilder substring = new StringBuilder();
			for(int i=str.length()-1; i>=0; i--)
			{
				char ch = str.charAt(i);
				substring.insert(0, ch);
				
				if(ch == '.' || i == 0)
				{
					map.merge(substring.toString(), 1, Integer::sum);
				}
			}
		}
		
		for(Entry<String, Integer> entry : map.entrySet())
			System.out.println(entry.getKey()+" = "+entry.getValue());
	}

	public static void main(String[] args) 
	{
		String[] arr = {"abc.pqr.google.com","pqr.google.com","pqr.google.net","yahoo.com","abc.yahoo.com"};
		findAllSubstrings(arr);
	}
}
