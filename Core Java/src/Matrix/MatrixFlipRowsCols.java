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
		int[] colsArray = new int[rows];
		
		//Get RowArray of point p1
		for(int i=0; i<rows; i++)
		{
			if(i == p1)
			{
				for(int j=0; j<cols; j++)
				{
					rowArray[j] = matrix[i][j];
				}
			}			
		}
		
		//Get ColArray of point p2
		for(int i=0; i<cols; i++)
		{
			if(i == p2)
			{
				for(int j=0; j<rows; j++)
				{
					colsArray[j] = matrix[j][i];
				}
			}
		}
		
		rowArray = flipArray(rowArray);		//flip rowArray
		colsArray = flipArray(colsArray);	//flip colArray
		
		matrix[p1] = rowArray;				//copy flipped rowArray into original matrix of row p1
		
		//copy flipped colArray into original matrix of column p2
		for(int i=0; i<cols; i++)
		{
			if(i==p2)
			{
				for(int j=0; j<rows; j++)
				{
					matrix[j][i] = colsArray[j];
				}
			}
		}	
		
		//Print an original array
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j< cols; j++)
			{
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}		
    }
	
	//Method to flip an array
	static int[] flipArray(int[] arr)
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
