package Google_3;

import java.util.Arrays;
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
			String str = String.valueOf(i);
			for(char ch: str.toCharArray())
			{
				if(ch == Character.forDigit(y, 10))		//Character.forDigit(char,10) converts int to char
					count++;
			}
		}
		return count;
	}
	
	/*static int getOccurence(int x,int y)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=y; i<=x; i++)
		{
			char[] charArr = String.valueOf(i).toCharArray();
			for(char ch : charArr)
			{
				if(ch == '2')
					map.merge(ch, 1, Integer::sum);
			}
		}
		return map.get(Character.forDigit(y, 10));		//Character.forDigit(char,10) converts int to char
	}*/
	
	public static void main(String[] args)
	{
		int x = 125;
		int y = 2;
		System.out.println(getOccurence(x, y));
	}
}
