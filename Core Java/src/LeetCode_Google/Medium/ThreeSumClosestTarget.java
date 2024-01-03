package LeetCode_Google.Medium;

import java.util.Arrays;
/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
 */
public class ThreeSumClosestTarget 
{
	 public static int threeSumClosest(int[] nums, int target) 
	 {
		 int maxdiff = Integer.MAX_VALUE;
	     Arrays.sort(nums);
	     for (int i = 0; i < nums.length && maxdiff != 0; ++i)
	     {
	          int lo = i + 1;
	          int hi = nums.length - 1;
	          while (lo < hi)
	          {
	              int sum = nums[i] + nums[lo] + nums[hi];
	              int diff = Math.abs(target - sum);
	              if (diff < Math.abs(maxdiff))
	                  maxdiff = target - sum;
	              
	              if (sum < target)
	            	  lo++;
	              else
	                  hi--;
	           }
	      }
	      return target - maxdiff;
	 }	
	 
//	 public static int threeSumClosest(int[] nums, int target) 
//	 {
//	      int diff = Integer.MAX_VALUE;
//	      int sz = nums.length;
//	      Arrays.sort(nums);
//	      for (int i = 0; i < sz && diff != 0; ++i) 
//	      {
//	          for (int j = i + 1; j < sz - 1; ++j)
//	          {
//	              int complement = target - nums[i] - nums[j];
//	              int idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
//	              int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
//	              if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff))
//	                  diff = complement - nums[hi];
//	              if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
//	                  diff = complement - nums[lo];
//	          }
//	      }
//	      return target - diff;
//	 }
	 
	 public static void main(String[] args)
	 {
		 int[] nums = {-1,2,1,-4};
		 System.out.println(threeSumClosest(nums, 1));
	 }
}
