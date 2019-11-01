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
		StringBuffer result = new StringBuffer();
		int carry = 0;
		
		for(int i=str.length()-1; i >=0; i--)
		{
			int n1 = Integer.parseInt(String.valueOf(str.charAt(i)));
			int n2;
			
			if(i==str.length()-1)
				n2 = 1;
			else
				n2 = 0;
			
			int sum = carry + n1 + n2;
			carry = 0;
			
			if(sum >= 10)
			{
				sum = sum % 10;
				carry++;
			}
			else
				carry = 0;
			
			result.insert(0, sum);
		}
		if(carry != 0)
			result.insert(0,carry);
		return result.toString();
	}
	
	/*public String bigNumberIncrement(String str)
	  {
		StringBuffer sb=new StringBuffer();
		int carry=1;
		for(int i=str.length()-1; i>=0; i--)
		{
			int sum=carry+(str.charAt(i)-'0');
			sb.append(sum%10);
			carry=sum/10;
		}
		if(carry>0)
			sb.append(carry);
		return sb.reverse().toString();
	}*/

	 public static void main(String args[]) 
	 {
		 String str = "199999999999999999999999999999999999999999999999999";
		 System.out.println(bigNumberIncrement(str));
	 }

}
