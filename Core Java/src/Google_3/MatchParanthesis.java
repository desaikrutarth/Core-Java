package Google_3;

import java.util.Stack;

/*
 * Write code to find unmatched parentheses and return it in the below format: 
((a) -> -10a1 
(a)) -> 0a1-1 
(((abc))((d))))) -> 000abc1100d111-1-1

 */
public class MatchParanthesis 
{
	static void findUnmatched(String input)
	{
		Stack<Integer> stack = new Stack<Integer>();
		char[] chArr = input.toCharArray();
		
		for(int i=0; i<chArr.length; i++)
		{
			char ch = chArr[i];
			
			if(ch == '(')
				stack.push(i);
			if (ch == ')')
			{
				if(!stack.isEmpty())
				{
					int pop = stack.pop();
					chArr[pop] = '0';
					chArr[i] = '1';
				}
			}
		}
		
		System.out.println(new String(chArr).replace("(", "-1").replace(")", "-1")); //If stack is not empty than replace character with -1
	}
//	static void findUnmatched(String input)
//	{
//		Stack<Integer> stack = new Stack<Integer>();
//		char[] chars = input.toCharArray();
//
//		for (int i = 0; i < chars.length; i++)
//		{
//			if (chars[i] == '(') {
//				stack.push(i);
//			}
//			else if (chars[i] == ')')
//			{
//				if (stack.isEmpty()) {
//					chars[i] = '^';
//				}
//				else
//				{
//					int openingIndex = stack.pop();
//					chars[openingIndex] = '0';
//					chars[i] = '1';
//				}
//			}
//		}
//
//		while (!stack.isEmpty())
//		{
//			chars[stack.pop()] = '^';
//		}
//
//		System.out.println("Summary: " + new String(chars).replace("^", "-1"));
//	}
	public static void main(String[] args)
	{
	//	String str = "((a)";
		String str = "(a))";
	//	String str = "(((abc))((d)))))";
		findUnmatched(str);
	}
}
