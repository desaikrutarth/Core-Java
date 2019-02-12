package programs;

import java.util.Scanner;

public class TwoDArray 
{
	public static void main(String[] args)
	{
		System.out.println("Enter number");
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        int sum = 0;
        for(int i=0; i < 3; i++)
        {
            for(int j=0; j < 3; j++)
            {
                arr[i][j] = in.nextInt();
                if(arr[i][j] > arr[i+1][j] && arr[i][j] > arr[i+2][j])
                {
                	sum = arr[i][j] + arr[i+1][j] + arr[i+2][j];
                }
            }
        }
        System.out.println("sum = " +sum);
        
        for(int i=0; i < 3; i++)
        {
            for(int j=0; j < 3; j++)
            {
                System.out.println(arr[i][j]);
            }
        }
    }
}
