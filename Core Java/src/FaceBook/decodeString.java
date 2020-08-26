package FaceBook;
import java.util.Stack;
/*
 Write code to decode strings. 
 For example, String str = "3[a2[bd]g4[ef]h]",
the output should be "abdbdgefefefefhabdbdgefefefefhabdbdgefefefefh".
 */
public class decodeString
{
	public static String decode(String str)
	{
	  Stack<String> stackStr = new Stack<>();
	  Stack<Integer> stackInt = new Stack<>();
	  
	  for(char ch : str.toCharArray())
	  {
	      if(Character.isDigit(ch))
	          stackInt.push(Integer.parseInt(String.valueOf(ch)));
	      else if(ch == ']' && !stackStr.isEmpty() && !stackInt.isEmpty())
	      {
	          StringBuilder builder = new StringBuilder();
	          String pop;
	          while(!(pop = stackStr.pop()).equals("["))
	            builder.insert(0,pop);
	          
	          int num = stackInt.pop();
	          
	          StringBuffer buffer = new StringBuffer();
	          for(int i=0; i<num; i++)
	            buffer.insert(0,builder.toString());
	          
	          stackStr.push(buffer.toString());
	      }
	      else
	        stackStr.push(String.valueOf(ch));
	   }
	   
	   StringBuilder result = new StringBuilder();
	   
	   while(!stackStr.isEmpty())
	      result.insert(0, stackStr.pop());
	    
	  return result.toString();
	}
	public static void main(String[] args)
	{
		System.out.println(decode("3[a2[bd]g4[ef]h]"));
	}
}
