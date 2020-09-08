package LeetCode.Medium;

/*
Given a m x n matrix mat and an integer threshold. 
Return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.

Example 1:
[[1,1,3,2,4,3,2]	1 1	 1 1
 [1,1,3,2,4,3,2] =>	1 1, 1 1
 [1,1,3,2,4,3,2]]

Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.

Example 2:
Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
Output: 0

Example 3:
Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
Output: 3

Example 4:
Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
Output: 2
 */
public class MaxLengthOfSqaureMatrixSum
{
	public static int maxSideLength(int[][] mat, int threshold)
	{
        int row = mat.length;
        int col = mat[0].length;
        int[][] sums = new int[row + 1][col + 1];
        int max = 0;
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + mat[i][j];
                if (i - max >= 0 && j - max >= 0 && 
                    sums[i + 1][j + 1] - sums[i - max][j + 1] - sums[i + 1][j - max] + sums[i - max][j - max] <= threshold) 
                {
                    max += 1;
                }
            }
        }
            
        return max;    
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,1,3,2,4,3,2},
		                  {1,1,3,2,4,3,2}, 
		                  {1,1,3,2,4,3,2}};
		
		System.out.println(maxSideLength(matrix, 4));
	}
}
