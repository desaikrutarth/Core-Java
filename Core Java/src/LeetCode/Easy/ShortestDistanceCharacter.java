package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:
Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class ShortestDistanceCharacter
{
	public static  int[] shortestToChar(String str, char C)
	{
	    Set<Integer> indexes = new HashSet<>();
	    
	    for(int i=0; i<str.length(); i++)
	    {
	        if(str.charAt(i) == C)
	          indexes.add(i);
	    }
	    
	    int[] result = new int[str.length()];
	    
	    for(int i=0; i<str.length(); i++)
	    {
	        int min = Integer.MAX_VALUE;
	        for(int index : indexes)
	        {
	            min = Math.min(min, Math.abs(i - index));
	        }
	        result[i] = min;
	    }
	    return result;
	}
	
/*	public static int[] shortestToChar(String str, char C)
	{
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == C)
                map.computeIfAbsent(C, x -> new ArrayList<Integer>()).add(i);	//if key already exists, value will be added to the same list of that key, else create a new list for new key
        }
        
        int result[] = new int[str.length()];
        for(int i = 0; i < str.length(); i++)
        {
            int min = Integer.MAX_VALUE;
            for(Integer a : map.get(C))
                min = Math.min(min, Math.abs(a - i));
            result[i] = min;
        }
        return result;
    }
*/	
	public static void main(String[] args) 
	{
		String str = "loveleetcode";
		char C = 'e';
		System.out.println(Arrays.toString(shortestToChar(str,C)));
	}
}
