package Matrix;
import java.util.Arrays;
/*
 You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = [[1,2],
		[3,4]]
	r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

Example 2:
Input: 
nums = [[1,2],
 		[3,4]]
	r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */
public class MatrixReshape 
{
	public static int[][] matrixReshape(int[][] nums, int r, int c) 
	{
		int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int rows = 0, cols = 0;
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[0].length; j++)
            {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c)
                {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) 
	{
		int[][] nums = {{1,2},
						{3,4}};
		int r=1, c=4;
		System.out.println(Arrays.deepToString(matrixReshape(nums, r, c)));
	}
}
