package Matrix;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Lonely Pixel 
Given an N x M image with black pixels and white pixels,
if a pixel is the only one in its color throughout its entire row and column, then it is a lonely pixel.
Find the number of lonely pixels in black from the image. (O(NM))
 */
public class MatrixFindLonelyPixel
{

	//Method 2:
    static int lonelyPixelCount(int[][] matrix)
    {
        int row = matrix.length;
        int cols = matrix[0].length;
        int[] colsArray = new int[row];
        int[] rowsArray = new int[cols];
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                colsArray[i] += matrix[i][j];
                rowsArray[j] += matrix[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < row; i++)
        {
            if(colsArray[i]==1) 
            {
            	for (int j = 0; j < cols; j++)
                {
                    if (rowsArray[j] == 1 && matrix[i][j] == 1)
                    {
                        result++;
                        break;
                    }
                }
            }
        }

        return result;
    }
	
	
    
    public static void main(String[] args)
    {
        System.out.println(lonelyPixelCount(new int[][]{ //0: black, 1: white
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 1},
        }));
    }

    // O(m*n)
    

}
