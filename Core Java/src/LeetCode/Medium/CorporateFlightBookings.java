package LeetCode.Medium;

import java.util.Arrays;

/*
There are n flights, and they are labeled from 1 to n.
We have a list of flight bookings.
The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
Return an array answer of length n, representing the number of seats booked on each flight in order of their label.

Example 1:

Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
 */
public class CorporateFlightBookings
{
/*	Since ranges are continuous, we add reservations to the first flight in the range, and remove them after the last flight in range
	We can then use the running sum to update reservations for all flights.
	
	Flights:		1	2	3	4	5
	Reservation 1: 	10	   -10
	Reservation 2:		20	   -20
	Reservation 3:			25
	
	All Reservation:10  20  15 -20	0
			 		10 +10 +30 +45 +25
			 Result:10  30  45  25  25
*/	
	 public static int[] corpFlightBookings(int[][] bookings, int n)
	 {
		 int[] res = new int[n];
		 for (int[] booking : bookings)
		 {
			 res[booking[0] - 1] += booking[2];
			 if (booking[1] < n)
				 res[booking[1]] -= booking[2];
		 }
		  
		 for (int i = 1; i < n; ++i)
			 res[i] += res[i - 1];
		 return res;
	 }
	 
/*	 public static int[] corpFlightBookings(int[][] bookings, int n)
	 {
		 int ans[]=new int[n];
		 int startarr[]=new int[n];
	     int endarr[]=new int[n];
	     for(int i=0;i<bookings.length;i++)
	     {
	         int start=bookings[i][0]-1;
	         int end=bookings[i][1]-1;
	         int cost=bookings[i][2];
	            
	         startarr[start]+=cost;
	         endarr[end]+=cost;
	     }
	     
	     int sum=0;
	     for(int i=0;i<ans.length;i++)
	     {
	         sum+=startarr[i]; //0 has no effect
	         ans[i]=sum;
	         sum-=endarr[i]; 
	     }
	     return ans;
	 }
*/	 
	 
	 public static void main(String[] args)
	 {
		 int[][] bookings = {{1,2,10},
				 			 {2,3,20},
				 			 {3,5,25}};
		 
		 System.out.println(Arrays.toString(corpFlightBookings(bookings, 5)));
	 }
}
