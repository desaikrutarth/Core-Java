package Google_2;
/*
You are on a train and given a long bench, find an empty seat which is the farthest from other passengers.
Bench can be viewed as an array of 0 and 1. 0 means empty seat and 1 means there is a passenger on this seat.
Example 1:

input: [1,0,0,0,1]
output 2
Seat at index = 2 is the farthest from left passenger and from right passenger.

Example 2:

input: [1,0,0,0,0,1,0,1]
output: 2
Seat at index = 2 is the farthest from left passenger and from right passenger. In addition, index = 3 is also the farthest from other passengers so 3 is also a valid answer.

Example 3:

input: [1,0,0,0,0]
output: 4
 */

public class FindFarthestDistance 
{
	static int findPlace(final int[] arr)
	{
        int pos = 0;
        int maxDistance = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.length; ++i)
        {
            if (arr[i] == 1)
            {
                if (left == 0 && arr[0] == 0)
                    pos = 0;
                else
                    pos = right - left > maxDistance ? left + ((right - left) / 2) : pos;
                
                left = right;
            } 
            else if (i == arr.length - 1)
                pos = right - left > maxDistance ? i : pos;
            else
                maxDistance = Math.max(maxDistance, right - left);
            
            right++;
        }
        return pos;
    }
	
	/*Method 2:
	static int findPlace(final int[] arr)
	{
		int left = 0;
		int maxDistance = 0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == 1)
			{
				int mid = (i - left)/2;
				maxDistance = Math.max(maxDistance, mid);
				left = i;
			}
			else if(i == arr.length-1)
			{
				maxDistance = Math.max(maxDistance, i-left);
			}
		}
		return maxDistance;
    }
	 */
	
	public static void main(String[] args)
	{
		int[] arr = {0,0,0,0,0,1,0,1};
		System.out.println(findPlace(arr));
	}
}
