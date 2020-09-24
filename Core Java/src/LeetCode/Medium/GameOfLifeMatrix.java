package LeetCode.Medium;
/*

Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:

1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2.Any live cell with two or three live neighbors lives on to the next generation.
3.Any live cell with more than three live neighbors dies, as if by over-population..
4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. 
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
 */
public class GameOfLifeMatrix
{
	public static int[][] gameOfLife(int[][] board)
	{
        int[][] output=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                int neighbour = count(i,j,board);
                //Rule 1
                if(board[i][j]==1 && neighbour<2)
                    output[i][j]=0;
                //Rule 2
                else if(board[i][j]==1 && (neighbour==2 || neighbour==3))
                    output[i][j]=1;
                //Rule 3
                 else if(board[i][j]==1 && neighbour>3)
                    output[i][j]=0;
                //Rule 4
                 else if(board[i][j]==0 && neighbour==3)
                    output[i][j]=1;
            }         
        }    
        return output;             
    }
	
	public static int count(int i,int j,int[][]board)
    {
//Find value in 8 Direction: left  right  down   Up	 down-left down-right up-left up-right
         int[][] direction={{0,-1},{0,1},{1,0},{-1,0},{1,-1},   {1,1},   {-1,-1}, {-1,1}};
         int count=0;
         for(int[] dir:direction)
         {
             int x = i + dir[0];
             int y = j + dir[1];
             if(x>=0 && y>=0 && x<board.length && y<board[0].length)
             {
                 count+=board[x][y];
             }
         }
         return count;
     }
     
     public static void main(String[] args)
     {
    	 int[][] board = {{0,1,0},
    			 		  {0,0,1},
    			 		  {1,1,1},
    			 		  {0,0,0}};
    	 
    	 int[][] output = gameOfLife(board);
    	 
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
