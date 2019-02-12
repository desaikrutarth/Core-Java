package Google_2;

import java.util.Stack;

/*
 * Given an extremely large file that contains parenthesis, how would you say that the parenthesis are balanced? 

The file cannot fit in the memory. How would you process the file and how would you store the intermediate results. 

Examples: 
{[()]}, {[](){}}, [] are some valid examples.
 */
public class BalanceParenthesis 
{
	static boolean checkParenthesis(String str)
	{		
		Stack<Character> stack = new Stack<>();
		for(char ch : str.toCharArray())
		{
			if(ch == '{' || ch == '(' || ch == '[')
			{
				stack.push(ch);
			}		
			if(ch == '}')
			{
				if(stack.size() == 0 || stack.pop() != '{')
					return false;
			}
			if(ch == ')')
			{
				if(stack.size() == 0 || stack.pop() != '(')
					return false;
			}
			if(ch == ']')
			{
				if(stack.size() == 0 || stack.pop() != '[')
					return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args)
	{
		String str = "{[()]({})}";
		System.out.println(checkParenthesis(str));
	}
}
