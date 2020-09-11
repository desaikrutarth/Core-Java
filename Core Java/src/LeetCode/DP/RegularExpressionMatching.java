package LeetCode.DP;
/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */
public class RegularExpressionMatching
{
	//Method 1: Recursion
	public static boolean isMatch(String text, String pattern)
	{
        if (pattern.isEmpty())
        	return text.isEmpty();
        
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*')
        {
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } 
        else
        {
            return first_match && 
            		isMatch(text.substring(1), pattern.substring(1));
        }
    }
	
/*	//Method 2: Dynamic Programming
	public static boolean isMatch(String text, String pattern)
	{
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--)
        {
            for (int j = pattern.length() - 1; j >= 0; j--)
            {
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*')
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                else 
                    dp[i][j] = first_match && dp[i+1][j+1];
            }
        }
        return dp[0][0];
    }
*/	
	public static void main(String[] args)
	{
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("mississippi", "mis*is*p*."));
	}
}
