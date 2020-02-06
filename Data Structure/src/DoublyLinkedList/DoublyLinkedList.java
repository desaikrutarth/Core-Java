package DoublyLinkedList;

class Link
{
	public int data;
	public Link next;
	public Link prev;
	
	public Link(int data)
	{
		this.data = data;
	}
	
	public void displayLink()
	{
		System.out.print(data+" ");
	}
}

class LinkedList
{
	public Link first;
	public Link last;
	
	public LinkedList()
	{
		first = null;
		last = null;
	}
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public void insertFirst(int data)
	{
		Link newLink = new Link(data);
		if(isEmpty())
		{
			last = newLink;
		}
		else
		{
			first.prev = newLink;
			newLink.next = first;
		} 
		first = newLink;
	}
	public void insertLast(int data)
	{
		Link newLink = new Link(data);
		if(isEmpty())
		{
			first = newLink;
		}
		else
		{
			last.next = newLink;
			newLink.prev = last;
		}
		last = newLink;
	}
	
	public boolean insertAfter(int key, int data)
	{
		Link current = first;
		
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
				return false;
		}
		Link newLink = new Link(data);
		
		if(current == last)
		{
			newLink.next = null;
			last = newLink;
		}
		else
		{
			newLink.next = current.next;
			current.next.prev = newLink;
		}
		current.next = newLink;
		newLink.prev = current;
		
		return true;
		
	}
	
	public void displayForward()
	{
		Link current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
	public void displayBackword()
	{
		Link current = last;
		
		while(current != null)
		{
			current.displayLink();
			current = current.prev;
		}
		System.out.println();
	}
	
	public Link deleteFirst()
	{
		Link temp = first;
		first.next.prev = null;
		first = first.next;
		return temp;
	}
	
	public Link deleteLast()
	{
		Link temp = last;
		last.prev.next = null;
		last = last.prev;
		return temp;
	}
	
	public Link delete(int key)
	{
		Link current = first;
		
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
			{
				System.out.println("number not found");
				return null;
			}
				
		}
		
		if(current == first)
		{
			first = current.next;
		}
		else
		{
			current.prev.next = current.next;
		}
		
		if(current == last)
		{
			last = current.prev;
		}
		else
		{
			current.next.prev = current.prev;
		}
		return current;
		
	}
}

public class DoublyLinkedList 
{
	public static void main(String[] args)
	{
		LinkedList llist = new LinkedList();
		llist.insertFirst(1);
		llist.insertFirst(2);
		llist.insertFirst(3);
		
	//	llist.displayForward();
		
		llist.insertLast(10);
		llist.insertLast(20);
		llist.insertLast(30);
		
		llist.insertAfter(1,15);
		Link link = llist.deleteFirst();
		System.out.println("deleted first node = "+link.data);
		
		llist.displayForward();
		
		Link link1 = llist.deleteLast();
		System.out.println("deleted last node = "+link1.data);
		
		llist.displayBackword();
		
		Link link2 = llist.delete(10);
		System.out.println("deleted node = "+link2.data);
		
		llist.displayForward();
	}
}
