package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
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
	static List<Integer> findDisappearedNumbers(int[] nums) 
	{ 
        HashSet<Integer> set = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();
        
        for(int i : nums)
        	set.add(i);
        
        
        for(int i=1; i<=nums.length; i++)
        {
        	if(!set.contains(i))
        		resultList.add(i);
        }
        return resultList;
    }
	/*public static List<Integer> findDisappearedNumbers(int[] nums)
	{
		List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[nums[i] - 1] != nums[i]) 
            {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }
        
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] != i + 1) 
                result.add(i + 1);
        }
        
        return result;
    }
    
    private static void swap(int[] nums, int x, int y) 
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }*/
    
	public static void main(String[] args) 
	{
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
	}
}
