package Google_3;

/*
 * Given a sorted array, find all the numbers that occur more than n/4 times.
 */

public class FindNumbersOccurenceN
{
	static void findNums(int[] array)
	{
        if(array.length == 0) return;
        int[] factors = new int[] {1, 2, 3}; //search for the left and right bound on the numbers that show up at index n/4, n/2 and 3n/4;
        int N = array.length;
        int number = array[0] - 1;

        for(int factor: factors) 
        {
            int current = array[N * factor / 4];
            if(number == current) continue;
            int leftBound = binarySearch(array, N * (factor - 1) / 4, N * factor / 4, current, -1);
            int rightBound = binarySearch(array, N * factor / 4, N - 1, current, 1);
            if(rightBound - leftBound >= N / 4) {
                number = current;
                System.out.print(current + "  ");  
            }
        }
    }
	
	static int binarySearch(int[] array, int start, int end, int num, int direction) {
        if(start > end) {
            return -1;
        }
        while(start <= end) {
            int mid = (start + end) / 2;
            if(array[mid] == num) {
                if(mid + direction < 0 || mid + direction > end) {
                    return mid;
                }
                if(direction < 0) {
                    if(array[mid - 1] != num) {
                        return mid;
                    }
                    end = mid - 1;
                } else {
                    if (array[mid + 1] != num) {
                        return mid;
                    }
                    start = mid + 1;
                }
            } else {
                if(direction < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
	public static void main(String[] args) 
	{
		int[] arr = {1,1,2,2,2,3,4,5,5,5};
		findNums(arr);
	}
}
