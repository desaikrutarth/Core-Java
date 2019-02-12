package programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadCount 
{
	public static void main(String[] args) throws IOException
	{
	//	String file = "C://Users//Krutarth//Documents//read1.txt";
	//	BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = "1,2,3,4,5,6,7,8,9";
		System.out.println(str);
		String splitt[] = str.split(",");
		//int[] numbers = new int[splitt.length];
		int countOdd=0;
		int countEven=0;
		int i;
		for(i=0; i<splitt.length; i++)
		{
			int numbers = Integer.parseInt(splitt[i]);
			if(numbers%2 == 0)
			{
				countEven++;
			}
			else
			{
				countOdd++;
			}
		}
		System.out.println("Odd= "+countOdd);
		System.out.println("Even= "+countEven);
	}
}