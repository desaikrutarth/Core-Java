package LeetCode.Easy;

import java.util.Arrays;

/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.
We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Input: nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

Input: nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
 */
public class PivotIndex
{
	public static int pivotIndex(int[] nums) 
	{
        int sum = Arrays.stream(nums).sum();
        int leftsum = 0;
        
        for (int i = 0; i < nums.length; ++i)
        {
            if (leftsum == sum - leftsum - nums[i])
            	return i;
            leftsum += nums[i];
        }
        return -1;
    }
	
	public static void main(String[] args) 
	{
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(pivotIndex(nums));
	}
}
