package FaceBook;

public class RotateMatrix
{
	private static void rotateMatrix(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[][] arr = new int[cols][rows];
		int i=0;
		int j=0;
		
		for(int colIndex = cols-1; colIndex >= 0; colIndex--)
		{
			for(int rowIndex = rows-1; rowIndex >= 0; rowIndex--)
			{
				arr[i][j++] = matrix[rowIndex][colIndex];
			}
			i++;
			j=0;
		}
		
		for(int n=0; n<cols; n++)
		{
			for(int m=0; m<rows; m++)
			{
				System.out.print(arr[n][m]+" ");
			}
			System.out.println();
		}
			
	}
	
	public static void main(String[] args)
	{
		int[][] arr = {{1,2,3},
					   {4,5,6},
					   {7,8,9}};
		rotateMatrix(arr);
	}
}
