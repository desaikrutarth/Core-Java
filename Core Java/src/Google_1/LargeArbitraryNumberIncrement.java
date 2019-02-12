package Google_1;

import java.util.ArrayList;
import java.util.ListIterator;

/*
 * Write a class to take in a large arbitrary number, also provide a function to increment the number.
 * The number will be passed on as an array of integers.
 */

public class LargeArbitraryNumberIncrement
{	 
	static String bigNumberIncrement(String str)
	{
		String s = "1";
		StringBuilder prefix = new StringBuilder();
		
		for(int i=0; i<str.length()-1; i++)
			prefix.append("0");
		
		s = prefix + s;
		int buf = 0;
		
		StringBuffer result = new StringBuffer();
		for(int i=str.length()-1; i >=0; i--)
		{
			int n1 = Integer.parseInt(String.valueOf(str.charAt(i)));
			int n2 = Integer.parseInt(String.valueOf(s.charAt(i)));
			
			int sum = buf + n1 + n2;
			buf = 0;
			
			if(sum >= 10)
			{
				sum = sum % 10;
				buf++;
			}
			else
				buf = 0;
			
			result.insert(0, sum);
			
		}
		if(buf != 0)
			result.insert(0,buf);
		return result.toString();
	}

	 public static void main(String args[]) 
	 {
		 String str = "1999999999999999999999999999999999999";
		 System.out.println(bigNumberIncrement(str));
	        
	 }

}
