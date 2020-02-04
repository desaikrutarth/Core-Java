package Sorting;

class Msort
{
	private long[] theArray;		 
	private int nElems; 			 
	
	public Msort(int max) 			
	{
		theArray = new long[max]; 
		nElems = 0;
	}

	public void insert(long value) 				// put element into array
	{
		theArray[nElems] = value; 				// insert it
		nElems++; 
	}

	public void display() 					
	{
		for(int j=0; j<nElems; j++) 			
			System.out.print(theArray[j] + " "); 
	}

	public void mergeSort() 					// called by main()
	{ 
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems-1);
	}
	
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound)
	{
		if(lowerBound == upperBound)
			return;
		else
		{
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);		// sort first half
			recMergeSort(workSpace, mid+1, upperBound);		// sort second half
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}
	
	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound)
	{
		int j=0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound - lowerBound + 1;
		
		while(lowPtr <= mid && highPtr <= upperBound)
		{
			if(theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];
		}
		
		while(lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];
		
		while(highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];
			
		for(j=0; j<n; j++)
			theArray[lowerBound+j] = workSpace[j];
	}
}

public class MergeSort
{
	public static void main(String[] args)
	{
		Msort arr = new Msort(10); // create the array
		arr.insert(64); 
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(0);
		
		arr.mergeSort(); // merge sort the array
		arr.display(); // display items again
	} 
}

