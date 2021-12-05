package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
/*
 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
	[4,3,2,7,8,2,3,1]
Output:
	[5,6]

Input:
	[1,1]
Output:
	[2]

Input:
	[2,2]
Output:
	[1]
 */
public class FindMissingNumberArray 
{
	//Space: O(n), Runtime: O(n)
	static List<Integer> findDisappearedNumbers(Integer[] nums) 
	{ 
       List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums));
       List<Integer> result = new ArrayList<Integer>();
       
       for(int i=1; i <= nums.length; i++)
       {
    	   if(!list.contains(i))
    		   result.add(i);
       }
       return result;
    }
	
	//Space: O(1), Runtime: O(n)
/*	static List<Integer> findDisappearedNumbers(Integer[] nums) 
	{ 
		List<Integer> result = new LinkedList<Integer>();
		
		Arrays.parallelSort(nums);
		for(int i=1; i<nums.length; i++)
		{
			if(nums[i] <= nums[i-1])
			{
				if(result.contains(nums[i]))
					result.remove(nums[i]);
				
				nums[i] = nums[i-1]+1;
				result.add(nums[i]);
			}
		}
		return result;
	}
*/    
	public static void main(String[] args) 
	{
		Integer[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
	}
}
