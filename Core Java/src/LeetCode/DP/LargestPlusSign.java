package LeetCode.DP;

import java.util.Arrays;
/*
In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0.
What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.

An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right,
and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.

Examples of Axis-Aligned Plus Signs of Order k:

Order 1:
000
010
000

Order 2:
00000
00100
01110
00100
00000

Order 3:
0000000
0001000
0001000
0111110
0001000
0001000
0000000
Example 1:

Input: N = 5, mines = [[4, 2]]
Output: 2
Explanation:
11111
11111
11111
11111
11011
In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
Example 2:

Input: N = 2, mines = []
Output: 1
Explanation:
There is no plus sign of order 2, but there is of order 1.
Example 3:

Input: N = 1, mines = [[0, 0]]
Output: 0
Explanation:
There is no plus sign, so return 0.
 */
public class LargestPlusSign 
{
//	1.Create an N-by-N matrix grid, with all elements initialized with value N.
//	2.Reset those elements to 0 whose positions are in the mines list.
//	3.For each position (i, j), find the maximum length of 1's in each of the four directions and set grid[i][j] to the minimum of these four lengths. Note that there is a simple recurrence relation relating the maximum length of 1's at current position with previous position for each of the four directions (labeled as l, r, u, d).
//	4.Loop through the grid matrix and choose the maximum element which will be the largest axis-aligned plus sign of 1's contained in the grid.

	public static int orderOfLargestPlusSign(int N, int[][] mines)
	{
	    int[][] grid = new int[N][N];
	        
	    for (int i = 0; i < N; i++) {
	        Arrays.fill(grid[i], N);
	    }
	        
	    for (int[] m : mines) {
	        grid[m[0]][m[1]] = 0;
	    }
	        
	    for (int i = 0; i < N; i++) 
	    {
	        for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) 
	        {
	            grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
	            grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
	            grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
	            grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
	        }
	    }
	        
	    int res = 0;
	        
	    for (int i = 0; i < N; i++) 
	    {
	        for (int j = 0; j < N; j++) 
	        {
	            res = Math.max(res, grid[i][j]);
	        }
	    }
	        
	    return res;
	}
	
	public static void main(String[] args)
	{
		int[][] mines = {{4, 2}};
		int N = 5;
		System.out.println(orderOfLargestPlusSign(N, mines));
	}
}
