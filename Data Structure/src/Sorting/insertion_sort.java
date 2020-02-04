package Sorting;
import java.util.*;

class insertion_sort
{
    public static void main(String[] args)
    { 
	int i,j,n,temp;
	Scanner s = new Scanner (System.in);
	System.out.println("enter array size");
	n=s.nextInt();
	int a[] = new int[n];
	
	System.out.println("Enter any values");
	for(i=0 ; i<n; i++)
	{
		a[i] = s.nextInt();
	}
	for(i=1; i<n; i++)
	{
		temp = a[i];
		j = i-1;
		while( j>=0 && temp < a[j])
		{			
			a[j+1] = a[j];
			j--;
		}
		a[j+1] = temp;
	}
	System.out.println("sorted list");
	for(i=0; i<n; i++)
	{
		System.out.println(a[i]);
	}
       }
}  
	