package Google_3;

import java.util.ArrayList;
import java.util.Random;

public class RandomFibonacciNumber
{
	static int getNumber(int min, int max)
	{
		ArrayList<Integer> fiboList = new ArrayList<>();
		int[] fibo = new int[max];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for(int i=2; i<= max; i++)
		{
			fibo[i] = fibo[i-1] + fibo[i-2];
			
			if(fibo[i] >= min && fibo[i] <= max)
				fiboList.add(fibo[i]);
			
			if(fibo[i] > max)
				break;
		}
		System.out.println(fiboList);
		int random = fiboList.get(new Random().nextInt(fiboList.size()));
		
		return random;
	}
	
	/*static int getNumber(int min, int max)
	{
		ArrayList<Integer> fiboList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		
		for(int i=2; i<max; i++)
		{
			int fibo = list.get(i-1) + list.get(i-2);
			list.add(fibo);
			if(fibo >= min && fibo <= max)
			{
				fiboList.add(fibo);
			}
		}
		System.out.println(fiboList);
		
		int rand = fiboList.get(new Random().nextInt(fiboList.size())); 	//Generate random number from the list
		return rand;
	}*/
	
	public static void main(String[] args)
	{		
		System.out.println("Random = "+getNumber(100,1000));
	}
}
