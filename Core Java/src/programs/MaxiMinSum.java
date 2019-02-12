package programs;

import java.util.Scanner;

public class MaxiMinSum
{
	public static void main(String[] args) 
    {
        int arr[] = new int[5];
        int max[] = new int[5];
        int min[] = new int[5];
        int sumMax = 0;
        int sumMin = 0;
        int i=0, j=1, k=0;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter five numbers");
        for(int x=0; x<arr.length; x++)
        {
            arr[x] = s.nextInt();    
        }
        
        for(i=0; i<arr.length-1; i++)
        {
        	for(j=0; j<arr.length-1; j++)
        	{
        		if(arr[i] < arr[j])
        		{
        			max[k] = arr[i];
        			i++;
        			k++;
        		//	System.out.println("max="+max[k]);
        		}
        		else
        		{
        			System.out.println("arr[j]="+arr[j]);
        			min[k] = arr[j];
        			j++;
        			k++;
        		//	System.out.println("min="+min[k]);
        		}
            sumMax = sumMax + max[k];
            sumMin = sumMin + min[k];
        	}
        }
        System.out.println("sumMax = "+sumMax);
        System.out.println("sumMin = "+sumMin);
        
        
    }
}
