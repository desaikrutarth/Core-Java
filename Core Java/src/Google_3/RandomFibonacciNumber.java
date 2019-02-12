package Google_3;

import java.util.ArrayList;
import java.util.Random;

public class RandomFibonacciNumber
{
	static int getNumber(int min, int max)
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
	}
	
	public static void main(String[] args)
	{		
		System.out.println("Random = "+getNumber(100,1000));
	}
}
