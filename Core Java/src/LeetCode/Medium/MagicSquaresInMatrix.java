package LeetCode.Medium;
/*
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that
each row, column, and both diagonals all have the same sum.
Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).

Example 1:

Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1

Explanation: 
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
 */
public class MagicSquaresInMatrix 
{
	static int count = 0;
	public static int numMagicSquaresInside(int[][] matrix)
	{
		 int rows = matrix.length;
		 int cols = matrix[0].length;
		 
		 for(int i=0; i<=rows-3; i++)
		 {
			 for(int j=0; j<=cols-3; j++)
			 {
				 getCount(i,j,matrix);
			 }
		 }
		 return count;
	}

	private static void getCount(int rowIndex, int colIndex, int[][] matrix) 
	{
		int rowsum = 0;
		for(int i=0; i<3; i++)
			rowsum += matrix[rowIndex][i];
		
		int colsum = 0;
		for(int i=0; i<3; i++)
			colsum += matrix[i][colIndex];
		
		int diogonalSum = 0;
		for(int i=rowIndex, j=colIndex; i<rowIndex+3 && j<colIndex+3; i++,j++)
		{
			if(i <= matrix.length && j <= matrix[0].length)
				diogonalSum += matrix[i][j];
		}
		
		if(rowsum + colsum + diogonalSum == rowsum * 3)
			count++;
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{4,3,8,4},
		        		  {9,5,1,9},
		        		  {2,7,6,2}};
		
		System.out.println(numMagicSquaresInside(matrix));
	}
}
