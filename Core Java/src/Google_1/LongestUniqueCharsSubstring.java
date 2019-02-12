package Google_1;

import java.util.HashMap;
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
	public static int longestUniqueCharsSubstring(String str, int m)
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
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueCharsSubstring("aabacbeabbed", 2));
    }
}
