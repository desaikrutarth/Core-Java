package programs;

import java.util.Scanner;

public class SubArray 
{
	 public static void main(String[] args) 
	 {
		 int count =0;
		 
		 int arr[] = {1,-2,4,-5,1};
		 for (int i = 0; i < arr.length; i ++)
	     {
	         for (int j = i; j < arr.length; j ++)
	         {
	        	 int sum = 0;
	        	 sum = sum + arr[j];
	        	 if(sum < 0)
	        	 {
	        		 count++;
	        		 System.out.println(arr[i]+" + "+arr[j]+" count= "+count);
	        	 }
	         }
	      }
		 
	 }
}
