package Google_3;

import java.util.Arrays;

/*
For N light bulbs, implement two methods 
I. isOn(int i) - find if the ith bulb is on or off. 
II. toggle(int start, int end)
 */
public class CheckBulbON
{
	static int[] sum = {0,1,0,0,0};
	 
	private static void toggle(int start, int end)
	{
		for(int i=start; i <= end; i++)
		{
			if(sum[i] == 1)
				sum[i] = 0;
			else
				sum[i] = 1;
		}
		System.out.println(Arrays.toString(sum));
	}

	private static boolean isOn(int num) 
	{
		if(sum[num] == 1)
			return true;
		
		return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isOn(3));
		toggle(0,4);
		System.out.println(isOn(3));
	}
}
