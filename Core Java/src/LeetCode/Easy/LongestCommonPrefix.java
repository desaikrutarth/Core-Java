package LeetCode.Easy;
/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix
{
	private static String  longestCommonPrefix(String[] arr)
	{	
	    if (arr.length == 1)
	    	return arr[0];
	    
	    String prefix = arr[0]; // first word 
	    
	    for (int i = 1; i < arr.length; i++)
	    {
		  // trim prefix until the second word begins with the prefix
	        while(!arr[i].startsWith(prefix))
	            	prefix = prefix.substring(0, prefix.length() - 1);
		
	    }
	    return prefix;
	}
	
	public static void main(String[] args)
	{
		String[] arr = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(arr));
	}
	
}
