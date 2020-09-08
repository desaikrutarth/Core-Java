package Matrix;

public class FindRectangleMaxSum
{
	static int maxsum = Integer.MIN_VALUE;
	
	private static int findMaxSumRect(int[][] matrix)
	{
		int row = matrix.length;
		int cols = matrix[0].length;
		
		for(int rowIndex = 0; rowIndex < row; rowIndex++)
		{
			
		}
		return maxsum;
	}
	
//	private static void findSumHelper(int[][] matrix, int rowIndex, int colIndex, int sum)
//	{
//		int row = matrix.length;
//		int cols = matrix[0].length;
//		
//		if(rowIndex >= row || colIndex >= cols || rowIndex < 0 || colIndex < 0)
//			return;
//		
//		sum += matrix[rowIndex][colIndex];
//		if(rowIndex == row-1 && colIndex == cols-1)
//		{
//			return;
//		}
//	}

	public static void main(String[] args)
	{
		findMaxSumRect(new int[][]{
            {6, 5, -9, 2},
            {-2, -5, -2, 7},
            {3, -2, 10, 13},
            {8, -3, 1, -2,}});
	}
}
