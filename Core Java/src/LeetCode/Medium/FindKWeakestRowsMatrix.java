package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j,
or they have the same number of soldiers but i is less than j.
Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]

Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4]

Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 

The number of soldiers for each row is: 
row 0 -> 1 
row 1 -> 4 
row 2 -> 1 
row 3 -> 1 
Rows ordered from the weakest to the strongest are [0,2,3,1]
 */
public class FindKWeakestRowsMatrix
{
	public static int[] kWeakestRows(int[][] matrix, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int index=0;
		
        for(int[] row : matrix)
        {
        	int sum = Arrays.stream(row).sum();
        	map.put(index++, sum);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list, (a,b) -> {
        	int fa = map.get(a);
        	int fb = map.get(b);
        	
        	if(fa > fb)
        		return 1;
        	
        	if(fa < fb)
        		return -1;
        	
        	return a;
        });
        
        int[] result = new int[list.size()];
        index=0;
        for(index=0; index < k; index++)
        	result[index] = list.get(index);
       
        
        return Arrays.copyOf(result, index);
    }
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,1,0,0,0},
		                  {1,1,1,1,0},
		                  {1,0,0,0,0},
		                  {1,1,0,0,0},
		                  {1,1,1,1,1}};
		
		System.out.println(Arrays.toString(kWeakestRows(matrix, 3)));
	}
}
