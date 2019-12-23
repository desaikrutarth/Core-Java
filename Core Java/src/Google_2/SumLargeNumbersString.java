package Google_2;
/*
 *Write a function that takes two numbers as strings and returns the sum as a result as a string: 
Assume the numbers might be too large to be parsed into a variable of any numeric type the language has.
 */
public class SumLargeNumbersString 
{
	
	static String bigSum(String str1, String str2)
	{
		int diff = Math.abs(str1.length()-str2.length());
		
		String zeros = "";
		for(int i=0; i<diff; i++)
			zeros += "0";
		
		if(str1.length() < str2.length())
			str1 = zeros + str1;
		else
			str2 = zeros + str2;
		
		int carry=0;
		StringBuffer result = new StringBuffer();
		
		for(int i=str1.length()-1; i>=0; i--)
		{
			int n1 = Integer.parseInt(String.valueOf(str1.charAt(i)));
			int n2 = Integer.parseInt(String.valueOf(str2.charAt(i)));
			
			int sum = n1 + n2 + carry;
			carry=0;
			
			if(sum >= 10)
			{
				sum = sum % 10;
				carry++;
			}
			else
				carry=0;
			result.insert(0, sum);
		}
		if(carry>0)
			result.insert(0, carry);
		
		return result.toString();
	}
	
	public static void main(String[] args)
	{
		String input = "9888";
		String str = "555555";
		System.out.println(bigSum(input, str));
	}
}
