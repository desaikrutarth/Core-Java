package Recurssion;
/*
Given a string (for example: "a?bc?def?g"), write a program to generate all the possible strings by replacing ? with 0 and 1. 
Example: 
Input : a?b?c? 
Output: a0b0c0, a0b0c1, a0b1c0, a0b1c1, a1b0c0, a1b0c1, a1b1c0, a1b1c1.
 */
public class ReplaceCharactersString 
{
	public static void replace(String str, int pos)
	{
		if (pos == str.length())
		{
			System.out.println(str);
			return;
		}
		
		if (str.charAt(pos) != '?'){
			replace(str, pos+1);
		}
		else 
		{
			String prefix = str.substring(0, pos);
			String postfix = str.substring(pos+1);
			
			replace(prefix + "0" + postfix, pos+1);
			replace(prefix + "1" + postfix, pos+1);
		}
	}
	
	
	public static void main(String[] args)
	{
		String str = "a?b?c?";
		replace(str, 0);
	}
}
