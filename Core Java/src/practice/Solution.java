// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
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
        
        
    	//List<List<Integer>> nearestXsteakHouse(3,);
    }
  // METHOD SIGNATURE ENDS
}