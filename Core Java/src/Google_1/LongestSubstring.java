
package Google_1;

import java.util.ArrayList;
/*
 * Given a string, find the longest substring without repeating any character.
 */

public class LongestSubstring
{
	
	void subString(String str)
	{
		String result = "";
		
		
		for(int i=0; i<str.length(); i++)
		{	
			ArrayList<Character> list = new ArrayList<Character>();
			list.add(str.charAt(i));
			
			for(int j=i+1;j<str.length(); j++)
			{	
				if(list.contains(str.charAt(j)))
				{					
					String subStr = str.substring(i, j);					
					if(subStr.length() > result.length())
						result = subStr;						
					break;
				}
				else
					list.add(str.charAt(j));
			}
		}
		
		System.out.println("Result = " + result);
	
	}
	
/*	void subString(String str)
	{
		String result="";
		for(int i=0; i<str.length()-1; i++)
		{
			List<Character> list = new ArrayList<>();
			list.add(str.charAt(i));
			
			for(int j=i+1; j<str.length(); j++)
			{
				if(!list.contains(str.charAt(j)))
				{
					String substring = str.substring(i,j+1);
					if(substring.length() > result.length())
						result = substring;
				}
				else
					break;
				list.add(str.charAt(j));
			}
			list.clear();
		}
		System.out.println(result);
	}
*/	
	public static void main(String[] args)
	{
		LongestSubstring lon = new LongestSubstring();
		String str = "GEEKSFORGEEKS";
		lon.subString(str);
		
	}	
}
