package LeetCode.Medium;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class FindWordFromMatrix
{
	public static boolean exist(char[][] board, String word)
	{
	    for(int i = 0; i < board.length; i++)
	    {
	        for(int j = 0; j < board[0].length; j++)
	        {
	            if(exist(board, i, j, word, 0))
	                return true;
	        }
	    }
	    return false;
	}
	private static boolean exist(char[][] board, int rowIndex, int colIndex, String word, int index)
	{
		int rows = board.length;
		int cols = board[0].length;
		
	    if(rowIndex >= rows || rowIndex < 0 || colIndex < 0 || colIndex >= cols)
	        return false;
	    
	    if(board[rowIndex][colIndex] != word.charAt(index))
	    	return false;
	    
	    if(index == word.length()-1)
	    	return true;
	    
	    //Mark as a visited
	    board[rowIndex][colIndex] = '*';
	    boolean result = exist(board, rowIndex, colIndex+1, word, index+1) ||	//Move Right
	                     exist(board, rowIndex+1, colIndex, word, index+1) ||	//Move Down
	                     exist(board, rowIndex-1, colIndex, word, index+1) ||	//Move Up
	                     exist(board, rowIndex, colIndex-1, word, index+1);		//Move Left
	    //backtrack
	    board[rowIndex][colIndex] = word.charAt(index);
	    return result;
	}
	
	public static void main(String[] args) 
	{
		char[][] matrix = {{'A','B','C','E'},
                		   {'S','F','C','S'},
                		   {'A','D','E','E'}};
		
		System.out.println(exist(matrix, "ABCCED"));
		System.out.println(exist(matrix, "SEE"));
		System.out.println(exist(matrix, "ABCB"));
	}
}
