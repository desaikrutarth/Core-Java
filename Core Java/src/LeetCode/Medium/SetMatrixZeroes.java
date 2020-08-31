package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;
/*
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Example:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
0 1 2 0
3 4 5 2
1 3 1 5

Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
0 0 0 0 
0 4 5 0 
0 3 1 0
 */
public class SetMatrixZeroes
{
	public static void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();

        //Essentially, we mark the rows and columns that are to be made zero
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(matrix[i][j] == 0)
                {
                	rowSet.add(i);
                	colSet.add(j);
                }
            }
        }
        
        //Iterate over the array once again and using the rows and cols sets, update the elements
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
            	if (rowSet.contains(i) || colSet.contains(j)) 
            		matrix[i][j] = 0;
            }
        }
        
       for(int i=0; i<rows; i++)
       {
    	   for(int j=0; j<cols; j++)
    	   {
    		   System.out.print(matrix[i][j]+" ");
    	   }
    	   System.out.println();
        }
    }
	
	public static void main(String[] args)
	{
		int[][] arr = {{0,1,2,0},
			   	   	   {3,4,5,2},
			   	   	   {1,3,1,5}};

		setZeroes(arr);
	}
}
