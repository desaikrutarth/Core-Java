package Google_3;

import java.util.Arrays;

/*
 
Given a sorted distinct array of integers and a key K. C closest elements to K are in range [L,R] inclusive,
L<=R. Return L as the left index of C closest elements to K. 
For example: 
A = [1, 2, 5, 8, 9, 13]. K = 8 and C = 4. The result L = 3 because 4 closest elements to 8 are [5, 8, 9, 13]
 
 */
public class FindKClosestNumber 
{
	 	private static void findRange(int[] arr, int key, int rangeSize)
	    {
	 	//	int index = Arrays.binarySearch(arr,key);	//Find index of key by binary search
	        int index = binarySearch(arr, key);
	        
	        int right = index + 1;
	        int left = index - 1;
	        System.out.print(arr[index] + "  ");
	        for (int i = 0; i < rangeSize - 1; ++i)
	        {
	            if (arr[index] - arr[left] > arr[right] - arr[index])
	            {
	                System.out.print(arr[right] + "  ");
	                ++right;
	            }
	            else
	            {
	                System.out.print(arr[left] + "  ");
	                --left;
	            }
	        }
	    }

	    private static int binarySearch(int[] arr, int key)
	    {
	        int low = 0;
	        int high = arr.length-1;
	        int mid = -1;
	        while (low <= high)
	        {
	            mid = (high + low) / 2;
	            if (arr[mid] == key)
	                break;
	            else if (arr[mid] < key)
	                low = mid + 1;
	            else
	                high = mid - 1;
	            
	        }
	        return mid;
	    }

	    
	    public static void main(String... a)
	    {
	        int[] arr = {1, 2, 5, 8, 9, 13};
	        int key = 8;
	        int rangeSize = 4;

	        findRange(arr, key, rangeSize);
	    }
}
