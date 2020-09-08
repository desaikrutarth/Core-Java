package LeetCode.Medium;
/*
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
 */
public class CheckDiagonalElementsMatrix
{
	public static boolean isToeplitzMatrix(int[][] matrix)
	{
		int j=0;
		
		for(int i=0; i<matrix[0].length-1; i++)
		{
			if(!(sameDiagonal(matrix[j][i], matrix, 0, i)))
				return false;
		}
		
		for(int i=1; i<matrix.length-1; i++)
		{
			if(!(sameDiagonal(matrix[i][j], matrix, i, 0)))
				return false;
		}
		
		return true;
    }
	
	private static boolean sameDiagonal(int element, int[][] matrix, int rowIndex, int colIndex)
	{
		if(rowIndex == matrix.length || colIndex == matrix[0].length)
			return true;
		
		if(matrix[rowIndex][colIndex] != element)
			return false;
		
		return sameDiagonal(element, matrix, rowIndex+1, colIndex+1);
	}
	
	//Method 2: Iterative
/*	public static boolean isToeplitzMatrix(int[][] matrix)
	{
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[0].length; ++j)
            {
                if (i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
*/
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3,4},
                		  {5,1,2,3},
                		  {9,5,1,2}};
		                  
		System.out.println(isToeplitzMatrix(matrix));
	}
}
