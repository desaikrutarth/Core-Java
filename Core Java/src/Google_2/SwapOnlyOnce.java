package Google_2;
/*
 * Given Two string, ask whether they can become the same after just one swap of two chars in one string. 
For example: 
"abcd", "bacd" Yes, you can swap ab in the first string to make it the same as the second string 
"abcd", "adbc" can not 

Follow-up, given Two string, ask whether they can become the same after N swaps of two chars in one string g, assuming that the swap does not overlap. 
(str [0] <-> str [2] str [2] and str [0] will not be swapped with other locations)
 */
public class SwapOnlyOnce 
{
	static boolean isEqual(String str1, String str2)
	{
		char c1 = ' ';
		char c2 = ' ';
		int count = 0;
		boolean flag = false;
		for(int i=0; i<str1.length(); i++)
		{
			if(str1.charAt(i) != str2.charAt(i))
			{
				
				if(c1 == str2.charAt(i) && c2 == str1.charAt(i))
				{
					if(flag == true)
					{
						count++;
						flag = false;
					}
				}
				else
				{
					c1 = str1.charAt(i);
					c2 = str2.charAt(i);
					flag = true;
				}
				
			}
		}
		if(count == 1)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isEqual("abcd", "bacd"));
	}
}
