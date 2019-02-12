package Google_1;

import java.util.ArrayList;
import java.util.Collections;

/*
 * You have two sorted lists A and B, find the kth smallest sum. 
 * Where sum is defined as x+y such that x belongs to list A and y belongs to list B. 
	For e.g, if A=[1,2,3] B=[4,5,6], the list of possible sums are [5,6,6,7,7,7,8,8,9], and hence the 5th smallest sum is 7.
 */

public class KthSmallestSumGoogle 
{
	static void smallestSum(int[] arr1, int[] arr2, int k)
	{
		int i=0;
		int j=0;
		ArrayList<Integer> list = new ArrayList<>();
		int sum=0;
		while(i<arr1.length && j<arr2.length)
		{
			sum = arr1[i] + arr2[j];
			list.add(sum);
			
			if(j == arr2.length-1)
			{
				i++;
				j=0;
			}
			else
				j++;
		}
		Collections.sort(list);
		
		int count =1;
		for(int val : list)
		{
			count++;
			if(k == count)
				System.out.println(k+"th smallest sum ="+val);
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr1 = {1,2,3};
		int[] arr2 = {4,5,6};
		int k=5;
		
		smallestSum(arr1, arr2 ,k);
	}
}
