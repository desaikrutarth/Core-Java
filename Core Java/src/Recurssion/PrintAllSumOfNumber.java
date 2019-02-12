package Recurssion;
/*
Print all the different possible subsets suming the given number 
Ex: 
	Input:4 
	Output: 
		1111
		112
		121
		13
		211
		22
		31
		4
 */
public class PrintAllSumOfNumber
{
	public static void printSubset(int n, String s)
	{
		if(n == 0)
			System.out.println(s);
		
		for(int i=1; i<=n; i++)
		{
			printSubset( n-i, s + i);
		}
	}
	
	public static void main(String[] args)
	{
		printSubset(4, "");
	}
}
