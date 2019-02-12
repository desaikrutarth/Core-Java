package Google_2;
/*
 * Print all numbers satisfying the expression 2^i * 5^j (where i, j are integers i >= 0 and j >= 0) in increasing order up to a given bound N. 
	2^i stands for power(2, i).
 */
public class PowerOfNumbers 
{
	static void power(int num)
	{
		for(int i=0; i < num; i++)
		{
			for(int j=0; j < num; j++)
			{
				if(Math.pow(2, i) * Math.pow(5, j) < num)
				{
					double result = Math.pow(2, i) * Math.pow(5, j);
					System.out.println(result);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		power(100);
	}
}
