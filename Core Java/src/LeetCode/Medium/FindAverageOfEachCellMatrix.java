package LeetCode.Medium;
/*
Given a 2D integer matrix M representing the gray scale of an image,
you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
 
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 */
public class FindAverageOfEachCellMatrix
{
	public static int[][] imageSmoother(int[][] image)
	{
		int rows = image.length;
		int cols = image[0].length;
        int[][] output = new int[rows][cols];
        
        for(int i=0; i<rows; i++)
        {
        	for(int j=0; j<cols; j++)
        	{
        		int average = getAverage(i, j, image);
        		output[i][j] = average;
        	}
        }       
        return output;
    }
	
	public static int getAverage(int i, int j, int[][] image)
	{
//Find value in 8 Direction: left  right  down   Up	 down-left down-right up-left up-right
        int[][] directions={{0,-1},{0,1},{1,0},{-1,0},{1,-1},   {1,1},   {-1,-1}, {-1,1}};
		int sum = image[i][j];
		int average = 0;
		int noOfElements = 1;
		
		for(int[] dir : directions)
		{
			int x = i + dir[0];
			int y = j + dir[1];
			
			if(x >= 0 && y >= 0 && x < image.length && y < image[0].length)
			{
				sum += image[x][y];
				noOfElements++;
			}
		}
		average = sum / noOfElements;
		return average;
	}
	
	public static void main(String[] args)
	{
		int[][] image = {{1,1,1},
		 		  		 {1,0,1},
		 		  		 {1,1,1}};

		int[][] output = imageSmoother(image);

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
