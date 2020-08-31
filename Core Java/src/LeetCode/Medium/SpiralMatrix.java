package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix
{
	public static List<Integer> spiralOrder(int[][] matrix)
	{
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) 
            return res;
        
        int rowIndex = 0;
        int rows = matrix.length-1;
        int colIndex = 0;
        int cols = matrix[0].length - 1;
        
        while (rowIndex <= rows && colIndex <= cols)
        {
            // Traverse Right
            for (int j = colIndex; j <= cols; j++) {
                res.add(matrix[rowIndex][j]);
            }
            rowIndex++;
            
            // Traverse Down
            for (int j = rowIndex; j <= rows; j++) {
                res.add(matrix[j][cols]);
            }
            cols--;
            
            if (rowIndex <= rows)
            {
                // Traverse Left
                for (int j = cols; j >= colIndex; j--) {
                    res.add(matrix[rows][j]);
                }
            }
            rows--;
            
            if (colIndex <= cols)
            {
                // Traverse Up
                for (int j = rows; j >= rowIndex; j --) {
                    res.add(matrix[j][colIndex]);
                }
            }
            colIndex ++;
        }
        
        return res;
    }
	 
	 public static void main(String[] args)
	 {
		 int[][] arr = {{1, 2, 3},
				 		{4, 5, 6},
				 		{7, 8, 9}};
		 
		 System.out.println(spiralOrder(arr));
	 }
}
