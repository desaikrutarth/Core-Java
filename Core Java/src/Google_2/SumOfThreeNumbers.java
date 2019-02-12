package Google_2;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array, find the number of tuple such that A [i] + A [j] + A [k] = A [l] in an array, where i <j <k <l.
 */
public class SumOfThreeNumbers 
{
	static void wrapText(Integer[] arr, int targetSum)
	{
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				int remaining = Math.abs((arr[i] + arr[j]) - targetSum);
				if(list.contains(remaining))
					System.out.println(arr[i]+ "+" + arr[j]+ "+" +remaining+ "=" +targetSum);
			}
		}
	}
	
	/*static void wrapText(int[] arr, int targetSum)
	{
		int i=0, j=0, k=0;
		while(i<arr.length && j<arr.length && k<arr.length)
		{
			int sum = arr[i] + arr[j] + arr[k];
			if(sum == targetSum)
			{
				if(arr[i] < arr[j] && arr[j] < arr[k] && arr[k] < targetSum)
					System.out.println(arr[i]+" + "+ arr[j]+" + "+arr[k]+" = "+targetSum);
			}			
			
			if(k == arr.length-1)
			{
				j++;
				k=0;
				
				if(j == arr.length)
				{
					i++;
					j=0;
				}
			}
			else
				k++;
				
		}
	}*/
	
	public static void main(String args[]) 
	 {
		 Integer[] arr = {1,2,3,4,5};
		 int sum = 9;
		 wrapText(arr, sum);
	        
	 }
}
