package Google_2;
import java.util.Stack;

/*
 * Build HTML Reverser 
Given 
<A>(hello)(<P>ab</P>)(<S>hi</S>)</A> 
Return 
<A>(<S>ih</S>)(<P>ba</P>)(olleh)</A>
 */
public class HTMLReversal 
{
	public static String reverseHtml(String str)
	{
	    Stack<String> stack = new Stack<>();
	    boolean isPara = false;
	    
	    for(int i=0; i<str.length(); i++)
	    {
	        char ch = str.charAt(i);
	        
	        if(ch == '<')
	        {
	            int pos = str.indexOf('>',i);
	            String tag = str.substring(i, pos+1);
	            if(tag.contains("/"))
	                tag = tag.replace("/","");
	            else
	                tag = tag.replace("<","</");
	           
	            stack.push(tag);
	            i = pos;
	            isPara = false;
	        }
	        else if(ch == '(')
	        {
	            isPara = true;
	            stack.push(")");
	        }
	        else if(ch == ')')
	        {
	            stack.push("(");
	        }
	        else
	        {
	            int pos;
	            if(isPara)
	              pos = str.indexOf(')',i);
	            else
	              pos = str.indexOf('<',i);
	            
	            String word = str.substring(i, pos);
	            stack.push(new StringBuilder(word).reverse().toString());
	            i = pos-1;
	        }
	    }
	    
	    StringBuilder result = new StringBuilder();
	    while(!stack.isEmpty())
	      result.append(stack.pop());
	    
	    return result.toString();
	}
	
/*	public static String reverseHtml(String str)
	{	
		Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); )
        {
            String token = getNextToken(str, i);
            String reverse = null;
            if (isTokenAnHtmlTag(token)) {
                reverse = reverseHtmlTag(token);
            } 
            else if (token.equals("(") || token.equals(")"))
            {
                if (token.equals("(")) 
                    reverse = ")";
                else 
                    reverse = "(";             
            }
            else 
                reverse = new StringBuilder(token).reverse().toString();
            
            stack.push(reverse);
            System.out.println("Pushing on stack: " + reverse);
            i += token.length();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty())
        {
            sb.append(stack.pop());
        }

        return sb.toString();
     }
	
	private static String getNextToken(String s, int index)
	{
        String token;
        if (s.charAt(index) == '<') 
        {
            int pos = s.indexOf('>', index);
            token = s.substring(index, (pos + 1));
        } 
        else if (s.charAt(index) == '(' || s.charAt(index) == ')') {
            token = s.substring(index, index + 1);
        }
        else 
        {
            int pos = index;
            char ch = s.charAt(pos);
            while (ch != '<' && ch != '>' && ch != '(' && ch != ')')
            {
                ch = s.charAt(pos);
                pos++;
            }
            token = s.substring(index, pos - 1);
        }

        //System.out.println("Returning token: " + token);
        return token;
    }
	
	private static String reverseHtmlTag(String tag)
	{
        if (tag.startsWith("</")) 
            return tag.replace("</", "<");
        else 
            return tag.replace("<", "</");
    }
	
	private static boolean isTokenAnHtmlTag(String token) 
	{
        if (token.startsWith("<")) return true;
        return false;
    }
*/	
	public static void main(String[] args)
	{
		String str = "<A>(hello)(<P>ab</P>)(<S>hi</S>)</A>";
		System.out.println(reverseHtml(str));
	}
}
