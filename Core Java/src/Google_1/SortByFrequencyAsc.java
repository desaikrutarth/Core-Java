package Google_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/*
 * Explanation:
For 1st test case:
arr[] = 5 2 1 3 2
Firstly their was 5 whose frequency is max till now. so print 5.
Then 2 , which is smaller than 5 but their frequency is same so print 2 5.
Then 1, Which is smallet among all the number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5
Then again 2, which has the highest frequency among all number so 2 1 3 5.

For 2nd test case:
arr[] = 5 2 1 3 4
Firstly their was 5 whose frequency is max till now. so print 5.
Then 2 , which is smaller than 5 but their frequency is same so print 2 5.
Then 1, Which is smallest among all the number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5.
Then 4, so 1 2 3 4 as K is 4 so print at-most k elements.
 */

public class SortByFrequencyAsc
{
	

	private static void sortByFrequency(Integer[] arr)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int m : arr) {
			map.put(m, map.getOrDefault(m, 0) + 1);
		}

		Integer[] newArr = new Integer[map.size()];
		int idx=0;
		for(int key: map.keySet())
			newArr[idx++]=key;
		
		//Sort with Comparator
		Arrays.sort(newArr, (a, b) -> {
			int fa = map.get(a);
			int fb = map.get(b);

			if (fa > fb)
				return -1; // return negative value means put a before b, for compare the frequency
			if (fa < fb)
				return 1; // return positive value means put a after b, for compare the frequency
			return a - b; // otherwise, if the 2 elements has the same frequency, put them according to ascending order, If it returns negative then it will be ascending else descending
		});
		
		System.out.println(Arrays.toString(newArr));
		
//		Arrays.sort(newArr, new Comparator<Integer>(){
//			@Override
//			public int compare(Integer a, Integer b) {
//				int fa = map.get(a);
//				int fb = map.get(b);
//				
//				if (fa > fb)
//					return -1;
//				if(fa < fb)
//					return 1;
//				return a - b;
//			}
//		});	
	}
	/*private static void sortByFrequency(Integer[] arr)
	{
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		LinkedList<Integer> resultList = new LinkedList<>();
		int maxFrequency = 1;
		
		for(int i=0; i<arr.length; i++)
			tmap.merge(arr[i], 1, Integer::sum);
		
		for(int key : tmap.keySet())
		{
			int frequency = tmap.get(key);
			if(frequency > maxFrequency)
			{
				maxFrequency = frequency;
				resultList.addFirst(key);
			}
			else
				resultList.addLast(key);
		}
		System.out.println(resultList);
	}*/
	
	public static void main(String[] args)
	{
		Integer[] arr = {5,2,1,3,2,5,1};
		sortByFrequency(arr);
		
	}		
}
