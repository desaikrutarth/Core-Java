package LeetCode.Easy;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat
{
	 public static int lengthOfLongestSubstring(String str) 
	 {
		 HashSet<Character> set = new HashSet<>();
		 set.add(str.charAt(0));
		 int start = 0;
		 String result = "";
		 
		 for(int i=1; i<str.length(); i++)
		 {
			 if(set.contains(str.charAt(i)))
			 {
				 String substring = str.substring(start, i);
				 start = i;
				 if(substring.length() > result.length())
					 result = substring;
				 set.clear();
			 }
			 set.add(str.charAt(i));
		 }
		 System.out.println(result);
		 return result.length();
	 }
	
	 /*public static int lengthOfLongestSubstring(String str) 
	 {
		 HashSet<Character> set = new HashSet<>();
		 String result = "";
		 for(int i=0; i<str.length(); i++)
		 {
			 set.add(str.charAt(i));
			 for(int j=i+1; j<str.length(); j++)
			 {
				 if(!set.contains(str.charAt(j)))
				 {
					 String substring = str.substring(i,j+1);
					 if(substring.length() > result.length()) {
						 result = substring;
						 break;
					 }
				 }
				 set.clear();
			 }
		 }
		 System.out.println(result);
		 return result.length();
	 }*/
	public static void main(String[] args) 
	{
		String s = "GEEKSFORGEEK";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
