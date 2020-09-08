package LeetCode.Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column

Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
 */
public class FindMinMaxNumberMatrix
{
	public static List<Integer> luckyNumbers (int[][] matrix)
    {
		int rows = matrix.length, cols = matrix[0].length;
        int[] minimum = new int[rows];
        int[] maximum = new int[cols];
        Arrays.fill(minimum, Integer.MAX_VALUE);
        
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                minimum[i] = Math.min(matrix[i][j], minimum[i]);
                maximum[j] = Math.max(matrix[i][j], maximum[j]);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j) 
            {
                if (minimum[i] == maximum[j]) 
                    res.add(minimum[i]);
            }
        }
        return res;        
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {{3, 7, 8},
						  {9, 11,13},
						  {15,16,17}};
		
		System.out.println(luckyNumbers(matrix));
	}
}
