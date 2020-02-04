package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

class Link
{
	public int data;
	public Link next;
	
	public Link(int data)
	{
		this.data = data;
	}
	
	public void displayLink()
	{
		System.out.println(data);
	}
}

class LinkedList 
{
	public Link first;								//reference to first link on list
	
	public LinkedList()								
	{
		first = null;								// no items on list yet	
	}
	
	public boolean isEmpty()						// true if list is empty
	{
		return(first == null);
	}
	
	public void insertFirst(int data)		
	{
		Link newLink = new Link(data);				 // create a new link
		newLink.next = first;						 // newLink --> old first
		first = newLink;							 // first --> newLink
	}
	
	public void insertLast(int data)
	{
		Link current = first;
		Link newLink = new Link(data);
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = newLink; 
		newLink.next = null;
	}
	
	public void insertAfter(int key, int data)
	{
		Link current = first;
		Link newLink = new Link(data);
		
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
				System.out.println("no. not found");
		}
		
		if(current == first)
		{
			//newLink.next = first;
			//first = newLink;
			current.next = newLink;
			newLink.next = null;
		}
		else
		{
			newLink.next = current.next;
			current.next = newLink;
		}
	}
	
	public Link deletefirst()
	{
		Link temp = first;							// save reference to link
		if(!isEmpty())								// if list is not empty
		{
			first = first.next;						// delete it: first--> old next
		}
		else
		{
			System.out.println("list is empty");
		}					
		return temp;								// return deleted link
	}
	
	public Link deleteLink(int key)			
	{
		Link current = first;						
		Link previous = first;
		
		while(current.data != key)
		{
			if(current.next == null)
			{
				System.out.println("key not found");
				return null;								// didn’t find it
			}
			else
			{
				previous = current;
				current = current.next;						// go to next link
			}
		}
		if(current == first)								// if first link
		{
			first = first.next;								// delete first
		}
		else
		{
			previous.next = current.next;					// bypass it
		}
		return current;
	}
	
	//Insert in Ascending Order
	public void insertAscending(int data)
	{
	    Link newLink = new Link(data);

	    if (first == null) 
	    {
	        first = newLink;
	        return;
	    } 
	    else if (newLink.data < first.data) 
	    {
	        newLink.next = first;
	        first = newLink;
	        return;
	    }
	    Link current = first;

	    boolean added=false;
	    while (current.next != null)
	    {
	        if (current.next.data > data)
	        { 
	           newLink.next = current.next;
	           current.next = newLink;
	           added = true;
	           break;
	        }
	        current = current.next;
	    }
	    if (!added) 
	        current.next = newLink;
	}
	
	// Sort Linked List
	public void sortList()
	{
		Link current = first;
		Link nextNode = first.next;
		
		while(current != null && nextNode != null)
		{		
			if(current.data > nextNode.data)
			{
				int temp = nextNode.data;
				nextNode.data = current.data;
				current.data = temp;
			}
			
			if(nextNode.next == null)
			{
				current = current.next;
				nextNode = current.next;
			}
			else				
				nextNode = nextNode.next;
			
			
		}
		System.out.println("Sorted List:");
		displayList();
	}
	
	//Find pairs of given sum from Linked List
	public void sumPair(int sum)
	{
		Link current = first;
		Link nextNode = first.next;
		
		while(current != null && nextNode != null)
		{
			
			if(current.data + nextNode.data == sum)
				System.out.println("("+current.data+","+nextNode.data+")");
			
			if(nextNode.next == null)
			{
				current = current.next;
				nextNode = current.next;
			}
			else
				nextNode = nextNode.next;
			
		}
	}
	
	// Remove duplicate from List
	public void removeDuplicate()				
	{
		TreeSet<Integer> set = new TreeSet<>();
		Link current = first;
		while(current != null)
		{
			set.add(current.data);
			current = current.next;
		}
		
		current = first;
		Link prev = first;
		for(int items : set) 
		{
			prev = current;
			current.data = items;
			current = current.next;	
		}
		prev.next = null;
		
	}
	
	// Reverse Linked List
	public void reverseList()				
	{
		Link current = first;
		Link nextNode = current.next;
		first.next = null;
		
		while(current!=null && nextNode != null)
		{
			Link temp = nextNode.next;
			nextNode.next = current;
			current = nextNode;
			nextNode = temp;
		}
		
		System.out.println("Reverse List:");
		while(current != null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	//Check if List is Palindrome
	public boolean isPalindrome()           
	{
		Link current = first;
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;
		while(current != null)
		{
			stack.push(current.data);
			current = current.next;
		}
		current = first;
		while(stack.size() != 0)
		{
			int data = stack.pop();
			if(data == current.data)
				flag = true;
			else
				flag = false;
			current = current.next;	
		}
		return flag;
	}
	
	//Sort the linked list in the order of elements appearing in the array
	//Given array: {5, 1, 3, 2, 8}
	//Given List: 3 -> 2 -> 5 -> 8 -> 5 -> 2 -> 1 -> X
	//Output List:5 -> 5 -> 1 -> 3 -> 2 -> 2 -> 8 -> X
	public void SortLinkedListFromArray(int[] arr)
	{
		Link current = first;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		while(current != null)
		{
			hmap.merge(current.data, 1, Integer::sum);
			current = current.next;
		}
		
		current = first;
		for(int i=0; i<arr.length; i++)
		{
			if(hmap.containsKey(arr[i]))
			{				
			//	current.data = arr[i];	
				int val = hmap.get(arr[i]);
				
				while(val != 0)
				{
					current.data = arr[i];
					current = current.next;
					val--;
				}
			}
		}
		
	}
	
	/*
	 * Alternating split of a given Singly Linked List
	 * Input:  1 -> 0 -> 1 -> 0 -> 1 -> 0
	 * Output-> List1: 0 -> 0 -> 0 
	 * 			List2: 1 -> 1 -> 1
	 */
	public void SplitAlternateList()
	{				
		Link head1 = first;
		Link head2 = first.next;
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		while(head1 != null && head2 != null)
		{
			list1.add(head1.data);			
			list2.add(head2.data);
			
			if(head2.next != null)
			{
				head1 = head1.next.next;
				head2 = head2.next.next;
			}
			else
				break;
						
		}
		
		head1 = null;
		for(int item : list1)
		{
			Link newLink = new Link(item);
			newLink.next = head1;
			head1 = newLink;
		}
		
		head2 = null;
		for(int item : list2)
		{
			Link newLink = new Link(item);
			newLink.next = head2;
			head2 = newLink;
		}
		
		System.out.println("List1::");
		while(head1 != null)
		{
			System.out.println(head1.data);
			head1 = head1.next;
		}
		
		System.out.println("List2::");
		while(head2 != null)
		{
			System.out.println(head2.data);
			head2 = head2.next;
		}
			
		
	}
	
	public void displayList()
	{
		Link current = first;						// start at beginning of list
		while(current != null)						// until end of list,
		{
			current.displayLink();					// print data
			current = current.next;					// move to next link		
		}
		System.out.println(" ");
	}
	
}

public class SinglyLinkedList 
{
	public static void main(String[] args)
	{
		LinkedList llist = new LinkedList();
		llist.insertFirst(0);
		llist.insertFirst(1);
		llist.insertFirst(0);
		llist.insertFirst(1);
		llist.insertFirst(0);
		llist.insertFirst(1);

	/*	llist.displayList();
		
		llist.removeDuplicate();
		llist.displayList();*/
		
		llist.SplitAlternateList();
		
	/*	int[] arr = {5,1,3,2,8};
		llist.SortLinkedListFromArray(arr);*/
		
		//llist.displayList();
		//llist.sortList();
		/*llist.insertAscending(50);
		llist.insertAscending(40);
		llist.insertAscending(60);
		llist.insertAscending(10);*/
		
		
		//llist.insertAfter(10, 35);
		
		
		int sum = 10;
		llist.sumPair(sum);

			
	/*	boolean flag = llist.isPalindrome();
		if(flag)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome"); */
		
		
	//	llist.reverseList();
				
	//	System.out.println("After removing duplicates");
	//	llist.removeDuplicate();
		
	//	Link l = llist.deleteLink(30);
	//	System.out.println("deleted item = "+l.data);
	//	llist.displayList();
	}
}

