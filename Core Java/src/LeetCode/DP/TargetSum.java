package LeetCode.DP;
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class TargetSum 
{
	int count = 0;
    public int findTargetSumWays(int[] nums, int S)
    {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int index, int sum, int target)
    {
        if (index == nums.length)
        {
            if (sum == target)
                count++;
        } 
        else
        {
            calculate(nums, index + 1, sum + nums[index], target);
            calculate(nums, index + 1, sum - nums[index], target);
        }
    }
	 
	 //Method 2: Dynamic Programming
/*	 public int findTargetSumWays(int[] nums, int S) 
	 {
	     int[] dp = new int[2001];
	     dp[nums[0] + 1000] = 1;
	     dp[-nums[0] + 1000] += 1;
	     for (int i = 1; i < nums.length; i++)
	     {
	         int[] next = new int[2001];
	         for (int sum = -1000; sum <= 1000; sum++)
	         {
	             if (dp[sum + 1000] > 0) 
	             {
	                 next[sum + nums[i] + 1000] += dp[sum + 1000];
	                 next[sum - nums[i] + 1000] += dp[sum + 1000];
	             }
	         }
	         dp = next;
	     }
	     return S > 1000 ? 0 : dp[S + 1000];
	 }
*/	 
	 public static void main(String[] args)
	 {
		 int[] arr = {1, 1, 1, 1, 1};
		 int s = 3;
		 
		 System.out.println(new TargetSum().findTargetSumWays(arr, s));
	 }
}
