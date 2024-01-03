package LeetCode_Google.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum
{
	
	//Method 1: O(n^2)
	public static List<List<Integer>> threeSum(int[] nums) 
	{
        Set<List<Integer>> result = new HashSet<>();
        
        for(int i=0; i<nums.length; i++)
        {
        	Set<Integer> seen = new HashSet<>();
        	for(int j=i+1; j<nums.length; j++)
        	{
        		int sum = nums[i] + nums[j];
        		sum = sum * (-1);
        		
        		if(seen.contains(sum))
        		{
        			List<Integer> list = Arrays.asList(nums[i], nums[j], sum);
        			Collections.sort(list);
        			result.add(list);
        		}
        		seen.add(nums[j]);
        	}
        }
        return new ArrayList(result);
    }
	
//	public static List<List<Integer>> threeSum(int[] nums) 
//	{
//        Set<List<Integer>> res = new HashSet<>();
//        Set<Integer> dups = new HashSet<>();
//        
//        for (int i = 0; i < nums.length; ++i)
//        {
//        	if (dups.add(nums[i]))
//            {
//        		Set<Integer> seen = new HashSet<>();
//                for (int j = i + 1; j < nums.length; ++j) 
//                {
//                    int complement = -nums[i] - nums[j];
//                    if (seen.contains(complement)) 
//                    {
//                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
//                        Collections.sort(triplet);
//                        res.add(triplet);
//                    }
//                    seen.add(nums[j]);
//                }
//            }
//        }
//        return new ArrayList(res);
//    }
	
	public static void main(String[] args)
	{
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
}
