package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a m * n matrix mat of integers,
sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.

Example 1:

Input: matrix = [[3,3,1,1]
			     [2,2,1,2]
			     [1,1,1,2]]
			  
Output: [[1,1,1,1]
		 [1,2,2,2]
		 [1,2,3,3]]
 */
public class SortMatrixDiagonally
{
	public static int[][] diagonalSort(int[][] matrix)
    {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i=0; i<cols-1; i++)
		{
			getSorted(0 , i, matrix);
		}
		
		for(int i=1; i<rows-1; i++)
		{
			getSorted(i , 0, matrix);
		}
		return matrix;
    }

	private static void getSorted(int rowIndex, int colIndex, int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		List<Integer> list = new ArrayList<>();
		for(int i=rowIndex, j=colIndex; i<rows && j<cols; i++,j++)
		{
			list.add(matrix[i][j]);
		}
		Collections.sort(list);
		int index=0;
		
		for(int i=rowIndex, j=colIndex; i<rows && j<cols; i++,j++)
		{
			matrix[i][j] = list.get(index++);
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{3,3,1,1},
						  {2,2,1,2},
						  {1,1,1,2}};
		
		int[][] output = diagonalSort(matrix);
		
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
