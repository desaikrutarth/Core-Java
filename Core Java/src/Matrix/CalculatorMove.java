package Matrix;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 Write all the possible numbers returned from a calculator pad where a start number move in a L direction in any directions(1-2moves) 

ie. From calculator pad. Start from 8 --> go in L shape (2up, 1right), and it returns 3 
ie. Start from 2, (move 2 down, 1 left), it will be 7 
ie. Start from 2(move 2 down, 1 right), it will be 9 
ie. Start from 7(move 1 left, 2 up), it will be 2 
ie. Start from 7(move 1 up, 2 left), it will be 6

 	|1,2,3|
 *  |4,5,6|
 *  |7,8,9|
 *  |0|
 */
public class CalculatorMove
{
	static int[][] calculator= {{1,2,3},
								{4,5,6},
								{7,8,9},
								{0}};
	static int[][] LMove= {{-1,-2},
						   {-1,2},
						   {1,2},
						   {1,-2},
						   {-2,-1},
						   {-2,1},
						   {2,-1},
						   {2,1}};
	
	
	
	static int getNumberByXY(int x, int y)
	{
		try
		{
			if ((x==3)&&(y<0)&&(y>3))
				return 0;
			if ((x<0)&&(x>4))
				return -1;
			if ((y<0)&&(y>3))
				return -1;
			return calculator[x][y];
		}
		catch(Exception e) {
			return -1;
		}

	}
	
	public static int[] getXYByNumber(int number)
	{
		int[] returnArray = new int[2];
		if (number==0)
		{
			returnArray[0]=3;
			returnArray[1]=0;
			return returnArray;
		}
		for (int i=0; i <3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if (calculator[i][j]==number)
				{

					returnArray[0]=i;
					returnArray[1]=j;
					break;
				}
			}
		}
		return returnArray;
	}
	
	static void inputNumber(int num)
	{
		Set<Integer> set = new HashSet<>();
		int[] xy=getXYByNumber(num);
		for (int[] move : LMove)
		{
			int x=xy[0]+move[0];
			int y=xy[1]+move[1];
			if (getNumberByXY(x,y)!=-1)
			{
				set.add(getNumberByXY(x,y));
			}
		}
		
		for(int item: set)
			System.out.println("Input ["+num+"] = "+item);
	}
	
	
	public static void main(String[] args)
	{
		inputNumber(1);
		inputNumber(2);
		inputNumber(3);
		inputNumber(4);
		inputNumber(5);
		inputNumber(6);
		inputNumber(7);
		inputNumber(8);
		inputNumber(9);
		inputNumber(0);
	}
}
