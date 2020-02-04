package Sorting;
import java.util.*;
public class BubbleSort
{
	public static void main(String[] args)
	{
		int i,j,temp;
		Scanner s = new Scanner (System.in);
		int a[]=new int[5];
		
		System.out.println("Enter the value");
		
		for(i=0; i<a.length; i++)
		{
			a[i] = s.nextInt();
		}
		
		
		for( i=0; i<a.length-1; i++)
		{
			for(j=0; j<a.length-1; j++)
			{
				if(a[j] > a[j+1])
				{
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println("ordered number are: ");
		for(i=0; i<a.length; i++)	
		{
			System.out.println("\n"+a[i]);
		}
		
	}
}
