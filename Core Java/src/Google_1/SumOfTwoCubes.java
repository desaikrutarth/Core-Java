package Google_1;

import java.util.HashMap;
import java.util.Map.Entry;
/*
 * Let "t" be a good number if "t" can be written as sum of 2 cubes in at least 2 distinct ways.
 * Given n, write a method which prints all good numbers up to and including n.
 */
public class SumOfTwoCubes 
{

	static void printGoodNumbers (int n) 
	{
		  HashMap<Integer, Integer> sumCount = new HashMap<Integer, Integer>();
		  for (int x = 1; x*x*x <= n; x++)
		  {
		    for (int y = x; (x*x*x)+(y*y*y) <= n; y++)
		    {
		      int sum = (x*x*x)+(y*y*y);
		      sumCount.merge(sum, 1, Integer::sum);
		    }
		  }
		  
		  for(Entry<Integer, Integer> entry : sumCount.entrySet())
		  {
			  if (entry.getValue() >= 2)
				  System.out.println(entry.getKey());
		  }
	}
	
	public static void main(String [] args) 
	{

        printGoodNumbers(10000);

    }
}
