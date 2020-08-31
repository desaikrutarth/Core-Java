package LeetCode.Medium;

/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII
{
	public static int[][] generateMatrix(int n)
	{
		int[][] matrix = new int[n][n];
		
		int num = 1;
		
		int rowIndex = 0;
		int colIndex = 0;
		int rows = n-1;
		int cols = n-1;
		
		while(rowIndex <= rows && colIndex <= cols)
		{
			// Traverse Right
			for(int i = colIndex; i <= cols; i++)
			{
				matrix[rowIndex][i] = num++;
			}
			rowIndex++;
			
			// Traverse Down
			for(int i = rowIndex; i <= rows; i++)
			{
				matrix[i][rows] = num++;
			}
			cols--;
			
			if(rowIndex <= rows)
			{
				// Traverse Left
				for(int i = cols; i >= colIndex; i--)
				{
					matrix[rows][i] = num++;
				}
			}
			rows--;
			
			if(colIndex <= cols)
			{
				// Traverse Up
				for(int i = rows; i >= rowIndex; i--)
				{
					matrix[i][colIndex] = num++;
				}
			}
			colIndex++;
		}
		
		return matrix;
	}
	
	public static void main(String[] args)
	{
		int n = 3;
		int[][] arr = generateMatrix(n);
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
