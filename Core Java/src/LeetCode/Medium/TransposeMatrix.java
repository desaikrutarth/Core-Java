package LeetCode.Medium;

/*
Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

Example 1:

1 2 3			
4 5 6
7 8 9
Input: [[1,2,3],[4,5,6],[7,8,9]]

1 4 7 
2 5 8 
3 6 9
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:

1 2 3
4 5 6
Input: [[1,2,3],[4,5,6]]

1 4
2 5
3 6
Output: [[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix
{
	 public static int[][] transpose(int[][] matrix)
	 {
	     int rows = matrix.length;
	     int cols = matrix[0].length;
	       
	     int[][] output =  new int[cols][rows];   
	        
	     for(int j=0; j<cols; j++)
	     {
	         for(int i=0; i<rows; i++)
	         {
	             output[j][i] = matrix[i][j];
	         }
	     }
	     return output;
	 }
	 
	 public static void main(String[] args)
	 {
		 int[][] matrix = {{1,2,3},
				 		   {4,5,6},
				 		   {7,8,9}};
		 
		 int[][] output = transpose(matrix);
    	 
	    	//Print Output
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
