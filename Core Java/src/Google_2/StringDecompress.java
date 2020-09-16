package Google_2;

import java.util.Iterator;
import java.util.Stack;
/*
 * Decompress string - string (s) followed by {n} denotes s repeating n times 
"a(b(c){2}){2}d" decompresses to "abccbccd" 
"((x){3}(y){2}z){2}" decompresses to "xxxyyzxxxyyz"
 */
public class StringDecompress 
{
	static String decompress(String str) 
	{
	    Stack<String> stack = new Stack<>();
	    for(int i=0; i<str.length(); i++)
	    {
	        char ch = str.charAt(i);
	        
	        if(ch == ')' && !stack.isEmpty())
	        {  
	            StringBuilder sb = new StringBuilder();
	            String pop;
	            while(!(pop=stack.pop()).equals("("))
	            {
	                sb.insert(0,pop);  
	            }
	            stack.push(sb.toString());
	        }
	        else if(ch == '{' && !stack.isEmpty())
	        {
	            int pos = str.indexOf('}',i);
	            int num = Integer.parseInt(str.substring(i+1,pos));
	            StringBuilder sb = new StringBuilder();
	            String pop = stack.pop();
	            for(int j=0; j<num; j++)
	            {
	                sb.append(pop);
	            }
	            stack.push(sb.toString());
	            i = pos;
	        }
	        else
	          stack.push(String.valueOf(ch));
	    }
	  
	    StringBuilder result = new StringBuilder();
	    
	    while(!stack.isEmpty())
	      result.insert(0,stack.pop());
	   
	    return result.toString();
	}
	
/*	static String decompress(String string) 
	{
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) 
        {
            char c = string.charAt(i);
            if (c != ')' && c != '}') 
                stack.push(String.valueOf(c));
            else if (c == ')') 
            {
                StringBuilder tmp = new StringBuilder();
                String poped;
                while (!(poped = stack.pop()).equals("("))
                {
                    tmp.insert(0, poped);
                }
                stack.push(tmp.toString());
            } 
            else
            {
                StringBuilder tmp = new StringBuilder();
                String poped;
                while (!(poped = stack.pop()).equals("{")) 
                {
                    tmp.insert(0, poped);
                }
                int copies = Integer.valueOf(tmp.toString());
                String str = stack.pop();
                tmp = new StringBuilder();
                for (int j = 1; j <= copies; j++) 
                {
                    tmp.append(str);
                }
                stack.push(tmp.toString());
            }
        }
        
        for(String item : stack)
        {
        	result.append(item);
        }
        
        return result.toString();
    }
*/	
	public static void main(String[] args)
	{
		String str = "a(b(c){2}){2}d";
//		String str = "((x){3}(y){2}z){2}";
		System.out.println(decompress(str));
	}
}
