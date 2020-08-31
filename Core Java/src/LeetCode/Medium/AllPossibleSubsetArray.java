package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class AllPossibleSubsetArray
{
	  List<List<Integer>> output = new ArrayList<>();
	  int n, k;
	  
//	  public List<List<Integer>> subsets(int[] nums)
//	  {
//		  n = nums.length;
//		  for (k = 0; k < n + 1; ++k)
//		  {
//			  backtrack(0, new ArrayList<Integer>(), nums);
//		  }
//		  return output;
//	  }
//
//	  public void backtrack(int first, ArrayList<Integer> curr, int[] nums)
//	  {
//	    // if the combination is done
//		  if (curr.size() == k)
//	      output.add(new ArrayList<>(curr));
//
//		  for (int i = first; i < n; ++i)
//		  {
//			  // add i into the current combination
//			  curr.add(nums[i]);
//			  // use next integers to complete the combination
//			  backtrack(i + 1, curr, nums);
//			  // backtrack
//			  curr.remove(curr.size() - 1);
//		  }
//	  }
	  
	  public List<List<Integer>> subsets(int[] nums)
	  {
		    List<List<Integer>> output = new ArrayList<>();
		    output.add(new ArrayList<Integer>());

		    for (int num : nums)
		    {
		    	List<List<Integer>> newSubsets = new ArrayList<>();
		    	for (List<Integer> curr : output) {
		    		newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
		    	}
		    	for (List<Integer> curr : newSubsets) {
		    		output.add(curr);
		    	}
		    }
		    return output;
	  }

	  public static void main(String[] args)
	  {
		  int[] nums = {1,2,3};
		  System.out.println(new AllPossibleSubsetArray().subsets(nums));
	  }
}
