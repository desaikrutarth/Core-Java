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
		if(sum[start] == 0)
			sum[start] = 1;
		else if(sum[start] == 1)
			sum[start] = 0;
		
		if(sum[end] == 0)
			sum[end] = 1;
		else if(sum[end] == 1)
			sum[end] = 0;
		System.out.println(Arrays.toString(sum));
	}

	private static boolean isOn(int num) 
	{
		for(int i=0; i<sum.length; i++)
		{
			if(num == i)
			{
				if(sum[num] == 1)
					return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isOn(0));
		toggle(0,1);
		System.out.println(isOn(0));
	}
}
