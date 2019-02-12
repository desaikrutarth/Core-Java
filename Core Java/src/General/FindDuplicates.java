package General;
/*
write a function that finds substrings that contains only consecutive repeating characters
and return a list of characters that form the substrings.
For example,
 	input "thiisiissaa", returns i i s a
 	input "thiiissisa" returns i,s
 	input "abcde" returns a b c d e.
 */

public class FindDuplicates 
{
	static void findPlace(String str)
	{
		char[] arr = str.toCharArray();
		boolean flag = true;
		
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] == arr[i-1])
			{
				if(flag)
				{
					System.out.println(arr[i]);
					flag = false;
				}					
			}
			else
				flag = true;
		}
	}
	 
	public static void main(String[] args)
	{
		findPlace("thiiisssisaa");
	}
}
