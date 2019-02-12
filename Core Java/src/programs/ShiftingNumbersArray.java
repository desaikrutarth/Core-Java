package programs;

import java.util.Scanner;
/*
 * Given the array of 0's and 1's. Move all the 1's on the left and move all the 0's on the right side of array
 * Input: 0 1 0 1 0
 * Output: 0 0 0 1 1 
 */
public class ShiftingNumbersArray
{
	void shiftNumbers(int[] arr)
	{
		int[] newArray = new int[arr.length];
		int index = 0;
	
		for(int i=0; i<arr.length; i++)
		{			
			if(arr[i] == 0)
			{
				newArray[index++] = arr[i];
			}
		}
		
		for(int i=0; i<arr.length; i++)
		{			
			if(arr[i] == 1)
			{
				newArray[index++] = arr[i];
			}
		}

		for(int i =0; i<newArray.length; i++)
			System.out.println(newArray[i]);
		
	}
	
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
 
			for(int i=0; i<size; i++)
			{
				arr[i] = scan.nextInt();
			}
			ShiftingNumbersArray obj = new ShiftingNumbersArray();
			obj.shiftNumbers(arr);
		}
	}
}
