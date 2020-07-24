package LeetCode.Easy;

import java.util.Arrays;
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0
 */
public class SearchInsertPosition 
{
	private static int searchInsert(Integer[] nums, int target)
	{
		int index = Arrays.binarySearch(nums, target);
		
		if(index < 0)
		{
			for(int i=0 ; i<nums.length; i++)
			{
				if(nums[i] > target)
					return i;
			}
		}
		
		return index;
	}
	
	/*private static int searchInsert(Integer[] nums, int target)
	{
		int index = Arrays.binarySearch(nums, target);
		
		if(index >=0)
			return index;
		
		int minSub = Integer.MAX_VALUE;
		int result = 0;
		for(int i=0; i<nums.length; i++)
		{
			if(target > nums[i])
			{
				int sub = target-nums[i];
				if(sub < minSub)
				{
					sub = minSub;
					result = i+1;
				}
			}
		}
		return result;
	}*/
	
	public static void main(String[] args)
	{
		Integer[] nums = {1,3,5,6};
		int target = 5;
		System.out.println(searchInsert(nums, target));
	}
}
