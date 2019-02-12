package Google_1;
import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * Explanation:
For 1st test case:
arr[] = 5 2 1 3 2
Firstly their was 5 whose frequency is max till now. so print 5.
Then 2 , which is smaller than 5 but their frequency is same so print 2 5.
Then 1, Which is smallest among all the number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5
Then again 2, which has the highest frequency among all number so 2 1 3 5.

For 2nd test case:
arr[] = 5 2 1 3 4
Firstly their was 5 whose frequency is max till now. so print 5.
Then 2 , which is smaller than 5 but their frequency is same so print 2 5.
Then 1, Which is smallest among all the number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5.
Then 4, so 1 2 3 4 as K is 4 so print at-most k elements.
 */

/*
 * Example:
Input:
 2
 5 4
 5 2 1 3 2
 
 5 4
 5 2 1 3 4
Output:
 5 2 5 1 2 5 1 2 3 5 2 1 3 5 
 5 2 5 1 2 5 1 2 3 5 1 2 3 4 
 */
class TopKNumbers 
{
	public static void main (String[] args) throws IOException {
		System.out.println("Enter Test cases");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) 
        {
			System.out.println("Enter Array size and value of K with space");
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int n = Integer.parseInt(st.nextToken());
		    int k = Integer.parseInt(st.nextToken());
		    int[] a = new int[n];
			System.out.println("Enter Array elements");
		    st = new StringTokenizer(br.readLine());
		    for(int i = 0; i < n; i++) 
		    	a[i] = Integer.parseInt(st.nextToken());
		    
		    printTopK(a, k);
		    System.out.println();
		}
	}
	
		private static void printTopK(int[] a, int k) 
        {
	    
		TreeMap<Integer, TreeSet<Integer>> freqTreeMap = new TreeMap<Integer, TreeSet<Integer>>(Collections.reverseOrder());
	    //Set<Integer> numSet = new HashSet<Integer>();
		HashMap<Integer, Integer> freqHashMap = new HashMap<Integer,Integer>();
	    
	    for(int i = 0; i < a.length; i++) 
        {
	        freqHashMap.merge(a[i], 1, Integer::sum);
	        //Check if a[i] exists in tree map, it yes, adjust its value
                //System.out.println(freqHashMap.get(a[i])+" --------------------------------");
                
	        TreeSet<Integer> numSet = freqTreeMap.get(freqHashMap.get(a[i])-1);
                
	        if(numSet != null) 
	            numSet.remove(a[i]);
	        
	        numSet = freqTreeMap.get(freqHashMap.get(a[i]));
	        if(numSet == null) 
	            numSet = new TreeSet<Integer>();
	        
            numSet.add(a[i]);
            freqTreeMap.put(freqHashMap.get(a[i]), numSet);
            
            printValues(freqTreeMap, k);
	    }
	}
	
	private static void printValues(TreeMap<Integer, TreeSet<Integer>> freqTreeMap, int k)
	{
        int count = 0;
	    for (TreeSet<Integer> nums : freqTreeMap.values()) 
            {
	        for(Integer i: nums)
                {
	            count++;
	            if(count <= k) 
                        System.out.print(i + " ");
                    else
                        return;
	        }
	    }
           // System.out.println();
	}
}