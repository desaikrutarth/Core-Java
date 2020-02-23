package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class NextGreaterElement 
{
	public static List<Integer> findGreater(Integer[] nums1, Integer[] nums2)
	{
		List<Integer> nums2List = new ArrayList<>(Arrays.asList(nums2));
		List<Integer> outputList = new ArrayList<>();

		for(int element : nums1)
		{
			int index = nums2List.indexOf(element);
			
			if(index < nums2.length-1 && element < nums2[index+1])
				outputList.add(nums2[index+1]);	
			else
				outputList.add(-1);

		}
		return outputList;
	}
	
/*	private static int[] nextGreaterElement(Integer[] nums1, Integer[] nums2) 
	{
		List<Integer> nums2List = new ArrayList<>(Arrays.asList(nums2));
		int[] result = new int[nums1.length];
		
		for(int i=0; i<nums1.length; i++)
		{
			int index = nums2List.indexOf(nums1[i]);	
			if(index == nums2.length-1 || (index < nums2.length && nums1[i] > nums2[index+1]))
				result[i] = -1;
			else
				result[i] = nums2List.get(index+1);
		}
		return result;
	}*/

	public static void main(String[] args) 
	{
		Integer[] nums1 = {2,4};
		Integer[] nums2 = {1,2,3,4};
		System.out.println(findGreater(nums1,nums2));
	}
	
}
