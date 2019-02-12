package Google_1;

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
		int[] arr5to10 = new int[6];
		int[] arr15to20 = new int[6];
		int[] arr25to40 = new int[16];
		int[] arr30to45 = new int[16];
		int[] arr50to100 = new int[51];
		
		int index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0;
		
		LinkedHashMap<Integer, Integer> hmap = new LinkedHashMap<Integer, Integer>();
		int key = 0;
		
		for(int i = 5 ; i <= 10; i++)
		{
			key = i;
			arr5to10[index1] = i;
			hmap.put(key, arr5to10[index1]);
			index1++;
			key++;
		}			
					
		for(int i = 15 ; i <= 20; i++)
		{
			arr15to20[index2] = i;
			hmap.put(key, arr15to20[index2]);
			key++;
			index2++;
		}			
		
		for(int i = 25 ; i <= 40; i++)
		{
			arr25to40[index3] = i;
			hmap.put(key, arr25to40[index3]);
			key++;
			index3++;
		}
					
		for(int i = 30 ; i <= 45; i++)
		{
			arr30to45[index4] = i;
			hmap.put(key, arr30to45[index4]);
			key++;
			index4++;
		}			
		
		for(int i = 50 ; i <= 100; i++)
		{
			arr50to100[index5] = i;
			hmap.put(key, arr50to100[index5]);
			key++;
			index5++;
		}
		
		int num = 0;
		
		if(hmap.containsKey(k))
		{
			int val = hmap.get(k);
			num = val;
		}
		
		System.out.println(k+ "th element is ="+num);

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
