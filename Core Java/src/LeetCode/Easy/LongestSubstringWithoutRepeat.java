package LeetCode.Easy;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat
{
	 public static int lengthOfLongestSubstring(String str) 
	 {
		 HashSet<Character> set = new HashSet<>();
		 int left = 0;
		 String result = "";
		 set.add(str.charAt(0));
		 
		 for(int i=1; i<str.length(); i++)
		 {
			 if(set.contains(str.charAt(i)))
			 {
				 String substring = str.substring(left, i);
				 if(substring.length() > result.length())
					 result = substring;
				 left = i;
				 set.clear();
				 set.add(str.charAt(i));
			 }
			 else
				 set.add(str.charAt(i));
		 }
		 System.out.println(result);
		 return result.length();
	 }
	public static void main(String[] args) 
	{
		String s = "GEEKSFORGEEK";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
