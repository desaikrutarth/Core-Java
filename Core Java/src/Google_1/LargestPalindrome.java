package Google_1;

public class LargestPalindrome
{
	public void LargePalindrome(String s)
	{
		String largestPalindrome="";
			
		// Odd Length Palindromes
		for (int i=1; i<s.length()-1; i++) 
		{
			for (int j=i-1,k=i+1; j>=0 && k<s.length(); j--,k++)
			{
				if (s.charAt(j) == s.charAt(k)) 
				{
					String palindrome = s.substring(j, k+1);
					if(palindrome.length() > largestPalindrome.length())
						largestPalindrome = palindrome;
				}
				else
					break;
			}
		}

		// Even Length Palindromes
		for (int i=1; i<s.length()-1; i++) 
		{
			for (int j=i,k=i+1; j>=0 && k<s.length(); j--,k++)
			{
				if (s.charAt(j) == s.charAt(k)) 
				{
					String palindrome = s.substring(j, k+1);
					if(palindrome.length() > largestPalindrome.length())
						largestPalindrome = palindrome;
				}
				else
					break;
			}
		}
		System.out.println(largestPalindrome);
	}
	
	public static void main(String[] args)
	{
		LargestPalindrome p = new LargestPalindrome();
		String str = "abbabbba";
		p.LargePalindrome(str);
	}
}
