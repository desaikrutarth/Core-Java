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
		int first = arr[0];
		int maxSum = first;
		int index = 1;
		
		while(index < arr.length)
		{
			if(arr[index] > arr[index-1])
			{
				first += arr[index];
				if(first > maxSum)
					maxSum = first;
			}
			else
			{
				first = arr[0];
				first += arr[index];
			}
			index++;
		}
		System.out.println(maxSum);
		
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		MaxSumSubsequence.subArraysSum(arr);
	}
}
