package LeetCode.DP;

import java.util.Stack;
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

Input: "()(())"
Output: 6
Explanation: The longest valid parentheses substring is "()(())"
 */
public class LongestValidParentheses
{
	 public static int longestValidParentheses(String s)
	 {
	      int maxlen = 0;
	      for (int i = 0; i < s.length(); i++) 
	      {
	          for (int j = i + 2; j <= s.length(); j=j+2) 
	          {
	              if (isValid(s.substring(i, j)))
	                  maxlen = Math.max(maxlen, j - i);
	          }
	      }
	      return maxlen;
	 }
	
	 public static boolean isValid(String s) 
	 {
		 Stack<Character> stack = new Stack<Character>();
	     for (int i = 0; i < s.length(); i++)
	     {
	         if (s.charAt(i) == '(')
	             stack.push('(');
	         else if (!stack.empty() && stack.peek() == '(')
	             stack.pop();
	         else
	             return false;
	     }
         return stack.empty();
     }
	 
	public static void main(String[] args)
	{
		System.out.println(longestValidParentheses("()(())"));
	}
}
