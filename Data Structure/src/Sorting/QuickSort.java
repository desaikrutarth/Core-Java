package Sorting;

class Qsort
{
	int[] arr = new int[10];
	int nItems = 0;
	
	public void insert(int data)
	{
		arr[nItems] = data;
		nItems++;
	}
	public void sorting()
	{
		quickSort(0,nItems-1);
	}
	public void quickSort(int left, int right)
	{
		int pivot = arr[right];
		int part = partition(left,right,pivot);
		quickSort(left,part-1);
		quickSort(part+1, right);
	}
	
	public int partition(int left, int right, int pivot)
	{
		int leftPtr = left-1;
		int rightPtr = right;
		pivot = arr[right];
		
		while(rightPtr < pivot)
		{
			if(arr[rightPtr] <  pivot-1)
			{
				leftPtr++;
				int temp = arr[rightPtr];
				arr[rightPtr] = arr[leftPtr];
				arr[leftPtr] = temp;
			}
			rightPtr++;
		}
		return leftPtr;
	}
	
	public void display()
	{
		for(int i=0; i < nItems; i++)
			System.out.println(arr[i]);
	}
}

public class QuickSort 
{
	public static void main(String[] args)
	{
		Qsort sort = new Qsort();
		sort.insert(10);
		sort.insert(20);
		sort.insert(5);
		sort.insert(15);
		sort.insert(30);
		
		sort.sorting();
		
		sort.display();
	}
}
