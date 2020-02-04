package Queue;

class Priority
{
	public int maxSize;
	public int[] queArray;
	public int nItems;
	
	public Priority(int size)
	{
		maxSize = size;
		queArray = new int[maxSize];
		nItems = 0;
	}
	
	public void insert(int value)
	{
		int j=0;
		
		for(j = nItems; j >= 0; j--)
		{
			if(value > queArray[j])
			{
				queArray[j+1] = queArray[j];
				queArray[j] = value;
			}
		}
		nItems++;
	}
	
	public int remove()
	{
		nItems--;
		return queArray[nItems];
	}
	
	public boolean isEmpty()
	{
		return (nItems == 0);
	}
	
	public boolean isFull()
	{
		return(nItems == maxSize);
	}
	
	public void display()
	{
		for(int i=0; i<nItems; i++)
		{
			System.out.println(queArray[i]);
		}
	}
}

public class PriorityQueue 
{
	public static void main(String[] args)
	{
		Priority pr = new Priority(10);
		pr.insert(30);
		pr.insert(10);
		pr.insert(20);
		pr.insert(15);
		pr.insert(5);
		pr.insert(25);
		
		pr.display();
		
		while(!pr.isEmpty())
		{
			int data = pr.remove();
			System.out.println(data+" was removed");
		}
	}
}
