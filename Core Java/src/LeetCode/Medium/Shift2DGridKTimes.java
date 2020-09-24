package LeetCode.Medium;

/*
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:

Input: grid = [[1,2,3], k = 1
			   [4,5,6]
			   [7,8,9]]
			   
Output: [[9,1,2]
         [3,4,5]
         [6,7,8]]

Example 2:

Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 */
public class Shift2DGridKTimes 
{
	public static int[][] shiftGrid(int[][] grid, int k) 
    {
        while (k-- > 0)
        {
        	int rows = grid.length;
        	int cols = grid[0].length;
            int[][] newGrid = new int[rows][cols];

            // Case #1: Move everything not in the last column.
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols - 1; j++)
                {
                    newGrid[i][j + 1] = grid[i][j];
                }
            }

            // Case #2: Move everything in last column, but not last row.
            for (int i = 0; i < rows - 1; i++)
            {
                newGrid[i + 1][0] = grid[i][cols - 1];
            }

            // Case #3: Move the bottom right.
            newGrid[0][0] = grid[rows - 1][cols - 1];

            // Update grid to be the transformed grid.
            grid = newGrid;
        }

        return grid;
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3},
				  		  {4,5,6},
				  		  {7,8,9}};

		int[][] output = shiftGrid(matrix, 1);

		for(int i=0;i<output.length;i++)
		{
			for (int j=0;j<output[i].length;j++)
		    {
				System.out.print(output[i][j]+" ");
		    }
			System.out.println();
		}
	}
}
