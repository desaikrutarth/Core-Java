package Recurssion;
/*
 * F (n) = 3n + 1 (if n is odd) or n / 2 (if n is even) 
Collapse sequence refers to each number according to this formula 
until the sequence becomes equal to 1, 
Find the number (which is not greater than 10000), which will have the longest Collapse sequence. 

public int getlongestCollapsesequence(int n){ 

}
 */
public class CreateSequence
{
	static int count =0;
	public static int getlongestCollapsesequence(int n)
	{ 
		 System.out.print(n + " ");
		 if(n==1) 
		 {
			 System.out.println();
			 return count;
		 }
		 
		 if(n%2 == 0)
		 {
			 count++;
			 return getlongestCollapsesequence(n/2);
		 }		 
		 else 
		 {
			 count++;
			 return getlongestCollapsesequence(3*n+1);
		 }	 
	 }
	
	public static void main(String[] args)
	{
		System.out.println("count = "+getlongestCollapsesequence(100));
	}
}
