package Google_1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/*
 * Generate a random number with UNIFORM DISTRIBUTION between (0,n) where n is given and excluded list is given.
 * The randomly generated number should belong to the range (0, n) but should be excluded from the given excluded list.
 *  For example,
 *  	 n = 10 and excluded list ={2,3,0} then the random number should be from {1,4,5,6,7,8,9} such that any number from the list {1,4,5,6,7,8,9} has UNIFORM probablility of occuring
 */
public class RandomUniformNumber
{
	public static int random(int n, Set<Integer> excluded)
	{
		int number = new Random().nextInt(n);
		
		while(excluded.contains(number))
		{
			number = new Random().nextInt(n);
		}
		return number;
    }
	
	public static void main(String[] args)
	{
		Set<Integer> set = new HashSet<>();
		set.add(2);
		set.add(3);
		set.add(0);
		System.out.println(random(10, set));
	}
}
