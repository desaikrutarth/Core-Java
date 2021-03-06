package LeetCode.DP;
/*
Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.

Example 1:
Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.

Example 2:
Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.

Example 3:
Input: mat = [[1,1,1,1,1,1]]
Output: 21

Example 4:
Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
 */
public class CountSubmatricesWithAllOnes
{
//	 loop each node, where count all the rectangular that use this node as bottome-right corner:
//	 treat all 1s in the left or above as histogram,
//	 counting towards left and just keep decreasing the histogram height;
//	 keep adding the height to result;
//	 height[i][j] means the current height of histogram with mat[i][j] as bottom;
	public static int numSubmat(int[][] matrix)
	{
        int rows = matrix.length, cols = matrix[0].length;
        int[] height = new int[cols];
        int result = 0; 
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                height[j] = (matrix[i][j] == 0) ? 0 : height[j] + 1;   //  height of histogram;
                for (int k = j, min = height[j]; k >= 0 && min > 0; k--)
                {
                    min = Math.min(min, height[k]);
                    result += min;
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,0,1},
		                  {1,1,0},
		                  {1,1,0}};
		System.out.println(numSubmat(matrix));
	}
}
