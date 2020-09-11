package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses
{
	static List<String> ans = new ArrayList<>();
	public static List<String> generateParenthesis(int n) 
	{
        backtrack("", 0, 0, n);
        return ans;
    }

    public static void backtrack(String cur, int open, int close, int max)
    {
        if (cur.length() == max * 2) 
        {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(cur+"(", open+1, close, max);
        if (close < open)
            backtrack(cur+")", open, close+1, max);
    }
    
    public static void main(String[] args)
    {
    	System.out.println(generateParenthesis(3));
	}
}
