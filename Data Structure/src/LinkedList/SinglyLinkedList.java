package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
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
		System.out.print(data);
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
		
		if(first == null)
			first = newLink;
		else
		{
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = newLink; 
		}
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
	
	//Find a middle node from LinkedList
	public Link getMiddleNode()
	{
		Link fast = first;
		Link slow = first;
		
		if(first == null)
			return null;
		
		while(fast.next != null)
		{
			if(fast.next.next == null)		//If length of LinkedList is even
				break;
			
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	//Given a singly linked list: 1->2->3->4->5
	//Change it to 1->5->2->4->3 using O(1) space
	public void changeLinkedList()
	{
		//Firstly, Get the Middle Node 
		Link mid = getMiddleNode();
		
		//Reverse a linked list from Last node to Middle Node
		Link current = mid;
		Link nextNode = current.next;
		
		current.next = null;
		while(current != null && nextNode != null)
		{
			Link tmp = nextNode.next;
			nextNode.next = current;
			current = nextNode;
			nextNode = tmp;
		}
		
		//Put the pointer at both end and iterate till middle node to Merge List
		Link newval = first;
		Link firstLink = newval;
		Link lastLink = current;
		
		while (firstLink != null)
		{
	        Link n1 = firstLink.next;
	        Link n2 = lastLink.next;
	        firstLink.next = lastLink;
	        
	        //If list is odd
	        if (n1 == null) 
	        {
	        	firstLink.next.next = null;
	        	break;
	        }
	            
	        lastLink.next = n1;
	        firstLink = n1;
	        lastLink = n2;
	    }
		
		// Print new List
		System.out.println("New List:");
		while(newval != null)
		{
			System.out.print((newval.next==null)? newval.data+" " : newval.data+" -> ");
			newval = newval.next;
		}
		System.out.println();
	}
	
	// Merge two sorted linked lists and return it as a new sorted list.
	public void mergeLinkedList(Link head1, Link head2)
	{
		Link dummyNode = new Link(0);     
		Link tail = dummyNode; 
		
	    while(true)  
	    { 
	        if(head1 == null) 
	        { 
	            tail.next = head2; 
	            break; 
	        } 
	        
	        if(head2 == null) 
	        { 
	            tail.next = head1; 
	            break; 
	        } 
	          
	       // Compare the data of the two lists whichever lists' data is  smaller, append it into tail
	        
	        if(head1.data <= head2.data) 
	        { 
	            tail.next = head1; 
	            head1 = head1.next; 
	        }  
	        else
	        { 
	            tail.next = head2; 
	            head2 = head2.next; 
	        } 
	        tail = tail.next; 
	    } 
	    
	    Link current = dummyNode.next;
	    
	    //Print merge list
	    System.out.println("Merge List:");
	    while(current != null)
	    {
	    	System.out.print((current.next==null)? current.data+" " : current.data+" -> ");
	    	current = current.next;
	    }
	    System.out.println();
	}
	
	//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	//You should preserve the original relative order of the nodes in each of the two partitions.
	//Input: head = 1->4->3->2->5->2, x = 3
	//Output: 1->2->2->4->3->5
	
	 public void partition(int x)
	 {
		 Link current = first;
	     // before and after are the two pointers used to create the two list
	     // before_head and after_head are used to save the heads of the two lists.
	     // All of these are initialized with the dummy nodes created.
		 Link before_head = new Link(0);
	     Link before = before_head;
	     Link after_head = new Link(0);
	     Link after = after_head;

	     while (current != null)
	     {
	         if (current.data < x)
	         {
	             before.next = current;
	             before = before.next;
	         }
	         else 
	         {
	             after.next = current;
	             after = after.next;
	         }
	         current = current.next;
	     }

	     // Last node of "after" list would also be ending node of the reformed list
	     after.next = null;

	     // Once all the nodes are correctly assigned to the two lists,
	     // combine them to form a single list which would be returned.
	     before.next = after_head.next;

	     displayList();
	}
	
	// Sort Linked List
	public void sortList()
	{
		// Sort with ArrayList
		Link current = first;
		ArrayList<Integer> arrayList= new ArrayList<>();
		
		while(current != null)
		{
			arrayList.add(current.data);
			current = current.next;
		}
		Collections.sort(arrayList);
		
		current = first;
		
		for(int item : arrayList)
		{
			current.data = item;
			current = current.next;
		}
		
		// Sort without ArrayList
/* 		Link current = first;
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
		}*/
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
		System.out.print("After removing duplicate: ");
		displayList();
	}
	
	// Reverse Linked List
	public void reverseList()				
	{
		System.out.print("Original list: ");
		displayList();
		
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
		
		System.out.print("Reverse List: ");
		while(current != null)
		{
			System.out.print((current.next==null)?current.data+" " : current.data+" -> ");
			current = current.next;
		}
	}
	
	//Check if List is Palindrome
	public boolean isPalindrome()           
	{
		Stack<Integer> stack = new Stack<>();
		Link current = first;
		
		while(current != null)
		{
			stack.push(current.data);
			current = current.next;
		}
		
		current = first;
		while(!stack.isEmpty())
		{
			int pop = stack.pop();
			if(pop != current.data)
				return false;
			current = current.next;
		}
		return true;
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
		System.out.print("Output List: ");
		displayList();
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
	    
	    Link dummy1 = new Link(-1);
	    Link dummy2 = new Link(-1);
	    
	    Link current1 = dummy1;
	    Link current2 = dummy2;
	    
	    while(true)
	    {
	        current1.next = head1;
	        current2.next = head2;
	        
	        current1 = current1.next;
	        current2 = current2.next;
	        
	        if(head1 == null || head2 == null)
	        	break;
	        
	        //If List is odd
	        if(head1.next == null)
	        {
	        	current2.next = null;
	        	break;
	        }
	        
	        //If List is even
	        if(head2.next == null)
	        {
	        	current1.next = null;
	        	break;
	        }
	        
	        head1 = head1.next.next;
	        head2 = head2.next.next;
	    }
	    
	    head1 = dummy1.next;
	    head2 = dummy2.next;
	    
		System.out.print("List 1: ");
		while(head1 != null)
		{
			System.out.print((head1.next==null)? head1.data+" " : head1.data+" -> ");
			head1 = head1.next;
		}
		System.out.println("");
		
		System.out.print("List 2: ");
		while(head2 != null)
		{
			System.out.print((head2.next==null)? head2.data+" " : head2.data+" -> ");
			head2 = head2.next;
		}
	}
	
/*	public void SplitAlternateList()
	{
		Link current1 = first;
		Link current2 = first.next;
		
		Link head1 = null;
		Link head2 = null;
		
		while(current1 != null || current2 != null)
		{
			if(current1 != null)
			{
				Link list1 = new Link(current1.data);
				list1.next = head1;
				head1 = list1;
				
				current1 = (current1.next == null)? current1.next : current1.next.next;	 // If LinkedList is odd
			}
			
			if(current2 != null)
			{
				Link list2 = new Link(current2.data);
				list2.next = head2;
				head2 = list2;
				
				current2 = (current2.next == null)? current2.next : current2.next.next;		// If LinkedList is even
			}
		}
		
		System.out.print("List 1: ");
		while(head1 != null)
		{
			System.out.print((head1.next==null)? head1.data+" " : head1.data+" -> ");
			head1 = head1.next;
		}
		System.out.println("");
		
		System.out.print("List 2: ");
		while(head2 != null)
		{
			System.out.print((head2.next==null)? head2.data+" " : head2.data+" -> ");
			head2 = head2.next;
		}
	}
*/	
	
	public void displayList()
	{
		Link current = first;						// start at beginning of list
		while(current != null)						// until end of list,
		{
			if(current.next == null)
				current.displayLink();
			else
				System.out.print(current.data+" -> ");					// print data
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

		llist.insertLast(1);
		llist.insertLast(0);
		llist.insertLast(1);
		llist.insertLast(0);
		llist.insertLast(1);
//		llist.insertLast(0);
		
		llist.displayList();
		
//		LinkedList llist2 = new LinkedList();
//
//		llist2.insertLast(2);
//		llist2.insertLast(4);
//		
//		llist2.displayList();
//		llist.mergeLinkedList(llist.first, llist2.first);

//		Link middleNode = llist.getMiddleNode();
//		System.out.println("Middle Node = "+middleNode.data);
//		llist.changeLinkedList();
//		
//		llist.partition(3);
		
	//	llist.removeDuplicate();
		
		llist.SplitAlternateList();
		
//		int[] arr = {5,1,3,2,8};
//		llist.SortLinkedListFromArray(arr);
		
	//	llist.sortList();
//		llist.insertAscending(50);
//		llist.insertAscending(40);
//		llist.insertAscending(60);
//		llist.insertAscending(10);
//		llist.displayList();
		
		//llist.insertAfter(10, 35);
		
	//	int sum = 10;
	//	llist.sumPair(sum);

//		if(llist.isPalindrome())
//			System.out.println("Palindrome");
//		else
//			System.out.println("Not Palindrome"); 
		
//		llist.reverseList();
				
		
	//	Link l = llist.deleteLink(30);
	//	System.out.println("deleted item = "+l.data);
	//	llist.displayList();
	}

}

