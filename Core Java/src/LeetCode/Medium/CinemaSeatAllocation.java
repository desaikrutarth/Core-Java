package LeetCode.Medium;

/*
A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure.
	1 2 3	4 5 6 7	  8 9 10
1	- - -   - - - -   - - -
2   - - -   - - - -   - - -
n   - - -   - - - -   - - -
Given the array reservedSeats containing the numbers of seats already reserved,
for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is already reserved.

Return the maximum number of four-person groups you can assign on the cinema seats.
A four-person group occupies four adjacent seats in one single row.
Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent,
but there is an exceptional case on which an aisle split a four-person group, 
in that case, the aisle split a four-person group in the middle, which means to have two people on each side.
 
Example 1:
	1 2 3	4 5 6 7	  8 9 10
1	- X X   - - - -   X - -
2   - - -   - - - X   - - -
3   X - -   - - - -   - - X


Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
Output: 4 (1st row seats: 4,5,6,7 
		   2nd row seats: 2,3,4,5
		   3rd row seats: 2,3,4,5 and 6,7,8,9
Explanation: The figure above shows the optimal allocation for four groups,
where seats mark with blue are already reserved and contiguous seats mark with orange are for one group.

Example 2:

Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
Output: 2
Example 3:

Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
Output: 4
 */
public class CinemaSeatAllocation
{
	public static int maxNumberOfFamilies(int n, int[][] reservedSeats)
	{
		if(n < 0 || reservedSeats == null)
            return 0;
		
		int cols = 10;
		char[][] theater = new char[n][cols];
		int count = 0;
		
		for(int[] reserved : reservedSeats)
		{
			int i = reserved[0];
			int j = reserved[1];
			theater[i-1][j-1] = 'X';
		}
		
		for(int i=0; i<n; i++)
		{
			for(int j=1; j<6; j++)
			{
				if(theater[i][j] != 'X' && j!=2)
				{
					if(isEmptySeat(i,j,theater,j+4))
						count++;
				}
			}
		}
		return count;
	}
	 
	private static boolean isEmptySeat(int rowIndex, int colIndex, char[][] theater, int len)
	{
		if(colIndex == len)
			return true;
		
		if(theater[rowIndex][colIndex] == 'X')
			return false;
		
		theater[rowIndex][colIndex] = 'X';
		
		boolean result = isEmptySeat(rowIndex, colIndex+1, theater, len);
		
		if(!result)
			theater[rowIndex][colIndex] = ' '; // Backtrack
		
		return result;
	}

	public static void main(String[] args)
	{
		int[][] reservedSeats = {{2,10},{3,1},{1,2},{2,2},{3,5},{4,1},{4,9},{2,7}};
		System.out.println(maxNumberOfFamilies(4, reservedSeats));
	}
}
