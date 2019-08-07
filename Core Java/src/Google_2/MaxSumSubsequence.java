package Google_2;

import java.util.Arrays;
import java.util.HashSet;
/*
 * Write a program to find the sum of maximum sum subsequence of the given array such that the integers in the subsequence
 * are sorted in increasing order.
Example: 
	input: 1 101 2 3 100 4 5
	Output: 106 (=1+2+3+100)
All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e., 106. 
 */


public class MaxSumSubsequence 
{
	
	static void subArraysSum(int[] arr)
	{
		int sum = arr[0];
		int maxsum = Integer.MIN_VALUE;
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] > arr[i-1])
			{
				sum += arr[i];
				maxsum = Math.max(sum, maxsum);
			}
			else
			{
				sum = arr[0];
				sum += arr[i];
			}
		}
		System.out.println(maxsum);
		
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		MaxSumSubsequence.subArraysSum(arr);
	}
}
