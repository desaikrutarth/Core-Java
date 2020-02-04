package LRU;

import java.util.HashMap;
/*
 * LRU Cache using Doubly LinkedList
 */

class Node
{
    int key;
    int value;
    Node prev;
    Node next;
 
    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

public class LRUCacheDLL
{
	int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node first=null;
    Node last=null;
 
    public LRUCacheDLL(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            removeLast(node);
            inserFirst(node);
            return node.value;
        }
 
        return -1;
    }
 
    public void removeLast(Node node)		 //Delete Last in to Doubly LinkedList
    {
        if(node.prev == null)
        	first = null;      
        else
        	node.prev.next = null;
        
 
        if(node.next == null)
        	last = null;        
        else
        	node.next.prev = null;
 
    }
 
    public void inserFirst(Node newNode)     //Insert First in to Doubly LinkedList
    {       
        if(first==null)
        	last = newNode;
        else
        {
        	newNode.next = first;
        	first.prev = newNode;
        }
            
        first = newNode;
    }
 
    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            Node oldNode = map.get(key);
            oldNode.value = value;
            removeLast(oldNode);
            inserFirst(oldNode);
        }
        else
        {
            Node newNode = new Node(key, value);
            if(map.size()>=capacity)
            {
                map.remove(last.key);
                removeLast(last);
                inserFirst(newNode);
            }
            else
            {
                inserFirst(newNode);
            }    
 
            map.put(key, newNode);
        }
    }
    
    public void printLRU()
	{
		Node current = last;
		while(current != null)
		{
			System.out.println(current.key+"="+current.value);
			current = current.prev;
		}
	}
    
    public static void main(String[] args)
    {
    	LRUCacheDLL lru = new LRUCacheDLL(5);
    	lru.put(10, 1);
    	lru.put(10, 2);
    	lru.put(30, 1);
    	lru.put(40, 1);
    	lru.put(50, 1);
    	
    	lru.printLRU();
    	
    }
}
