package LeetCode.Easy;
/*
 We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:	
Input: A = 'abcde', B = 'abced'
Output: false
 */
public class RotateString
{
	public static boolean rotateString(String A, String B)
	{
		if(A.length() != B.length())
			return false;
		String AA = A + A;
		return AA.contains(B);
    }
	
	public static void main(String[] args) 
	{
		System.out.println(rotateString("abcde","cdeab"));
	}
}
