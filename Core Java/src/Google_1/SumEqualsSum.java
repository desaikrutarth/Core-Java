package Google_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) such that a+b = c+d, and elements of array are distinct.
 *  Print "1" if pair exists else print "0".
 *  Input:
		3 4 7 1 2 9 8    => (1+8) = (7+2)
		65 30 7 90 1 9 8
	Output:
		1
		0
 */
public class SumEqualsSum 
{
	boolean pairsOfSum(int[] arr)
	{
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				int sum = arr[i] + arr[j];
				if(set.contains(sum))
					return true;
				set.add(sum);
			}
		}
		return false;
	}
	
	/*boolean pairsOfSum(int[] arr)
	{
		int sum = 0;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				sum = arr[i] + arr[j];
				hmap.merge(sum, 1, Integer::sum);
			}
		}
		for(int val : hmap.keySet())
		{
			int count = hmap.get(val);
			if(count > 1)
				return true;
		}
		return false;
	}*/
	
	public static void main(String[] args)
	{
		System.out.println("Enter number of test");
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		while(tc-- > 0)
		{
			System.out.println("Enter array size");
			int size = s.nextInt();
			int[] arr = new int[size];
				
			for(int i=0; i<size; i++)
			{
				arr[i] = s.nextInt();
			}
			
			SumEqualsSum obj = new SumEqualsSum();
			boolean flag = obj.pairsOfSum(arr);
			if(flag)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
