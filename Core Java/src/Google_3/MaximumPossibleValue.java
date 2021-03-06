package Google_3;

import java.util.ArrayList;

/*
 Your input is a double array, and you can use *, +, -, and () parenthesis anywhere to create and output the maximum possible value. 

Ex: 
input is {3,4,5,1} --> output: 72 
input is {1,1,1,5} --> output: 15 

Follow up, if there are numbers <0
 */
public class MaximumPossibleValue 
{
	
	public static int max (int[] arr)
	{
		ArrayList<Integer> list = new ArrayList<Integer> ();
		
		addNumbersReplaceOnes (arr, list);
		
		int result = 1;
		for (int num : list)
			result *= num;
		return result;
	}

	private static void addNumbersReplaceOnes(int[] arr, ArrayList<Integer> list)
	{
		int numOfOnes = 0;
		int min = Integer.MAX_VALUE;
		for (int n : arr)
		{			
			if (n == 1) 
				numOfOnes ++;
			else 
			{
				if (n < min)
					min = n;
				else 
					list.add(n);
			}
		}
		ArrayList<Integer> temp = new ArrayList<Integer> ();
		while (numOfOnes >= 2)
		{
			temp.add(2);
			numOfOnes--;
		}
		if (numOfOnes == 1)
		{
			if (temp.size() > 0)
				temp.set(0, 3);
			else 
				min++;
			
		}
		list.add(min);
		list.addAll(temp);
	}
	
	public static void main (String[] args)
	{
		int[] a = {1,1,1,5};
		System.out.println(max(a));
		
	}
}
