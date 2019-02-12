package Google_3;
/*
 * Question 1. 
You are given a string composed of uppercase English letters (‘A’ through ‘Z’). 

Set of letters (‘A’, ‘E’, ‘I’, ‘O’, ‘U’) are called vowels. Other letters are called consonants. 

We define foo value of a string as number of pairs of exactly same consecutive vowel letters. 

For example, 
Ex.1: BCDEEIOU - This has a foo value of 1 (because of EE). Note that although I is next to E, and O is next to I, and U is next to O, they aren’t exactly same neighbours, so they don’t contribute to foo value 

Ex.2: BCDEEEIOU - This has foo value of 2. Because of first pair of EE and immediately next pair of EE 

Ex.3: ABCDEFG - This has foo value of 0. There are no consecutive vowels 

Ex.4: ABEUUOUOO - This has foo value of 2, because of UU and OO 

You are given 2 inputs, N and K. 
How many strings of length N can you form such that they all have foo value of K? 

Let’s assume the constraints as: 

1<=N<=15 
0<=K<N
 */
public class NoOfCombinationString
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int strLength = 5;
		int foolength = 3;
		int value =0;
		
		for(int i=1; i<=strLength; i++)
		{
			if(i>=foolength)
			{
				int CombCount =  strLength-(i-1);
				value = value + (i-(foolength-1))*CombCount;
			}
		}
		
		System.out.println("combinations:"+ value);

	}
}
