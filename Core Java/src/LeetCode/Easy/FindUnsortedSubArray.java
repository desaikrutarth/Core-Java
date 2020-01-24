package LeetCode.Easy;

import java.util.Arrays;
/*
 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class FindUnsortedSubArray
{
	public static int findUnsortedSubarray(int[] nums)
	{
		int[] sortedArr = nums.clone();
		Arrays.sort(sortedArr);
		int start = nums.length;
		int end = 0;
		
		for(int i=0; i<nums.length; i++)
		{
			if(nums[i] != sortedArr[i])
			{
				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}
		
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
		
		if(end - start >= 0)
        	return end - start + 1;
        return 0;
	}
	
	public static void main(String[] args) 
	{
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println("Output = "+findUnsortedSubarray(nums));
	}
}
