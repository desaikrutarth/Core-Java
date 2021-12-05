package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/*
 You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character.
Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4
Output: "5F3Z-2E9W"
Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.

Example 2:
Input: S = "2-5g-3-J", K = 2
Output: "2-5G-3J"
Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 */
public class LicenceKeyFormatting
{
	private static String licenseKeyFormatting(String str, int k) 
	{
		int pos = str.indexOf('-')+1;
		String substring = str.substring(pos);
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		for(int i=0; i<substring.length(); i++)
		{
			char ch = substring.charAt(i);
			if(ch != '-')
			{
				if(count++ == k)
				{
					sb.append('-');
					count=0;
				}
				sb.append(ch);
			}
		}
		return str.substring(0, pos)+sb.toString().toUpperCase();
	}
	
/*	private static String licenseKeyFormatting(String str, int k) 
	{
		String substring = str.substring(str.indexOf('-'));
		String result = "";
		int count=0;

		for(int i=0; i<substring.length(); i++)
		{
			char ch = substring.charAt(i);
			if(ch != '-')
			{
				count++;
				result += ch;

				if(count == k)
					result += (i != substring.length()-1)? "-" : "";
			}
		}
		return str.substring(0,str.indexOf('-')+1) + result.toUpperCase();
	}
*/	
	/*private static String licenseKeyFormatting(String str, int k) 
	{
		int pos = str.indexOf('-');
		String prefix = str.substring(0, pos+1);
		int count = 0;
		String result = "";
		
		for(int i=pos; i<str.length(); i++)
		{
			if(str.charAt(i) != '-')
			{
				if(count < k) 
				{
					result += str.charAt(i);
					count++;
				}
				else
				{
					count = 0;
					result += "-";
				}
			}
			else if(str.charAt(i) == '-' && count == k)
			{
				result += str.charAt(i);
				count = 0;
			}
		}
		return prefix+result.toUpperCase();
	}*/
	
	public static void main(String[] args) 
	{
		System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
	}

	
}
