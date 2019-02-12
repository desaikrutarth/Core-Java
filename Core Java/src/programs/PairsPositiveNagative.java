package programs;

import java.util.*;

/*
 * Given an array of distinct integers, print all the pairs having positive value and negative value of a number that exists in the array.
 * input: 	4 8 9 -4 1 -1 -8 -9
 * output: -1 1 -4 4 -8 8 -9 9
 */
public class PairsPositiveNagative
{
	List<Integer> isValidPair(int[] arr)
	{
		List<Integer> list = new ArrayList<>();
		int i=0;
		int j=i+1;
		
		while(i < arr.length && j < arr.length)
		{
			int sum = arr[i] + arr[j];
			if(sum == 0)
			{
				list.add(arr[i]);
				list.add(arr[j]);
			}
			
			if(j == arr.length-1)
			{
				i++;
				j=i+1;
			}
			else
				j++;
		}
		return list;
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
			PairsPositiveNagative obj = new PairsPositiveNagative();
			List<Integer> list = obj.isValidPair(arr);
			for(int item : list)
				System.out.println(item);
		}
		
	}
}
