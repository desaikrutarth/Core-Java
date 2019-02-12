package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 

For example, given 
s = "leetcode", 
dict = ["leet", "code"]. 

Return true because "leetcode" can be segmented as "leet code".
*/
public class TargetSumOfThreeArrays 
{
	//Method 1: O(n)
	static List<List<Integer>> threeSum(int[] a, int[] b, Integer[] c, int target)
	{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cList = new ArrayList<>(Arrays.asList(c));	
		
		int i=0;
		int j=0;
		
		while(i < a.length && j < b.length)
		{
			int sum = a[i] + b[j];
			if(cList.contains(target-sum))
				result.add(Arrays.asList(a[i], b[j], target-sum));
			
			if(j == b.length-1)
			{
				i++;
				j=0;
			}
			else
				j++;
		}
		return result;
	}
	
	//Method 2: O(n)^2
/*	static List<List<Integer>> threeSum(int[] a, int[] b, Integer[] c, int target)
	{
		List<List<Integer>> res = new ArrayList<>();
		for(int i = 0 ; i < a.length; i++)
		{
			for(int j = 0; j < b.length; j++)
			{
				int subSum = a[i] + b[j];		//Get the sum of first 2 Arrays
				if(subSum < target)
				{
					int index = Arrays.binarySearch(c, target-subSum);  //Get index of Array C by Binary Search
					
					if(index < 0)
						continue;
					if(c[index] == target-subSum)     // if Element exists in Array C
					{
						res.add(Arrays.asList(a[i], b[j], c[index]));
					}
				}
			}
		}
		return res;
	} */
	
/*	static boolean binarySearch(int[] c, int target)
	{
		int left = 0;
		int right = c.length - 1;
		while(left <= right)
		{
			int mid = left + (right -left)/2;
			if(c[mid] == target)
				return true;
			else if(c[mid] < target)
				left = mid +1;
			else
				right = mid -1;
		}
		return false;
	}*/

	public static void main(String[] args) 
	{
		int[] a = {1, 2, 3};
		int[] b = {2, 3, 4};
		Integer[] c = {1, 2, 4};
		
		System.out.println(threeSum(a, b, c, 7));
	}
}
