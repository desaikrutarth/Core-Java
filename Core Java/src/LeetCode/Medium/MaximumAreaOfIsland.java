package LeetCode.Medium;
/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 
Output: 6 => 1   1
			 1 1 1
			 	 1
from co-ordinate : (3, 8) to (6, 10) 			 	 
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
 */
public class MaximumAreaOfIsland
{
    static boolean[][] seen;

    static public int maxAreaOfIsland(int[][] grid)
    {
    	int rows = grid.length;
    	int cols = grid[0].length;
    	
        seen = new boolean[rows][cols];
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
            	int area = findArea(i, j, grid);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    
    static public int findArea(int r, int c, int[][] grid)
    {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return 0;
        
        if(seen[r][c] || grid[r][c] == 0)
        	return 0;
        
        seen[r][c] = true;
        
        int sum = 1 + findArea(r, c+1, grid)
        			+ findArea(r+1, c, grid)
        			+ findArea(r, c-1, grid)
        			+ findArea(r-1, c, grid);
        
        return sum;
    }

    public static void main(String[] args)
    {
    	 int[][] grid =  {{0,0,1,0,0,0,0,1,0,0,0,0,0},
    	                  {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                  {0,1,1,0,1,0,0,0,0,0,0,0,0},
    	                  {0,1,0,0,1,1,0,0,1,0,1,0,0},
    	                  {0,1,0,0,1,1,0,0,1,1,1,0,0},
    	                  {0,0,0,0,0,0,0,0,0,0,1,0,0},
    	                  {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                  {0,0,0,0,0,0,0,1,1,0,0,0,0}};
    	 
    	 System.out.println(maxAreaOfIsland(grid));
	}
}
