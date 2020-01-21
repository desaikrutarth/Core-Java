package Google_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
Given a sorted distinct array of integers and a key K. C closest elements to K are in range [L,R] inclusive,
L<=R. Return L as the left index of C closest elements to K. 
For example: 
A = [1, 2, 5, 8, 9, 13]. K = 8 and C = 4. The result L = 3 because 4 closest elements to 8 are [5, 8, 9, 13]
 
 */
public class FindKClosestNumber 
{
	private static List<Integer> findRange(int[] arr, int key, int rangeSize)
    {
		List<Integer> list = new ArrayList<>();
		int index = Arrays.binarySearch(arr, key);
		int left = index-1;
		int right = index+1;
		
		list.add(key);
		
		for(int i=0; i<rangeSize-1 && right<arr.length && left>=0 ; i++)
		{
			if(arr[index]-arr[left] < arr[right]-arr[index])
			{
				list.add(arr[left]);
				left--;
			}
			else
			{
				list.add(arr[right]);
				right++;
			}
		}
		return list;
    }
	    
	public static void main(String... a)
	{
		int[] arr = {1, 2, 5, 8, 9, 13};
	    int K = 8;
	    int C = 4;

	    System.out.println(findRange(arr, K, C));
	}
}
