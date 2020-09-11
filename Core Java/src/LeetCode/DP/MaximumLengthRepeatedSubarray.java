package LeetCode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaximumLengthRepeatedSubarray
{
	//Method 1: Dynamic Programming
	/**DP formula:
	 * dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0;
	 * dp[i][j] : max lenth of common subarray start at a[i] & b[j];
	 */
	public static int findLength(int[] A, int[] B) 
	{
        if (A.length == 0 || B.length == 0)
        	return 0;
        
        int[] dp = new int[B.length + 1];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--)
        {
            for (int j = 0; j < B.length; j++)
                max = Math.max(max, dp[j] = (A[i] == B[j]) ? 1 + dp[j + 1] : 0);
        }
        return max;        
    }
	
	//Method 2:
/*	public int findLength(int[] A, int[] B)
	{
        int ans = 0;
        Map<Integer, ArrayList<Integer>> Bstarts = new HashMap<>();
        
        for (int j = 0; j < B.length; j++)
        {
            Bstarts.computeIfAbsent(B[j], x -> new ArrayList<>()).add(j);
        }

        for (int i = 0; i < A.length; i++)
        {
        	if (Bstarts.containsKey(A[i]))
        	{
        		for (int j: Bstarts.get(A[i])) 
        		{
        			int k = 0;
        			while (i+k < A.length && j+k < B.length && A[i+k] == B[j+k])
        			{
        				k++;
        			}
        			ans = Math.max(ans, k);
        		}
        	}
        }
        return ans;
    }
 */
	public static void main(String[] args)
	{
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		
		System.out.println(findLength(A, B));
	}
}
