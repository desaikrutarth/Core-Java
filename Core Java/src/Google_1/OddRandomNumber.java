package Google_1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*write a function that randomly return only odd number in range [min, max] */

public class OddRandomNumber
{
	public static int randOddInt(int min, int max)
	{
	    if (min % 2 == 0)
	    	++min;
	  //  int rand = min + 2*(int)(Math.random() * ((max - min)/2 + 1));
	  //  int rand = min + 2*ThreadLocalRandom.current().nextInt((max-min)/2+1);
	    int rand = min + 2*new Random().nextInt((max-min)/2+1);
	    return rand;
	}
	
	public static int randEvenInt(int min, int max) 
	{
	   // if (min % 2 != 0)
	   // 	++min;
	    return 2*ThreadLocalRandom.current().nextInt((max-min)/2+1);
	}
	
	public static void main(String[] args)
	{
		System.out.println("Odd Random Numbers= "+randOddInt(0, 10));
		System.out.println("Even Random Numbers = "+randEvenInt(0, 10));
	}
}
