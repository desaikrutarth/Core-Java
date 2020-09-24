package LeetCode.Medium;
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

1 2 3	       7 4 1
4 5 6	 =>    8 5 2
7 8 9          9 6 3
 
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
public class Rotate2DImage
{
	public static int[][] rotate(int[][] matrix)
	{
		int i = 0, j = matrix.length - 1;
	    while(i < j)
	    {
	        int[] temp = matrix[i];
	        matrix[i] = matrix[j];
	        matrix[j] = temp;
	        i++; j--;
	    }

	    for(i = 0; i < matrix.length; i++)
	    {
	        for(j = i+1; j < matrix[0].length; j++)
	        {
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	    return matrix;    
	}
	 
	public static void main(String[] args)
	{
		int[][] arr = {{1, 2, 3},
			 		   {4, 5, 6},
			 		   {7, 8, 9}};
		int[][] matrix = rotate(arr);
		for(int n=0; n < matrix.length; n++)
	    {
	    	for(int m=0; m < matrix[0].length; m++)
	    	{
	    		System.out.print(matrix[n][m]+" ");
	    	}
	    	System.out.println();
	    }
	}
}
