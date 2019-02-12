package Google_3;

import java.util.HashMap;
/*
 * Given a method 
public int getOccurence(int x,int y); 
where y is always a single digit number. 

So find the number of occurrences of number y in the range x 
E.g. 
if x=25,y=2 
function should return 9(as 22 contains two occurrences of 2) - 2,12,20,21,22,23,24,25
 */
public class GetOccureneOfNumber 
{	
	static int getOccurence(int x,int y)
	{
		int count = 0;
		for(int i=y; i<=x; i++)
		{
			String s = String.valueOf(i);
			if(s.contains(String.valueOf(y)))
			{
				StringBuilder sb = new StringBuilder(s);
				if(sb.reverse().toString().equals(s))
					count += s.length();
				else
					count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args)
	{
		int x = 25;
		int y = 2;
		System.out.println(getOccurence(x, y));
	}
}
