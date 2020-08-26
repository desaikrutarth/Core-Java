package FaceBook;

import java.util.HashSet;
import java.util.Set;
/*
Given an input string "aabbccba", find the shortest substring from the alphabet "abc".

In the above example, there are these substrings "aabbc", "aabbcc", "ccba" and "cba".
However the shortest substring that contains all the characters in the alphabet is "cba", so "cba" must be the output.

Output doesnt need to maintain the ordering as in the alphabet.

Other examples:
input = "abbcac", alphabet="abc" Output : shortest substring = "bca".
 */
public class FindShortestSubstring 
{
	public static String shortestSubstring(String input, String alphabet)
	{
	    int k = alphabet.length();
	    Set<Character> set;
	    String result = "";
	    int minLength = Integer.MAX_VALUE;
	    
	    for(int i=0; i<input.length(); i++)
	    {
	        set = new HashSet<>();
	        set.add(input.charAt(i));
	        for(int j=i+1; j<input.length(); j++)
	        {
	        	set.add(input.charAt(j));
	            if(set.size() == k)
	            {
	                String substring = input.substring(i,j+1);
	                if(substring.length() < minLength)
	                {
	                    result = substring;
	                    minLength = substring.length();
	                }
	                break;
	            }
	           
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(shortestSubstring("abbcac", "abc"));
	//	System.out.println(shortestSubstring("aabbccba", "abc"));
	}
}
