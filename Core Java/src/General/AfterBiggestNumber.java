package General;
import practice.Practice;
/*
 * How to find total number of greater number after all number in an array ? 
Eg. Given array is, 
5 3 9 8 2 6 
o/p 
3 3 0 0 1 0
 */
public class AfterBiggestNumber
{
	static int[] getNextBigCount(int [] input)
	{
		int l=input.length;
		int output[]=new int[l];
		for(int i=0;i<l;i++)
		{
			int c=input[i];
			int co=0;
			for(int j=i;j<l;j++)
			{
				if(input[j]>c){
					co++;
				}
			}
			output[i]=co;
		}
		return output;
		
	}
	public static void main(String args[])
	{
		int inp[]={5,3,9,8,2,6};
		int out[]=getNextBigCount(inp);
		for(int i:out){
			System.out.println(i);
		}
	}
}
