package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

/*
Given a matrix, and a target, return the number of non-empty submatrices that sum to target.
A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different:
for example, if x1 != x1'.
 
Example 1:

Input: matrix = [[0,1,0], target = 0
				 [1,1,1]
				 [0,1,0]]
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.

Example 2:

Input: matrix = [[1,-1] , target = 0
				 [-1,1]]
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 */
public class AllSubmatricesThatSumToTarget 
{
	public static int numSubmatrixSumTarget(int[][] matrix, int target)
	{
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int result = 0;
        
        for(int rowIndex = 0; rowIndex < cols; rowIndex++)
        { 
            int[] array = new int[rows];
            for(int colIndex = rowIndex; colIndex < cols; colIndex++)
            { 
                for(int i = 0; i < rows; i++)
                {
                	//Add each column to the previous columns
                    array[i] += matrix[i][colIndex];
                }
                result += subarraySum(array, target);
            }
        }
        return result;
    }
    
    public static int subarraySum(int[] nums, int target) 
    {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (preSum.containsKey(sum - target))
                result += preSum.get(sum - target);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
    	int[][] matrix = {{0,1,0},
				 		  {1,1,1},
				 		  {0,1,0}};
    	
    	System.out.println(numSubmatrixSumTarget(matrix, 0));
	}
}
