package Google_1;

import java.util.HashMap;

/*
Given two string s and t and a positive integer K, determine whether we can swap any two characters in string s at most K times so that s is equal to t.

Example 1

s = "converse"
t = "conserve"
K = 1
Output: true
because we can swap v and s in string s and we swap only once which is not greater than K times.

 */
public class SwapCharacterKTimes
{
	public static boolean swapCharacter(String str1, String str2, int k)
	{
		if(str1.length() != str2.length())
			return false;
		
		HashMap<Character, Character> map = new HashMap<>();
		int swapCount = 0;
		
		for(int i=0; i<str1.length(); i++)
		{
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			
			if(ch1 != ch2)
			{
				if(map.containsKey(ch2))
				{
					if(map.get(ch2) == ch1)
					{
						swapCount++;
						map.remove(ch1);
					}
				}
				else
					map.put(ch1, ch2);
			}
		}
		return (k == swapCount);
	}
//	public static boolean swapCharacter(String str1, String str2, int k)
//	{
//		if(str1.length() != str2.length())
//			return false;
//		
//		char c1 = ' '; 
//		char c2 = ' ';
//		int swapCount = 0;
//		boolean isSwap = true;
//		
//		for(int i=0; i<str1.length(); i++)
//		{
//			char ch1 = str1.charAt(i);
//			char ch2 = str2.charAt(i);
//			
//			if(ch1 != ch2)
//			{
//				if(ch1 == c2 && ch2 == c1)
//				{
//					if(isSwap)
//					{
//						swapCount++;
//						isSwap = false;
//					}
//						
//				}
//				else
//				{
//					c1 = ch1;
//					c2 = ch2;
//					isSwap = true;
//				}
//			}
//		}
//		return (swapCount == k);
//	}
//	public static boolean swapCharacter(String str1, String str2, int k)
//	{	
//		char a = ' ', b = ' ';	
//		boolean swapUsed = false;	
//		int count = 0;
//		
//		for (int i = 0; i < str1.length(); i++) 
//		{
//			char ch1 = str1.charAt(i);
//			char ch2 = str2.charAt(i);
//			if(ch1 != ch2)
//			{
//				if(a == ch2 && b == ch1 && swapUsed)
//				{
//					count++;
//					swapUsed = false;
//				}
//				else
//				{
//					a = ch1;
//					b = ch2;
//					swapUsed = true;
//				}
//			}
//			
//		}
//		
//		return (count == k);
//	}
	
	public static void main(String[] args)
	{
		String s = "converse";
		String t = "conserve";
		int k = 1;
		System.out.println(swapCharacter(s, t, k));
	}
}
