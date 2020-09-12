package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s.
You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros.
For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 

Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:
Input: s = "1111"
Output: ["1.1.1.1"]

Example 4:
Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]

Example 5:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class RestoreIPAddresses 
{
	public static List<String> restoreIpAddresses(String s)
	{
        List<String> res = new ArrayList<String>();
        int len = s.length();
        
        for(int i = 1; i<4 && i<len-2; i++)
        {
            for(int j = i+1; j<i+4 && j<len-1; j++)
            {
                for(int k = j+1; k<j+4 && k<len; k++)
                {
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }
        return res;
    }
	
    public static boolean isValid(String s)
    {
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
    
    //Method 2: Backtracking
/*  public static List<String> restoreIpAddresses(String s)
    {
        List<String> res = new ArrayList<>();
        helper(s,"",res,0);
        return res;
    }
    
    public static void helper(String s, String tmp, List<String> res, int n)
    {
        if(n==4)
        {
            if(s.length()==0) 
            	res.add(tmp.substring(0,tmp.length()-1));
            //substring here to get rid of last '.'
            return;
        }
        for(int k=1;k<=3;k++)
        {
            if(s.length()<k)
            	continue;
            int val = Integer.parseInt(s.substring(0,k));
            if(val>255 || k!=String.valueOf(val).length()) 
            	continue;
            //in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.
            helper(s.substring(k),tmp+s.substring(0,k)+".",res,n+1);
        }
    }
 */
  
    public static void main(String[] args)
    {
    	System.out.println(restoreIpAddresses("25525511135"));
	}
}
