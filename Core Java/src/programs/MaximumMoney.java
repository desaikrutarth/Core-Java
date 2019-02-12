package programs;

import java.util.Scanner;

/*
 * Given street of houses (a row of houses), each house having some amount of money kept inside; 
 * now there is a thief who is going to steal this money but he has a constraint/rule that he cannot steal/rob two adjacent houses. 
 * Find the maximum money he can rob.
 * Input:
	5 10
   Output:
	30
 */
public class MaximumMoney 
{	
	public static void main(String[] args)
	{
		System.out.println("Enter number of test");
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		while(tc-- > 0)
		{
			System.out.println("Enter array size");
			int size = scan.nextInt();
			int[] arr = new int[size];
			System.out.println("Enter any number");	
			int num = scan.nextInt();
			for(int i=0; i<size; i++)
			{
				arr[i] = num;
			}
			
			int sum =0;
			for(int i =0; i<arr.length; i = i+2)
			{
				sum += arr[i];
			}
			System.out.println(sum);
		}
	}
}
