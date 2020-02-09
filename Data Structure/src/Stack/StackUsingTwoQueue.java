package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue
{
    Queue<Integer> queue1 = new LinkedList<Integer>(); 
    Queue<Integer> queue2 = new LinkedList<Integer>(); 
    int numOfItems = 0;
    int top = -1;
    
    public void push(int x) 
    { 
    	numOfItems++;
    	queue2.add(x);
    	top = x;
    	while (!queue1.isEmpty())
    	{                
    		queue2.add(queue1.remove());
    	}
    	Queue<Integer> temp = queue1;
    	queue1 = queue2;
    	queue2 = temp;
    } 

    public void pop() 
    { 
    	if (queue1.isEmpty()) 
            return;
    	
    	queue1.remove();
    	top = queue1.peek();
    	numOfItems--;
    } 

    public int top() 
    { 
        return top;
    } 
    
    public int size() 
    { 
        return numOfItems; 
    } 

    public static void main(String[] args) 
    { 
    	StackUsingTwoQueue stack = new StackUsingTwoQueue(); 
        stack.push(1); 
        stack.push(2); 
        stack.push(3); 
        stack.push(4); 
        stack.push(5); 
  
        System.out.println("current size: " + stack.size()); 
        System.out.println("Top = "+stack.top()); 
        
        stack.pop();
        stack.pop();
        
        System.out.println("Top = "+stack.top()); 
  
        System.out.println("current size: " + stack.size()); 
    } 
}
