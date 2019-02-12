package Google_2;

import java.util.TreeSet;
/*
 * Give a string that outputs the largest alphabetical order of all consecutive substrings 
 * For example,
 * 			 "ab", substring has {"a", "ab", "b"}, output "b"
 */
public class findAllSubstrings 
{
	static String getSubstring(String str)
	{
		TreeSet<String> tset = new TreeSet<>();
		for (int i = 0; i < str.length(); i++)
		{
	        for (int j = i+1; j <= str.length(); j++) 
	        {
	            String sub = str.substring(i,j);
	            tset.add(sub);
	        }
	    }
		return tset.last();
	}
	
	public static void main(String[] args)
	{
		System.out.println(getSubstring("ab"));
	}
}
