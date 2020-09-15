package Google_1;
/*
 * Given a binary string find longest substring with all 1's
 */
public class LongestSubstringAll1s 
{
	static String SubStringOne(String str)
	{
		int start=0;
		String maxString = "";
		String substring = "";
		
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == '1' && str.charAt(start) == '1')
				substring = str.substring(start, i+1);
			else
				start = i+1;
			
			if(substring.length() > maxString.length())
				maxString = substring;
		}
		return maxString;
	}
	
	public static void main(String[] args)
	{
		System.out.println(SubStringOne("01111110111100000110101"));
	}
}
