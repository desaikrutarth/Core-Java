package programs;

public class LargestPalindrome
{
	public void LargePalindrome(String s)
	{
		String palindrome = "";
		String largePalindrome = "";
		
		//"Odd Length Palindromes
		for(int i = 1; i < s.length(); i++)
		{
			for(int j = i-1, k = i+1; j >=0 && k < s.length(); j--,k++)
			{
				if(s.charAt(j) == s.charAt(k))
				{
					palindrome = s.substring(j,k+1);
					if(palindrome.length() > largePalindrome.length())
						largePalindrome = palindrome;
				}
			}
		}
		
		//"Even Length Palindromes
		for(int i=1; i < s.length()-1; i++)
		{
			for(int j=i,k=i+1; j>=0 && k<s.length(); j--,i++)
			{
				if(s.charAt(j) == s.charAt(k))
				{
					palindrome = s.substring(j,k+1);
					if(palindrome.length() > largePalindrome.length())
						largePalindrome = palindrome;
				}
			}
		}
		
		
		System.out.println(largePalindrome);
	}
	
	public static void main(String[] args)
	{
		LargestPalindrome p = new LargestPalindrome();
		String str = "abbabbba";
		p.LargePalindrome(str);
	}
}
