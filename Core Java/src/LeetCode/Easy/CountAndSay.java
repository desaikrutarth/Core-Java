package LeetCode.Easy;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
 */
public class CountAndSay 
{
	public static String countAndSay(int n)
	{
		if(n == 1)
			return "1";
		
        String series = countAndSay(n-1);
        StringBuilder newSeries = new StringBuilder();
        
        for(int i=0; i<series.length(); i++)
        {
        	int count = 1;
        	
        	while(i < series.length()-1 && series.charAt(i) == series.charAt(i+1))
        	{
        		count++;
        		i++;
        	}
        	newSeries.append(count);
        	newSeries.append(series.charAt(i));
        }
        return newSeries.toString();
    }
	
	 /*public static String countAndSay(int n) 
	 {
	        String s = "1";
	        while(n>1)
	        {
	            String sub = "";
	            int num=0;
	            char ch, pre=' ';
	            for(int i=0; i<=s.length(); i++)
	            {
	                if(i==s.length())
	                	ch = ' ';
	                else
	                	ch = s.charAt(i);
	                
	                if((pre!=' ' && ch!=pre)|| ch==' ')
	                {
	                    sub += (num==0? 1:num)+""+pre;
	                    pre = ch;
	                    num = 1;
	                }
	                else
	                {
	                    num++;
	                    pre=ch;
	                }
	            }
	            s = sub;
	            n--;
	        }
	        return s;
	  }*/
	/*public static String countAndSay(int n)
	{
		if(n==1)
			return "1";
		
	    String str = "1";
	    StringBuffer sb;
	    while(--n > 0)
	    {
	         sb = new StringBuffer();
	         for(int i=0; i<str.length();)
	         {
	             char ch = str.charAt(i);
	             int j=1;
	             while(i+j<str.length() && ch==str.charAt(i+j))
	            	  j++;
	             
	             sb.append(j).append(ch);
	             i+=j;
	         }
	         str = sb.toString();
	   }
	   return str;
	}*/
	 
	public static void main(String[] args)
	{
		System.out.println(countAndSay(6));
	}
	
}
