package HackerRank;

import java.math.BigInteger;

/*
 A numeric string S, is beautiful if it can be split into a sequence of two or more positive integers, satisfying the following conditions:
 1) a[i] - a[i-1] = 1
 2) No a[i] contains a leading zero.
    For example, we can split S = 10203 into the sequence {1,02,03} ,but it is not beautiful because 02 and 03 have leading zeroes.
 3) The contents of the sequence cannot be rearranged.
    For example, we can split S = 312 into the sequence {3,1,2}, but it is not beautiful because it breaks our first constraint (i.e., 1-3!=1).

	S = "1234" = 1 + 2 + 3 + 4
	Output: YES 1
	
	S = "91011" = 9 + 10 + 11
	Output: YES 9
	
	S = "99100" = 99 + 100
	Output: YES 99
	
	S = "99910001001" = 999 + 1000 + 1001
	Output: YES 99
	
	S = "7891011" = 7 + 8 + 9 + 10 + 11
	Output: YES 7
	
	S = "010203" = 01 + 02 + 03
	Output: NO. Because leading zeros not valid
	
 */
public class SeparateTheNumbers
{
	static String separateNumbers(String str)
	{
		for(int i=1; i<str.length(); i++)
        {
        	BigInteger cur = new BigInteger(str.substring(0,i));
        	String s = cur.toString();
        	
        	while(s.length() < str.length())
        	{
        		cur = cur.add(BigInteger.ONE);
        		s += cur;
        	}
        	
        	if(s.equals(str))
        	{
        		return "YES "+ str.substring(0,i);
        	}
        }
        return "NO";
    }
	public static void main(String[] args)
	{
		String str = "99910001001";
        System.out.println(separateNumbers(str));
	}
}
