package Google_1;

import java.util.Arrays;
/*
 Given an array of strings, find out in how many cases is any of the anagrams of the string at location i,
 is a substring of the string at location i+1.

Test Case I: ["ab", "ab", "abc", "bca"] 
Answer: 3 

Test Case II: ["ab","aqb"] 
Answer: 0
 */
public class FindCasesAnagrams
{
	public static int findAnagrams(String[] s)
	{
		int[] c = new int[26];
		String prev;
		String next;
		int result=0;
		
		for(int i=0; i<s.length-1; i++)
		{
			Arrays.fill(c, 0);
			prev = s[i];
			next = s[i+1];
			int j=0;
			if(prev.length() > next.length())
				continue;
			while(j < next.length())
			{
				if(j<prev.length())
					c[prev.charAt(j) - 'a']++;
					
				if(j<prev.length())
				{
					c[next.charAt(j) - 'a']--;
				}
				else
				{
					c[next.charAt(j-prev.length()) - 'a']++;
					c[next.charAt(j) - 'a']--;
				}
				
				if(j >= prev.length()-1)
					if(isAnagram(c))
						result++;
				j++;
			}
		}
		return result;
	}
	private static boolean isAnagram(int[] c)
	{
		int n=c.length;
		for(int i=0; i<n; i++)
			if(c[i] != 0)
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		String[] s = {"ab", "ab", "abc", "bca"};
		System.out.println(findAnagrams(s));
	}
}
