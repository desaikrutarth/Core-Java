package LeetCode.DP;
/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10n.

Example:

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 <= x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
 */
public class CountNumberUniqueDigit
{
	public static int countNumbersWithUniqueDigits(int n)
	{
	    if(n==0)
	    	return 1;
	    if(n==1)
	    	return 10;

	    int ans = 10, base = 9;
	    //i: next multi-factor, j: control loop count
	    for(int i=9, j=n-1; i>0 && j>0; i--, j--)
	    {
	        base *= i;
	        ans +=base;
	    }
	    return ans;
	}
	
	public static void main(String[] args)
	{
		System.out.println(countNumbersWithUniqueDigits(2));
	}
}
