package Google_1;
/*
 * Given a binary string find longest substring with all 1's
 */
public class LongestSubstringAll1s 
{
	static String SubStringOne(String str1)
	{
		int j=0;
		String maxString = "";
		
		for(int i=0; i<str1.length(); i++)
		{
			if(str1.charAt(i) == '1' && str1.charAt(j) == '1')
			{
				String substring = str1.substring(j, i+1);
				if(substring.length() > maxString.length())
					maxString = substring;
			}
			else
			{			
				String substring = str1.substring(j, i);
				if(substring.length() > maxString.length())
					maxString = substring;
				j =i;
			}
		}
		return maxString;
	}
	
	public static void main(String[] args)
	{
		System.out.println(SubStringOne("1101111"));
	}
}
