package LeetCode.Easy;
/*
 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome
{
	//O(n)
	public static boolean validPalindrome(String s)
	{
		int l = -1, r = s.length();
	    while(++l <= --r)
	    {
	         if (s.charAt(l) != s.charAt(r)) 
	         {
	             return isPalindrome(s, l + 1, r)
	                 || isPalindrome(s, l, r - 1);
	         }
	    }
	    return true;
	}
	    
	static boolean isPalindrome(String s, int from, int to)
	{
		while(from++ <= to--) 
	    {
	        if (s.charAt(from) != s.charAt(to)) 
	           	return false;
	    }
	    return true;
	}
	
	//O(n)^2
/*	public static boolean validPalindrome(String str)
    {
		if(isPalindrome(str))
			return true;
		
		for(int i=0; i<str.length(); i++)
		{
			StringBuilder copy = new StringBuilder(str);
			copy.deleteCharAt(i);
			if(isPalindrome(copy.toString()))
				return true;
		}
		return false;
    }
	
	private static boolean isPalindrome(String str)
	{
		return new StringBuilder(str).reverse().toString().equals(str);
	}
*/
	public static void main(String[] args) 
	{
		System.out.println(validPalindrome("abbca"));
	}
}
