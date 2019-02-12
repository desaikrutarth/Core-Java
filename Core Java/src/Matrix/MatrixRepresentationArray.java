package Matrix;

import java.util.ArrayList;
/*
 An n * m matrix represents an array of computers, giving you a List <int []> that represents the coordinates of the broken computer. 
Now we start from (0,0) repair computer requirements: 
1. You must finish all the broken computers in the current line to get to the next line 
2. To go to the next line, the mechanic must first return to the far left or right of this line 
And then find repair each computer order that has the minimum access distance,
 */
public class MatrixRepresentationArray
{
	public static int getLessAmountOfStepsToFindBrokenComputers(int[][] room, ArrayList<int[]> coordinatesBrokenComputers)
	{
        int steps = 0;
        int sizeOfBrokenComputers = coordinatesBrokenComputers.size();
        for (int i = 0; i < room.length; i++)
        {
            if (i % 2 == 0)
            {
                for (int j = 0; j < room[i].length; j++)
                {
                    steps++;
                    if (room[i][j] == 0) 
                    {
                        sizeOfBrokenComputers--;
                        if (sizeOfBrokenComputers == 0) {
                            return steps;
                        }
                    }
                }
            }
            else
            {
                for (int j = room[i].length - 1; j >= 0; j--)
                {
                    steps++;
                    if (room[i][j] == 0) 
                    {
                        sizeOfBrokenComputers--;
                        if (sizeOfBrokenComputers == 0) {
                            return steps;
                        }
                    }
                }
            }
        }

        return steps;
    }
	
	public static void main(String[] args)
	{
		ArrayList<int[]> coordinatesBrokenComputers = new ArrayList<>();
        coordinatesBrokenComputers.add(new int[]{1,1});
        coordinatesBrokenComputers.add(new int[]{1,4});
        coordinatesBrokenComputers.add(new int[]{2,2});
        coordinatesBrokenComputers.add(new int[]{3,4});

        int[][] room = new int[][]{
                {1,1,1,1,1},
                {1,0,1,1,0},
                {1,1,0,1,1},
                {1,1,1,1,0},
                {1,1,1,1,1}
        };
        
        System.out.println(getLessAmountOfStepsToFindBrokenComputers(room, coordinatesBrokenComputers));
	}
}
