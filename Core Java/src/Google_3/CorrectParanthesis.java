package Google_3;

import java.util.Stack;

/*
 	Balance Parenthesis:
 	input : )ab(()) --> ab(())
 		  : (((((   --> ""
 */
public class CorrectParanthesis
{
	static String balanceParanthesis(String str)
	{
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackPos = new Stack<>();

        StringBuilder output = new StringBuilder("");
        for ( int i = 0 ; i < str.length() ; i++)
        {
            char ch = str.charAt(i);
            
            if(ch == '(')
            {
            	stack.push('(');
                stackPos.push(output.length());
            }
            else if(ch == ')')
            {
            	 if ( stack.size() != 0)
            	 {
                     char c = stack.pop();
                     int pos = stackPos.pop();
                     output.insert(pos , c);
                     output.append(ch);
            	 }
            }
            else
            	output.append(ch);
        }
        return output.toString();
	}
/*	Method 2:	
	static void run(String str)
	{
		char[] a = str.toCharArray();
		int n = a.length;
		
		boolean[] valid = new boolean[n];
		Stack<Integer> sp = new Stack<Integer>();
		
		for(int i = 0; i < n; i++)
		{
			if(a[i] == '(')
				sp.push(i);
			else if(a[i] == ')')
			{
				if(!sp.isEmpty() && a[sp.peek()] == '(')
				{
					valid[i] = true;
					valid[sp.pop()] = true;
				}
			}
			else
				valid[i] = true;
		}
		
		for(int i = 0; i < n; i++)
			if(valid[i])
				System.out.print(a[i]);
		System.out.println();
	}
*/	
	public static void main(String[] args)
	{
	//	String s = ")ab(())";
		String s = "(()())";
	//  String s = "(((((";
		System.out.print(balanceParanthesis(s));
	}
}
