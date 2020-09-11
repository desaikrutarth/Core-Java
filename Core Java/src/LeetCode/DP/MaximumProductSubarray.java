package LeetCode.DP;

/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray
{
	public static int maxProduct(int[] nums)
	{
		if (nums == null || nums.length == 0)
		    return 0;

		int ans = nums[0];
		int min = ans;
		int max = ans;
		  
		for (int i = 1; i < nums.length; i++)
		{
		    if (nums[i] >= 0)
		    {
		    	max = Math.max(nums[i], max * nums[i]);
		    	min = Math.min(nums[i], min * nums[i]);
		    } 
		    else
		    {
		    	int tmp = max;
		    	max = Math.max(nums[i], min * nums[i]);
		    	min = Math.min(nums[i], tmp * nums[i]);
		    }
		    
		    ans = Math.max(ans, max);
		}
		  
		return ans;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {2,3,-2,4};
		System.out.println(maxProduct(arr));
	}
}
