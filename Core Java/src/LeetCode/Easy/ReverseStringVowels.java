package LeetCode.Easy;

import java.util.Stack;

/*
 Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"

Example 2:

Input: "leetcode"
Output: "leotcede"
 */
public class ReverseStringVowels 
{
	static String reverseVowels(String str)
	{
		int left = 0;
        int right = str.length() - 1;
        char[] charArray = str.toCharArray();
        
        while (left < right) 
        {
            if (isVowel(charArray[left]) && isVowel(charArray[right])) 
            {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
            else if (!isVowel(charArray[left]) && isVowel(charArray[right])) {
                left++;
            }
            else if (isVowel(charArray[left]) && !isVowel(charArray[right])) {
                right--;
            }
            else 
            {
                left++;
                right--;
            }
        }
        
        return new String(charArray);
		
	}
	
	private static boolean isVowel(char c) 
	{
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
               || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
	
	/*static String reverseVowels(String str)
	{
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		
		for(char ch : str.toCharArray())
		{
			if(isVowel(ch))
				stack.push(ch);
		}
		
		for(char ch : str.toCharArray())
		{
			if(isVowel(ch))
				result.append(stack.pop());
			else
				result.append(ch);
		}
		return result.toString();
	}*/
	
	
	public static void main(String[] args) 
	{
		System.out.println(reverseVowels("leetcode"));
	}
}
