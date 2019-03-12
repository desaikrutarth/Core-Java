package LeetCode.Easy;
/*
 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstring 
{
	public static boolean repeatedSubstringPattern(String str) 
	{
		String copy = str + str;
		String substring = copy.substring(1,2*str.length()-1);
		if(substring.contains(str))
			return true;
		return false;
    }
	
/*	Method 2:
    public static boolean repeatedSubstringPattern(String str) 
	{
		String copy = str + str;
		int index = copy.indexOf(str, 1);
		if(copy.indexOf(str,1) < str.length())
			return true;
		return false;
    }*/
	
	public static void main(String[] args) 
	{
		System.out.println(repeatedSubstringPattern("aba"));
	}
}
