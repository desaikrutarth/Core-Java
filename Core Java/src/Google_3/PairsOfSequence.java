package Google_3;

import java.util.HashSet;
import java.util.Set;

/*
 * Give an array A of n integers where 1 <= a[i] <= K. 
Find out the length of the shortest sequence that can be constructed out of numbers 1, 2, .. k that is NOT a subsequence of A. 
eg. A = [4, 2, 1, 2, 3, 3, 2, 4, 1], K = 4 
All single digits appears. Each of the 16 double digit sequences,
(1,1), (1, 2), (1, 3), (1, 4), (2, 1), (2, 2) ... appears.
Because (1, 1, 2) doesn't appear, return 3.
 */
public class PairsOfSequence
{
	static void findPairs(int[] a , int k)
	{
		int result = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < a.length; i++)
        {
            if (!set.contains(a[i]))
            {
                set.add(a[i]);
                if (set.size() == k)
                {
                    result++;
                    set = new HashSet<>();
                }
            }
        }
        System.out.println(result + 1);
	}
	
	public static void main(String[] args)
	{
		int[] arr = {4, 2, 1, 2, 3, 3, 2, 4, 1};
		findPairs(arr, 4);
	}
}
