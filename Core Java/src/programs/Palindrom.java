package programs;

import java.util.Scanner;

public class Palindrom 
{

	public static void main(String[] args)
	{
		System.out.println("Enter array size");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		String[] StringArray = new String[size];
		for(int i =0 ; i < size; i++)
		{
			Scanner scan = new Scanner(System.in);
			StringArray[i] = scan.nextLine();
		}
		
		for(int i=0; i<StringArray.length; i++)
		{
			char ch[] = StringArray[i].toLowerCase().toCharArray();
			boolean isPalindrome = false;
			int left=0;
			int right = ch.length-1;
		
			while(left < right)
			{
				if(ch[i]==',' || ch[i]==':'|| ch[i]=='?'|| ch[i]=='/')
					continue;
				if(ch[left] == ch[right])
				{
					isPalindrome = true;
				}
				left++;
				right--;
			}
			if(isPalindrome)
			{
				System.out.println("No is palindrome");
			}
			else
			{
				System.out.println("No is not palindrome");
			}
		}
	}
}
