package Google_3;

import java.util.Arrays;

/*
Given an int array without repeated elements and a target,
count the total number of subset that can be generated from the array such that min (subset) + max (subset) < target 
 */
public class TotalSubsetTarget
{
	public static int countSubSet(int[] nums, int target)
	{ 
        Arrays.sort(nums);
        int subsets=0;
        int start=0, end=nums.length-1;
       
        while(start<=end)
        {
        	if(2*nums[start]>=target)
               return subsets;
        	if(nums[start]+nums[end]<target)
        	{
        		if(start==end)
        			subsets=subsets+1;
        		else 
        			subsets= subsets+(int)Math.pow(2,end-start-1);
                
        		start++;
            }
        	else
               end--;
        }
        return subsets;       
	}
	
	public static void main(String[] args) 
	{
		int a[] = {1,4,5,7,11,14,20};
		System.out.println(countSubSet(a, 14));
	}
}
