package Google_1;
/*
 * Given a binary string find longest substring with all 1's
 */
public class LongestSubstringAll1s 
{
	static String SubStringOne(String str)
	{
		int j=0;
		String maxString = "";
		String substring = "";
		
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == '1' && str.charAt(j) == '1')
			{
				substring = str.substring(j, i+1);
			}
			else
			{			
				j = i+1;
			}
			if(substring.length() > maxString.length())
				maxString = substring;
		}
		return maxString;
	}
	
	public static void main(String[] args)
	{
		System.out.println(SubStringOne("011110000011010"));
	}
}
