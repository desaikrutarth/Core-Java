package Google_2;

import java.util.Scanner;

/*
 * Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
 * Input:
		1
		3
   Output:	
		3
		19
 */
public class CountOfStrings
{
	public static void main (String[] args)
	{
	  System.out.println("Enter number of test cases");
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  System.out.println("Enter the length of string");
	  while(t>0)
	  {
	      int n=sc.nextInt();
	      int n1=(n*(n*n+3))/2;
	      System.out.println(n1+1);
	      t--;
	  }
	}
}
