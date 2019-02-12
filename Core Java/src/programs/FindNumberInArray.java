package programs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FindNumberInArray 
{	
	public static String Search()
	{
		System.out.println("Enter array size");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int [n];

        boolean flag = false;
        for(int i=0; i<n; i++)
        {
            arr[i] = s.nextInt();
        }
        System.out.println("Enter number for search");
        int k = s.nextInt();
        for(int i=0; i<n; i++)
        { 
            if(arr[i] == k)
            	flag = true;
        }
        if(flag == true)
        	return "Yes";
        else
        	return "No";
	}
	
	public static void main(String[] args) 
    {
		String str = FindNumberInArray.Search();
		System.out.println(str);
    }
}
