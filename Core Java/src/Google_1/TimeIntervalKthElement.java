package Google_1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/* Given a set of intervals like 5-10, 15-20, 25-40, 30-45, 50-100.
 * Find the ith smallest number in these intervals. Assume there are no duplicate numbers.
e.g:  1st smallest number = 5	 
 6th smallest number = 10	
7th smallest number = 15 and so on. 
*/

public class TimeIntervalKthElement 
{
	public void TimeInterval(int k)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int count=0;
		
		for(int i=5; i<=10; i++)
			map.put(++count, i);
		
		for(int i=15; i<=20; i++)
			map.put(++count, i);
		
		for(int i=25; i<=40; i++)
			map.put(++count, i);
		
		for(int i=30; i<=45; i++)
			map.put(++count, i);
		
		for(int i=50; i<=100; i++)
			map.put(++count, i);
		
		int result = map.get(k);
		System.out.println(k+ "th element is = "+result);
	}
	
	public static void main(String[] args)
	{
		TimeIntervalKthElement time = new TimeIntervalKthElement();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter value of k to search element");
		int k = in.nextInt();		
		time.TimeInterval(k);
	}
}
