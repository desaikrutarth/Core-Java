/*// We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site.
 *  The histories are in chronological order and no URL was visited more than once per person.

// Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

// Sample input:

// user0 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
// user1 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
// user2 = ["a", "/one", "/two"]
// user3 = ["/red", "/orange", "/yellow", "/green", "/blue", "/purple", "/white", "/amber", "/HotRodPink", "/BritishRacingGreen"]
// user4 = ["/red", "/orange", "/amber", "/random", "/green", "/blue", "/purple", "/white", "/lavender", "/HotRodPink", "/BritishRacingGreen"]
// user5 = ["a"]

// Sample output:

// findContiguousHistory(user0, user1)
//    /pink
//    /register
//    /orange

// findContiguousHistory(user1, user2)
//    (empty)

// findContiguousHistory(user2, user0)
//    a 

// findContiguousHistory(user5, user2)
//    a 

// findContiguousHistory(user3, user4)
//    /green
//    /blue
//    /purple
//    /white

// findContiguousHistory(user4, user3)
//    /green
//    /blue
//    /purple
//    /white

// n: length of the first user's browsing history
// m: length of the second user's browsing history
*/
package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution
{        
	List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, List<List<Integer>> allLocations, int numSteakhouses)
	{
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		TreeMap<Double, List<Integer>> hmap = new TreeMap<>(); 
		
		for(List<Integer> list : allLocations)
		{
			for(int i=1; i<list.size(); i++)
			{
				int x = list.get(i-1);
				int y = list.get(i);
				
				int sum = (x*x) + (y*y);
				double root = Math.sqrt(sum); 
				
				hmap.put(root, list);
			}
		}
		
		int count = 0;
		for(double key : hmap.keySet())
		{
			if(count < numSteakhouses)
				resultList.add(hmap.get(key));
			count++;
		}
		return resultList;
	}
    
    public static void main(String[] args)
    {
    	String[] user0 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user1 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/red", "/orange", "/yellow", "/green", "/blue", "/purple", "/white", "/amber", "/HotRodPink", "/BritishRacingGreen"};
        String[] user4 = {"/red", "/orange", "/amber", "/random", "/green", "/blue", "/purple", "/white", "/lavender", "/HotRodPink", "/BritishRacingGreen"};
        String[] user5 = {"a"};
    	
    }
  // METHOD SIGNATURE ENDS
}