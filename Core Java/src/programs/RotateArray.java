package programs;

public class RotateArray
{
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,4,5};
		int subArray1[] = new int[arr.length];
		int subArray2[] = new int[arr.length];
		int k=3,n1=0,n2=0;
		int arrDex=0,subArrDex1=0,subArrDex2=0;
		
		for(int i=0; i<k-1; i++)
		{
			subArray1[n1] = arr[i];
			n1++;
		}
		
		for(int j=k-1; j< arr.length; j++)
		{
			subArray2[n2] = arr[j];
			n2++;
		}
		
		while(subArrDex1 < subArray1.length && subArrDex2 < subArray2.length)
		{
			if(subArrDex1 < subArray1.length)
				arr[arrDex++] = subArray1[subArrDex1++];
			else
				arr[arrDex++] = subArray2[subArrDex2++];
		}
		while(subArrDex2 < subArray2.length)
		{
			arr[arrDex] = subArray2[subArrDex2];
		}
		while(subArrDex1 < subArray1.length)
		{
			arr[arrDex++] = subArray1[subArrDex1++];
		}
		
		
		for(int x=0; x<arr.length; x++)
		{
			System.out.println(arr[x]);
		}
		
		
	}
}
