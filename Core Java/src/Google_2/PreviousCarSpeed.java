package Google_2;

import java.util.ArrayList;

/*
assuming there is a freeway, n cars on the road, each car has a different integer speed, but are in the 1-n range. 
Now give you an array that represents the speed of each car.
The starting order of the vehicle is the order of the array, ask the final formation of several clusters
the size of each cluster is how much?
 It can be understood that, although the vehicle speed is different, but even behind the car faster than the previous car,
 because you cannot pass, the last must only travel at the speed of the previous car, which formed a cluster.
 For example:
  		[2,4,1,3], finally [2,4] is a cluster, [1,3] is a cluster. 

Follow up is now suppose you want to add a car, the speed of the car than other large, but not sure the car's starting order,
so that the final output of each possible cluster (List of List). Requirements can be adjusted and call the previous function, but can only be called once
 */
public class PreviousCarSpeed
{
	static ArrayList<ArrayList<Integer>> makeClusters(int[] arr)
	{
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        if (arr == null || arr.length == 0) 
        	return answer;
        int ptr = 1, start = arr[0];
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(start);
        while (ptr < arr.length) 
        {
            int speed = arr[ptr];
            if (speed >= start) {
                temp.add(speed);            
            }
            else
            {
                answer.add(temp);
                temp = new ArrayList<Integer>();
                temp.add(speed);
                start = speed;
            }
            ptr++;
        }
        answer.add(temp);
        return answer;
    }
	public static void main(String[] args)
	{
		int[] arr = {2,4,1,3};
		System.out.println(makeClusters(arr));
	}
}
