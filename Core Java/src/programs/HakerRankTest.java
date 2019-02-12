package programs;

import java.util.Scanner;

public class HakerRankTest
{
	static void finalPrice()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size:");
		int size = in.nextInt();
		int sum = 0;

		int arr[] = new int[size];
		for(int i=0; i < size; i++)
			arr[i] = in.nextInt();
			
		for(int i=0; i<arr.length-1; i++)
		{
			if(arr[i] < arr[i+1])
			{
				sum += arr[i] - 0;
				System.out.println("Items without discount:"+i);
				
				if(i == arr.length-2)
				{
					sum += arr[i+1] - 0;
					System.out.println("Items without discount:"+(i+1));
				}
			}
				
			else
				sum += arr[i] - arr[i+1];

		}
		System.out.println("Sum = "+sum);
			
	}
	
	public static void main(String[] args)
	{
		HakerRankTest.finalPrice();
	}
}
