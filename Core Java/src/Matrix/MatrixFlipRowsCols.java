package Matrix;

import java.util.Arrays;
/*
 * given a binary matrix of 01s, each time you click a point (i, j), the bit of the same row and column are all flipped. 
check if a matrix can be all 0s after many of this operation.
 * Example:   
 * 			  v	
 * 		  >{1 0 1} and points (0,1)
           {0 1 1}
           {0 0 0}
           {1 1 1}
   Output: 
   			0 1 0 
			0 0 1 
			0 1 0 
   			1 0 1
 * 
 */
public class MatrixFlipRowsCols
{
	public static void getMatrixRowsCols(int[][] matrix, int p1, int p2) 
    {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[] rowArray = new int[cols];
		int[] colArray = new int[rows];
		
		//Get a row of point p1 of matrix and store into rowArray
		for(int i=0; i<cols; i++)
		{
			rowArray[i] = matrix[p1][i];
		}
		
		//Get a column of point p2 of matrix and store into colArray
		for(int i=0; i<rows; i++)
		{
			colArray[i] = matrix[i][p2];
		}
		
		rowArray = flipArray(rowArray);		//flip rowArray
		colArray = flipArray(colArray);		//flip colArray
		
		matrix[p1] = rowArray;			//copy flipped rowArray into original matrix of row p1
		
		//copy flipped colArray into original matrix of column p2
		for(int i=0; i<rows; i++)
		{
			matrix[i][p2] = colArray[i];
		}
		
		//Print an original matrix
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j< cols; j++)
			{
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}		
    }
	
	private static int[] flipArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == 0)
				arr[i] = 1;
			else
				arr[i] = 0;
		}
		return arr;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int point1 = 0;
		int point2 = 1;
	    getMatrixRowsCols(new int[][]
	        				{{1, 0, 1},
            				 {0, 1, 1},
            				 {0, 0, 0},
            				 {1, 1, 1}}, point1, point2);
	                            
	                            					
	    }
}
