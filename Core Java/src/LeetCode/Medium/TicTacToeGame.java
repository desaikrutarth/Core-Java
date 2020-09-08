package LeetCode.Medium;
/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

Here are the rules of Tic-Tac-Toe:
1.Players take turns placing characters into empty squares (" ").
2.The first player A always places "X" characters, while the second player B always places "O" characters.
3."X" and "O" characters are always placed into empty squares, never on filled ones.
4.The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
5.The game also ends if all squares are non-empty.
6.No more moves can be played if the game is over.
Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where
they mark their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", 
if there are still movements to play return "Pending".

You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.

Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"

Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
"   "    "   "    "   "    "   "    "   "    "O  "
Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"

Example 4:

Input: moves = [[0,0],[1,1]]
Output: "Pending"
Explanation: The game has not finished yet.
"X  "
" O "
"   "
 */
public class TicTacToeGame
{
/*Explanation:
There are 8 ways to win for each player:

3 columns
3 rows
2 diagonals
Players make moves one by one so all odd moves are for player A, even for B.
Now we just need to track if we reach 3 in any line for any of the players.
One array keeps all ways to win for each player:

0,1,2 - for rows
3,4,5 - for cols
6 - for diagonal top left - bottom right
7 - for diagonal top right - bottom left
 */
	
	public static String ticTacToe(int[][] moves) 
	{
		int[] A = new int[8], B = new int[8];  // 3 rows, 3 cols, 2 diagonals
        for(int i=0;i<moves.length;i++)
        {
            int r=moves[i][0];
            int c=moves[i][1];
            int[] player = (i%2==0)?A:B;
            player[r]++;
            player[c+3]++;
            
            if(r==c)
            	player[6]++;
            if(r==2-c)
            	player[7]++;
        }
        
        for(int i=0;i<8;i++)
        {
            if(A[i]==3)
            	return "A";
            if(B[i]==3)
            	return "B";
        }
        return moves.length==9 ? "Draw":"Pending";
    }
	
	public static void main(String[] args)
	{
		int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
		System.out.println(ticTacToe(moves));
	}
}
