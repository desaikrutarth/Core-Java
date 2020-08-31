package LeetCode.Medium;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28
 */
public class UniquePathsRobot
{
	static int noOfPath = 0;
    public static int uniquePaths(int m, int n)
    {
        dfs(m,n,0,0);
        return noOfPath;
    }
    
    public static void dfs(int cols, int rows, int rowIndex, int colIndex)
    {
        if(rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols)
            return;
        
        if(rowIndex == rows-1 && colIndex == cols-1)
        {
            noOfPath++;
            return;
        }
        
        dfs(cols, rows, rowIndex, colIndex+1);
        dfs(cols, rows, rowIndex+1, colIndex);
    }
    
    //Method 2: Dynamic Programming
 /*   public static int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][0] = 1;
        
        for (int i = 1; i <= n; i++)
        {
        	for (int j = 1; j <= m; j++) 
        	{
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        	}
        }
        return dp[n][m];
      }
  */
    
    //Memoization (Runtime 0 ms, Time complexity m x n, Space complexity: m x n):
  /*  	  public int uniquePaths(int m, int n)
    	  {
    	    return uniquePathsHelper(m - 1, n - 1, new int[n][m]);
    	  }
    	  
    	  private int uniquePathsHelper(int m, int n, int[][] memo)
    	  {
    	    if (m < 0 || n < 0) {
    	      return 0;
    	    } else if (m == 0 || n == 0) {
    	      return 1;
    	    } else if (memo[n][m] > 0) {
    	      return memo[n][m];
    	    } else {
    	      memo[n][m] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
    	      return memo[n][m];
    	    }
    	  }
 */
    
    public static void main(String[] args)
    {
    	System.out.println(uniquePaths(3, 2));
	}
}
