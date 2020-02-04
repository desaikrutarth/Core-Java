package Stack;

class Stack
{
	public int maxSize;
	public int[] stackArray;
	public int top;
	
	public Stack(int size)
	{
		maxSize = size;
		stackArray = new int[size];
		top = -1;
	}
	
	public void push(int data)
	{
		top++;
		stackArray[top] = data;
	}
	
	public int pop()
	{
		return stackArray[top--];
	}
	
	public int peek()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	public boolean isFull()
	{
		return (top == maxSize-1);
	}
	
	public void display()
	{
		for(int i=0; i<top+1; i++)
		{
			System.out.println(stackArray[i]);
		}
	}
}

public class StackDemo 
{
	public static void main(String[] args)
	{
		Stack stack = new Stack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		stack.display();
		int peek = stack.peek();
		System.out.println("value on top = "+peek);
		
		while(!stack.isEmpty())
		{
			int value = stack.pop();
			System.out.println(value+" was deleted");
		}
		
	}
}
