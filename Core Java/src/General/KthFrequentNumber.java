package General;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Find the Kth most Frequent Number in an Array. 

Example:

arr[] = {1, 2, 3, 2, 1, 2, 2, 2, 3}
k = 2
Result: 3

Because '3' is the second most occurring element.
Follow up: What if the array is extremely large?
 */
public class KthFrequentNumber 
{
	static void findNumber(int[] arr, int k)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		Arrays.stream(arr).forEach(key -> map.merge(key, 1, Integer::sum));
		
		for(int key : map.keySet())
		{
			if(map.get(key) == k)
				System.out.println(key);
		}
		
	}
	
	public static void main(String[] args)
	{
		int arr[] = {1, 2, 3, 2, 1, 2, 2, 2, 3};
		int k = 2;
		findNumber(arr, k);
	}
}
