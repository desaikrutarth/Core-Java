package LeetCode.Medium;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
public class UniquePathsRobot2
{
	static int noOfPaths=0;
    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        dfs(obstacleGrid, 0 ,0);
        return noOfPaths;
    }
    
    public static void dfs(int[][] matrix, int rowIndex, int colIndex)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        if(rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols)
            return;
        
        //If Obstacle
        if(matrix[rowIndex][colIndex] != 0)
            return;
        
        if(rowIndex == rows-1 && colIndex == cols-1)
        {
            noOfPaths++;
            return;
        }
        
        dfs(matrix, rowIndex, colIndex+1);
        dfs(matrix, rowIndex+1, colIndex);
    }
    
    public static void main(String[] args)
    {
    	int[][] arr = {{0, 0, 0},
		 			   {0, 1, 0},
		 			   {0, 0, 0}};
    	
    	System.out.println(uniquePathsWithObstacles(arr));
	}
}
