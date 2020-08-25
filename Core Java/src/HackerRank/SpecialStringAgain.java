package HackerRank;

import java.util.*;
import java.util.stream.Collectors;
/*
A string is said to be a special string if either of two conditions is met:
1) All of the characters are the same, e.g. aaa.
2) All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria.
Given a string, determine how many special substrings can be formed from it.
Example 1:
Input: asasd
Output: 7
Explaination: s = {a,s,a,s,d,asa,sas}

Example 2:
Input: abcbaba
Output: 10
Explaination: s = {a,b,c,b,a,b,a,bcb,bab,aba}

Example 3:
Input: aaaa
Output: 10
Explaination: s = {a,a,a,a,aa,aa,aa,aaa,aaa,aaaa}
 */
public class SpecialStringAgain
{
	static long substrCount(String s)
    {
		long retVal = s.length();

        for (int i = 0; i < s.length(); i++)
        {
            char startChar = s.charAt(i);
            int diffCharIdx = -1;
            for (int j = i + 1; j < s.length(); j++)
            {
                char currChar = s.charAt(j);
                if (startChar == currChar)
                {
                    if ((diffCharIdx == -1) ||
                       (j - diffCharIdx) == (diffCharIdx - i))
                        retVal++;
                }
                else
                {
                    if (diffCharIdx == -1)
                        diffCharIdx = j;
                    else
                        break;
                }
            }
        }
        return retVal;
    }
	
	//Method 2:
/*	static long substrCount(String s)
    {
        long count = 0;
        for(int i=0; i<s.length(); i++)
        {
            for(int j=i+1; j<=s.length(); j++)
            {
                String substring = s.substring(i,j);
                if(substring.length() == 1)
                    count++;
                else
                {
                    Set<Character> set = substring.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
                                          
                    if(set.size() == 1)
                        count++;
                    else
                    {
                        if(substring.length() % 2 == 1)
                        {
                            int mid = substring.length() / 2;
                            if((substring.substring(0,mid)).equals(substring.substring(mid+1)))
                                count++;
                        }
                    }
                }
            }
        }
        return count;
    } */
	
	public static void main(String[] args)
	{
		System.out.println(substrCount("asasd"));
	}
}
