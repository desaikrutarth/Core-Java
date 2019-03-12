package LeetCode.Easy;

import java.util.Arrays;

public class KDifferncePairs 
{
	 public static int findPairs(int[] nums, int k) 
	 {
	        int n = nums.length;
	        Arrays.sort(nums);
	        int left = 0;
	        int right = 1;
	        int result = 0;
	        while (left < n - 1 && right < n) 
	        {
	            int diff = nums[right] - nums[left];
	            if (diff == k && (left == right - 1 || nums[right] != nums[right - 1]))
	            	result++;
	            if (diff <= k)
	            	right++;
	            else
	            	left++;
	            if (left == right)
	            	right++;
	        }
	        return result;
	    }
	
	public static void main(String[] args) 
	{
		int[] arr = {3, 1, 4, 1, 5};
		int k=2;
		System.out.println(findPairs(arr,k));
	}
}
