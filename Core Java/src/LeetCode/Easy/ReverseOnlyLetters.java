package LeetCode.Easy;

import java.util.Stack;
/*
 Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

Example 1:
Input: "ab-cd"
Output: "dc-ba"

Example 2:
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters
{
	public static String reverseOnlyLetters(String str) 
	{
		Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray())
            if (Character.isLetter(c))
                stack.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: str.toCharArray())
        {
            if (Character.isLetter(c))
                ans.append(stack.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }
	
	public static void main(String[] args)
	{
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
	}
}
