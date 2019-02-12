package Google_1;
import java.util.Arrays;

/*
 * Given a number "n", find the least number of perfect square numbers sum needed to get "n" 
	Example: 
	n=12, return 3 (4 + 4 + 4) = (2^2 + 2^2 + 2^2) NOT (3^2 + 1 + 1 + 1) 
	n = 6, return 3 (4 + 1 + 1) = (2^2 + 1^2 + 1^2)
 */
public class SquareNumberSum 
{
	int[] min;

	SquareNumberSum()
	{
		min = new int[13];
		Arrays.fill(min, Integer.MAX_VALUE);
	}
	public void findMin(int n)
	{
		min[0] = 0;
		for(int i=1 ; i<=n ; i++)
		{
			for(int j=1 ; j*j<=i ; j++)
			{
				min[i] = Math.min(min[i], min[i - j*j] + 1);
			}
		}
		System.out.println("Min Value: " + min[n]);
	}

	public static void main(String[] args)
	{
		SquareNumberSum obj = new SquareNumberSum();
		int n =6;
		obj.findMin(n);
		
	}
}
