
package programs;

public class MergeTwoArrays 
{
	public static void main(String[] args)
	{
		int a[] = {1,2,3,4,5};
		int b[] = {6,7,8,9,10};
		int temp[] = new int[10];
	
		int aSize = a.length;
		int bSize = b.length;
		int i=0,j=0,k=0;
		
		while(i < aSize && j < bSize)
		{
			if(a[i] < b[j])
			{
				temp[k++] = a[i++];
			}
			else
			{
				temp[k++] = b[j++];
			}
		}
		
		while(i < aSize)					// arrayB is empty but arrayA is not
		{
			temp[k++] = a[i++];
		}
		
		while(j < bSize)					// arrayA is empty but arrayB is not
		{
			temp[k++] = b[j++];
		}
		
		for(int x=0; x < temp.length; x++)
		{
			System.out.println(temp[x]);
		}
	}
}
