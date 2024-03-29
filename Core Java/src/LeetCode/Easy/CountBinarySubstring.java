package LeetCode.Easy;
/*
 Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 */
public class CountBinarySubstring 
{
	public static int countBinarySubstrings(String str)
	{
		int zeroCount = 0;
		int oneCount = 0;
		int totalCount = 0;
		
		int left=0;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == '0')
				zeroCount++;
			else
				oneCount++;
			
			if(zeroCount == oneCount)
			{
				totalCount++;
				i = left;
				left++;
				zeroCount = 0;
				oneCount = 0;
			}
		}
		return totalCount;
	}
	
	 /*public static int countBinarySubstrings(String s)
	 {
	       int ans = 0, prev = 0, cur = 1;
	       for (int i = 1; i < s.length(); i++)
	       {
	           if (s.charAt(i-1) != s.charAt(i))
	           {
	                ans += Math.min(prev, cur);
	                prev = cur;
	                cur = 1;
	           }
	           else
	                cur++;
	 
	       }
	       return ans + Math.min(prev, cur);
	  }*/
	 
	/*public static int countBinarySubstrings(String s)
	 {
		 if(s == null || s.length() == 0)
			 return 0;
	        
	        int rem = 0, count = 1;
	        int result = 0;
	        for(int i = 1; i < s.length(); i++)
	        {
	            if(s.charAt(i) == s.charAt(i - 1))
	                count ++;
	            else
	            {
	                rem = count;
	                count = 1;
	            }
	            if(count <= rem)
	                result ++;
	        }
	        return result;
	  }*/
	 
	 public static void main(String[] args)
	 {
		 System.out.println(countBinarySubstrings("00110011"));
	 }
}
