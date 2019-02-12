package Google_2;

/*
Find if the shorter string is a subsequence of the longer string 
Output the second index corresponding to the first one, requiring output only If there is only one match, and false if there is more than one pair 
a b c d e f g, ab -> [0,1] 
a b b c, abc -> False
*/

public class CheckSubsequence 
{
	static boolean subsequence(String input, String str)
	{
		if(input.contains(str))
		{
			for(int i=0; i<input.length(); i++)
			{
				if(input.charAt(i) == str.charAt(0))
				{
					int j = i+str.length()-1;
					String substring = input.substring(i, j+1);
					
					if(substring.equals(str))
					{
						System.out.println(i+","+j);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		String input = "abcdefg";
		String str = "efg";
		System.out.println(subsequence(input, str));
	}
}
