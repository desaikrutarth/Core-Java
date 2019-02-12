package programs;

import java.util.Arrays;
import java.util.Scanner;

public class FindKLargestElement
{
	public void FindElements(int[] arr, int k)
	{
		Arrays.sort(arr);
		for(int i =0; i < arr.length; i++)
		{
			if( k == i+1)
			{
				System.out.println(k+" largest Element is = " + arr[i]);
			}
		}
	}
	
	public static void main(String[] args)
	{
		FindKLargestElement obj = new FindKLargestElement();
		int arr[] = {10, 15 ,5 ,3 ,2 ,20};
		Scanner in = new Scanner(System.in);
		System.out.println("Enter value of k:");
		int k = in.nextInt();
		obj.FindElements(arr, k);
		
	}
}
