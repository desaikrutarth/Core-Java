package Sorting;

import java.util.*;
class selection_sort
{
	public static void main(String[] args)
	{
		int i, j, n, temp;
		Scanner s = new Scanner(System.in);
		System.out.println("enter the size of array");
		n = s.nextInt();
		int a[] = new int[n];
		
		System.out.println("enter values");
		for(i=0; i<n; i++)
		{
			a[i] = s.nextInt();
		}
		for(i=0; i<n; i++)
		{
			for(j = i+1; j<n; j++)
			{
				if(a[i] > a[j])
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("ordered list");
		for(i=0; i<n; i++)
		{
			System.out.println(a[i]);
		}
	}
}