package programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Given an unsorted array Arr[] and a number N.
 * You need to write a program to find if there exists a pair of elements in the array whose difference is N.
 * Input:
	 78
	 5 20 3 2 5 80
	 45
	 90 70 20 80 50
   Output:
	 1
	-1
 */
public class FindDifferenceK 
{
	boolean isFindDiff(int[] arr, int k)
	{
		int left = 0;
		int right = arr.length-1;
		
		Arrays.sort(arr);
		while(left < right)
		{
			if(arr[right] - arr[left] == k)
				return true;
			else if(arr[right] - arr[left] > k)
				left++;
			else
				right--;
		}
		return false;
	}
	
	public static void main (String[] args) 
	{
		System.out.println("Enter Test cases");
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0)
		{
		    System.out.println("Enter array size");
		    int size = sc.nextInt();
		    System.out.println("Enter value to find difference");
		    int diff = sc.nextInt();		
		    int arr[] = new int[size];
		    System.out.println("Enter array elements");
		    for(int i = 0 ; i < size ; i++)
		    	arr[i] = sc.nextInt();
		    
		    FindDifferenceK obj = new FindDifferenceK();
		    boolean flag = obj.isFindDiff(arr,diff);
		    if(flag == true)
		    	System.out.println(1);
		    else
		    	System.out.println(-1);
 		}
	}
}
