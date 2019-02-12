package Google_1;
/*
 * You are given a list of n float numbers x_1, x_2, x_3, ... x_n, where x_i > 0.
A traveler starts at point (0, 0) and moves x_1 metres to the north, then x_2 metres to the west, x_3 to the south, x_4 to the east and so on,
(after each move his direction changes counter-clockwise) 
Write an single-pass algorithm that uses O(1) memory to determine, if the travelers path crosses itself, or not
(i.e. if it's self-intersecting) 
e.g. 
2 1 1 2 -> crosses 
1 2 3 4 -> doesn't cross
 */
public class TravelarPathCross 
{
	static void checkPath(double[] arr)
	{
		for (int i = 0; i < arr.length; i++)
        {
            if (i >= 3 && 
                arr[i] >= arr[i - 2] &&
                arr[i - 1] <= arr[i - 3])
            {
                System.out.println("Cross Detected, pattern #1");
                return;
            }
            if (i >= 5 &&
                arr[i] >= arr[i - 2] - arr[i - 4] &&
                arr[i - 2] >= arr[i - 4] &&
                arr[i - 1] >= arr[i - 3] - arr[i - 5] &&
                arr[i - 3] >= arr[i - 5])
            {
            	 System.out.println("Cross Detected, pattern #2");
                return;
            }
        }
        System.out.println("No Cross");
	}
	public static void main(String[] args)
    {
        double[] arr = new double[] { 2, 1, 1, 2 }; // cross
        //double[] n = new double[] { 2, 2, 2, 2 }; // Cross
        //double[] n = new double[] { 3, 2, 2, 3 }; // Cross
        //double[] n = new double[] { 3, 3, 2, 2, 3 }; // Cross
        //double[] n = new double[] { 2, 2, 4, 5, 1, 4 }; // No Cross
        //double[] n = new double[] { 2, 2, 4, 5, 3, 4 }; // Cross
        //double[] n = new double[] { 1, 2, 4, 5, 1, 4 }; // No Cross
        //double[] arr = { 0.5, 2, 2, 4, 5, 3, 4, 0.5 }; // Cross
        checkPath(arr);

        
    }
}
