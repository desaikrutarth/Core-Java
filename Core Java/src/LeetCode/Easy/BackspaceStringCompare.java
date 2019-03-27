package LeetCode.Easy;

import java.util.Stack;
/*
 Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b"
 */
public class BackspaceStringCompare
{
	public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S)
    {
        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray())
        {
            if (c != '#')
                stack.push(c);
            else if (!stack.empty())
                stack.pop();
        }
        return String.valueOf(stack);
    }

	public static void main(String[] args) 
	{
		System.out.println(backspaceCompare("a##c","#a#c"));
	}
}
