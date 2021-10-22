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
				if(list.contains(remaining) && arr[i] < arr[j] && arr[j] < remaining) // arr[i] < arr[j] < arr[k]
					System.out.println(arr[i]+ "+" + arr[j]+ "+" +remaining+ "=" +targetSum);
			}
		}
	}
	
	public static void main(String args[]) 
	 {
		 Integer[] arr = {1,2,3,4,5};
		 int sum = 9;
		 wrapText(arr, sum);
	        
	 }
}
