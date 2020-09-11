package LeetCode.DP;

/*
In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position you can walk one step to the left, right, up or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.

Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 */
public class PathWithMaximumGold
{
	public int getMaximumGold(int[][] grid) 
	{
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) 
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                maxGold = Math.max(maxGold, findMaxGold(grid, i, j));
            }
        }
        return maxGold;
    }
	
    public int findMaxGold(int[][] grid, int rowIndex, int colIndex) 
    {
        if (rowIndex < 0 || rowIndex == grid.length || colIndex < 0 || colIndex == grid[0].length || grid[rowIndex][colIndex] == 0) 
        	return 0;
        
        int origin = grid[rowIndex][colIndex];
        grid[rowIndex][colIndex] = 0; // mark as visited
        int maxGold = 0;
        
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};	//Find value in 4 Direction: left,right,down,Up
        for(int[] dir : directions)
        {
        	int x = dir[0] + rowIndex;
        	int y = dir[1] + colIndex;
        	maxGold = Math.max(maxGold, findMaxGold(grid, x, y));
        }
        grid[rowIndex][colIndex] = origin; // backtrack
        
        return maxGold + origin;
    }
    
    public static void main(String[] args)
    {
    	int[][] matrix = {{0,6,0},
    			 		  {5,8,7},
    			 		  {0,9,0}};
    	
    	System.out.println(new PathWithMaximumGold().getMaximumGold(matrix));
	}
}
