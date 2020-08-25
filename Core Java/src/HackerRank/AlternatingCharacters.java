package HackerRank;
/*
You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching adjacent characters.
To do this, you are allowed to delete zero or more characters in the string. Your task is to find the minimum number of required deletions.

For example, given the string s = AABAAB, remove an A at positions 0 and 3 to make s = ABAB in 2 deletions.
AAAA -> A (3 deletion)
BBBBB -> B (4 deletion)
ABABABAB -> ABABABAB (0 deletion)
BABABABA -> BABABABA (0 deletion)
AAABBB -> AB (4 deletion)
 */

public class AlternatingCharacters
{
	static int alternatingCharacters(String s)
    {
        char prev = s.charAt(0);
        char curr;
        int count = 0;

        for(int i=1; i<s.length(); i++)
        {
            curr = s.charAt(i);
            if(curr == prev)
                count ++;
            prev = curr;
        }
        return count;
    }
	
	public static void main(String[] args)
	{
		System.out.println(alternatingCharacters("AAABBB"));
	}
}
