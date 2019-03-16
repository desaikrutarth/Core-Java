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
    public static boolean validPalindrome(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++)
        {
            char ch = sb.charAt(i);
            sb.deleteCharAt(i);
            if (isPalindrome(sb.toString()))
            	return true;
            sb.insert(i, ch);
        }
        return isPalindrome(str);
    }
    
    public static boolean isPalindrome(String str)
	{		
		return str.equals(new StringBuilder(str).reverse().toString());
    }
    
	public static void main(String[] args) 
	{
		System.out.println(validPalindrome("abbca"));
	}
}
