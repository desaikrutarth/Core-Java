package LeetCode.Medium;

/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1->3->1->1->1 minimizes the sum.
 */
public class MinimumPathSumMatrix
{
	static int minsum = Integer.MAX_VALUE;
    public static int minPathSum(int[][] grid)
    {
        dfs(grid, 0, 0, 0);
        return minsum;
    }
    
    public static void dfs(int[][] grid, int rowIndex, int colIndex, int sum)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols)
            return;
        
        sum += grid[rowIndex][colIndex];
        
        if(rowIndex == rows-1 && colIndex == cols-1)
        {
            minsum = Math.min(minsum, sum);
            return;
        }
        
        dfs(grid,rowIndex,colIndex+1,sum);
        dfs(grid,rowIndex+1,colIndex,sum);
    }
    
    //Dynamic Programming
 /* public int minPathSum(int[][] grid)
    {
    	int m = grid.length;// row
    	int n = grid[0].length; // column
    	for (int i = 0; i < m; i++)
    	{
    		for (int j = 0; j < n; j++)
    		{
    			if (i == 0 && j != 0) {
    				grid[i][j] = grid[i][j] + grid[i][j - 1];
    			} else if (i != 0 && j == 0) {
    				grid[i][j] = grid[i][j] + grid[i - 1][j];
    			} else if (i == 0 && j == 0) {
    				grid[i][j] = grid[i][j];
    			} else {
    				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
    						+ grid[i][j];
    			}
    		}
    	}
    	return grid[m - 1][n - 1];
    }
 */   
    public static void main(String[] args)
    {
    	int[][] arr = {{1, 3, 1},
	 			   	   {1, 5, 1},
	 			   	   {4, 2, 1}};
	
    	System.out.println(minPathSum(arr));
	}
}
