package Matrix;

import java.util.Arrays;
/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1]
		 [1,1,0]
		 [1,0,1]]
sr = 1, sc = 1, newColor = 2

Output: [[2,2,2]
		 [2,2,0]
		 [2,0,1]]

Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
 */
public class MatrixFillColor
{
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
		int oldColor = image[sr][sc];
		if(oldColor != newColor) {
			changeColor(image, sr, sc, newColor, oldColor);
		}
		return image;
	}

	private static void changeColor(int[][] image, int row, int col, int newColor, int oldColor)
	{
		if(row < 0 || col < 0 || row >= image.length || col >= image[0].length) {
			return;
		}

		if(image[row][col] != oldColor) {
			return;
		}

		image[row][col] = newColor;

		changeColor(image, row+1, col, newColor, oldColor);	// Move down;
		changeColor(image, row, col+1, newColor, oldColor);	// Move right;
		changeColor(image, row-1, col, newColor, oldColor); // Move up;
		changeColor(image, row, col-1, newColor, oldColor); // Move left;
	}
	
/*	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
        int color = image[sr][sc];
        if (color != newColor)
        	dfs(image, sr, sc, color, newColor);
        return image;
    }
	
    public static void dfs(int[][] image, int r, int c, int color, int newColor)
    {
        if (image[r][c] == color)
        {
            image[r][c] = newColor;
            if (r-1 >= 0)
            	dfs(image, r-1, c, color, newColor);
            if (c-1 >= 0)
            	dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length)
            	dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length)
            	dfs(image, r, c+1, color, newColor);
        }
    }*/
	
    public static void main(String[] args)
    {
    	int[][] image = {{1,1,1},
    					 {1,1,0},
    					 {1,0,1}};
    	
    	System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
	}
}
