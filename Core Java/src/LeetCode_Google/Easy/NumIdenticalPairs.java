package LeetCode_Google.Easy;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 */
public class NumIdenticalPairs {
	
	public static int numIdenticalPairs(int[] nums)
	{
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int num : nums)
        {
            answer += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return answer;
    }
	
	public static void main(String[] args)
	{
		int[] nums = {1,2,3,1,1,3};
		System.out.println(numIdenticalPairs(nums));
	}
}
