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
		HashSet<Character> set = new HashSet<>();
		int j=0;
		String substring="";
		String result="";
		
		for(int i=0; i<str.length(); i++)
		{
			set.add(str.charAt(i));
			if(set.size() > m)
			{
				j++;
				i=j-1;
				set.clear();
			}
			else if(set.size() == m)
			{
				substring = str.substring(j,i+1);
				if(substring.length() > result.length())
					result = substring;
			}
			
		}
		return result;
	}
	
	//Method 2:
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
	
	//Method 3:
	/*	public static int longestUniqueCharsSubstring(String str, int m)
	{
		int max=0;
	    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    int start=0;
	 
	    for(int i=0; i<str.length(); i++)
	    {
	        char c = str.charAt(i);
	        map.merge(c, 1, Integer::sum);
	 
	        if(map.size() > m)
	        {
	            max = Math.max(max, i-start);
	 
	            while(map.size() > m)
	            {
	                char ch = str.charAt(start);
	                int count = map.get(ch);
	                
	                if(count>1)
	                    map.put(ch, count--);
	                else
	                	map.remove(ch);
	                
	                start++;
	            }
	        }
	    }
	 
	    max = Math.max(max, str.length()-start);
		return max;
    }*/

    public static void main(String[] args) {
        System.out.println(longestUniqueCharsSubstring("aabacbeaaaaaabbbed", 2));
    }
}
