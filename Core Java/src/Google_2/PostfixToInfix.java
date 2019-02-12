package Google_2;

import java.util.Stack;

public class PostfixToInfix 
{
	static boolean isOperator(char c)
	{
		  if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
			  return true;
		  return false;
	}
	 
	// Get Infix for a given postfix
	// expression
	static String convertPostToIn(String str)
	{
		  Stack<String> stack = new Stack<>();
		   
		  for(int i = 0; i < str.length(); i++)
		  {
			  char c = str.charAt(i);
			  if(isOperator(c))
			  {
				  if(stack.size() > 1)
				  {
					  String b = stack.pop();
					  String a = stack.pop();
					  stack.push("("+a+c+b+")");
				  }			  
			  }
			  else
				  stack.push(""+c);
		  }
		   
		  return stack.pop();
	}

	static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }
      
    // The main method that converts given infix expression
    // to postfix expression. 
    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");
         
        // initializing empty stack
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
             
             // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
              
            // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);
             
            //  If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                 
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression                
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
      
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += stack.pop();
      
        return result;
    }

	public static void main(String[] args)
	{
	    String exp = "ab*c+";
	    String infix = convertPostToIn(exp);
	    System.out.println("Postfix to Infix: "+infix);
	    System.out.println("Infix to Postfix: "+infixToPostfix(infix));
	    
	}
}
