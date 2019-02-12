package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 

For example, given 
s = "leetcode", 
dict = ["leet", "code"]. 

Return true because "leetcode" can be segmented as "leet code".
*/
public class CheckStringSplitSpace
{
	static boolean checkOrder(List<String> dict, String input)
	{
		ArrayList<String> list = new ArrayList<>();
		for(String str : dict)
		{
			if(input.contains(str))
			{
				int start = input.indexOf(str);
				int end = start + str.length();
				String substring = input.substring(start, end);
				list.add(substring);
			}
			else
				return false;
		}
		System.out.println(list);
		return list.equals(dict);
	}
	
	public static void main(String[] args)
	{
		String input = "leetcode";
		List<String> dict = new ArrayList<>(Arrays.asList("leet", "code"));
		
		System.out.println(checkOrder(dict,input));
	}
}
