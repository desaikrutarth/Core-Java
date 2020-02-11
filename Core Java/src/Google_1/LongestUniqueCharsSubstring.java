package Google_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
 * Find longest substring with "m" unique characters in a given string. 
	input: aabacbeabbed 
	output: 
		4 (aaba) for 2 unique characters 
		6 (aabacb) for 3 unique characters
 */
public class LongestUniqueCharsSubstring 
{
	public static String longestUniqueCharsSubstring(String str, int m)
	{
		String result = "";
		
		for(int i=0; i<str.length(); i++)
		{
			HashSet<Character> set = new HashSet<>();
			set.add(str.charAt(i));
			
			for(int j=i+1; j<str.length(); j++)
			{
				if(set.size() == m)
				{
					String substring = str.substring(i,j);
					if(substring.length() > result.length())
						result = substring;
				}
				set.add(str.charAt(j));
				
				if(set.size() > m)
					break;
			}
		}
		
		return result;
	}
	
	/*public static String longestUniqueCharsSubstring(String str, int m)
	{
		String res="";
		for(int i=0; i<str.length(); i++)
		{
			HashSet<Character> set = new HashSet<>();
			for(int j=i; j<str.length(); j++)
			{
				set.add(str.charAt(j));
				if(set.size()>m)
					break;
				if(set.size()==m && j-i+1>res.length())
					res=str.substring(i, j+1);
			}
		}
		return res;
	}*/

    public static void main(String[] args) {
        System.out.println(longestUniqueCharsSubstring("aabacbeaaaaaabbbed", 2));
    }
}
