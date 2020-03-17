package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
A weighted string is a string of lowercase English letters where each letter has a weight.
Character weights 1 are 26 to a from z to  as shown below:
a=1, b=2, c=3,....z=26

Sample Input:
String str = "abccddde";
int[] queries = {1,3,12,5,9,10};

Sample Output:
String Output[] = {Yes,Yes,Yes,Yes,No,No}

Description:
str = a=1, b=2, c=3, cc=3+3=6, d=4, dd=4+4=8, ddd=4+4+4=12, e=5
Query = 1,3,12,5,9,10

We print 'Yes' on the first four lines because the first four queries match weights of uniform substrings of S.
We print 'No' for the last two queries because there are no uniform substrings in S that have those weights.
Note that while "de" is a substring of  that would have a weight of , it is not a uniform substring. Note that we are only dealing with contiguous substrings.
So "ccc" is not a substring of the string "ccxxc".

Sample Input:
String str = "aaabbbbcccddd";
int[] queries = {5,9,7,8,12,5};

Sample Output:
String Output[] = {Yes,No,Yes,Yes,No}
 */
public class WeightedStrings
{
	static String[] weightedUniformStrings(String str, int[] queries)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i=0; i<alpha.length(); i++)
            map.put(alpha.charAt(i),i+1);
        List<Integer> weightList = new ArrayList<>();

        int prev=map.get(str.charAt(0));
        weightList.add(prev);
        for(int i=1; i<str.length(); i++)
        {
        	int current = map.get(str.charAt(i));
            if(str.charAt(i) == str.charAt(i-1))
            	current += prev;
            weightList.add(current);
            prev = current;
        }

        String[] output = new String[queries.length];
        int index=0;
        for(int query : queries)
        {
            if(weightList.contains(query))
                output[index++] = "Yes";
            else
                output[index++] = "No";
        }
        return output;
    }
	
	public static void main(String[] args)
	{
		String str = "abccddde";
		int[] queries = {1,3,12,5,9,10};
		System.out.println(Arrays.toString(weightedUniformStrings(str, queries)));
	}
}
