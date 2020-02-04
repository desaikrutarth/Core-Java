package Stack;

import java.util.LinkedList;
import java.util.Random;

public class StackUsingLinkedList
{
	LinkedList<Integer> list = new LinkedList<>();
	
	void push(int data)
	{
		list.add(data);
	}
	
	int pop()
	{
		return list.removeLast();
	}
	
	int peek()
	{
		return list.getLast();
	}
	
	void print()
	{
		System.out.println(list);
	}
	
	int getRandom()
	{
		return list.get(new Random().nextInt(list.size()));
	}
	
	public static void main(String args[])
	{
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.print();
		System.out.println("Peek: "+stack.peek());
		System.out.println("Element removed: "+stack.pop());
		System.out.println("Element removed: "+stack.pop());
		System.out.println("Element removed: "+stack.pop());
		
		stack.print();
		System.out.println("Peek: "+stack.peek());
		
		
	}
}
