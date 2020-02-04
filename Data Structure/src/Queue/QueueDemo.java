package Queue;

class Queue
{
	public int maxSize;
	public int[] queArray;
	public int front;
	public int rear;
	public int nItems;
	
	public Queue(int size)
	{
		maxSize = size;
		queArray = new int [maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(int data)
	{
		if(rear == maxSize-1)
			rear = -1;
		rear++;
		queArray[rear] = data;
		nItems++;
	}
	
	public int remove()
	{
		int temp = queArray[front++];
		if(front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}
	
	public int peekFront()
	{
		return(queArray[front]);
	}
	
	public boolean isEmpty()
	{
		return(nItems==0);
	}
	
	public boolean isFull()
	{
		return(nItems==maxSize);
	}
	
	public int size()
	{
		return nItems;
	}
	
	public void display()
	{
		for(int i=0; i < rear + 1; i++ )
		{
			System.out.println(queArray[i]);
		}
	}
}

public class QueueDemo
{
	public static void main(String[] args)
	{
		Queue queue = new Queue(10);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(100);
		queue.insert(1000);
		queue.insert(2000);
		queue.insert(3000);
		
		queue.display();
		
		int size = queue.size();
		System.out.println("size of Queue = "+size);
		
		int peek = queue.peekFront();
		System.out.println("front number = "+peek);
		
		while(!queue.isEmpty())
		{
			int data = queue.remove();
			System.out.println(data+" was removed");
		}
		
		int size1 = queue.size();
		System.out.println("size of Queue = "+size1);
		
	}
}
