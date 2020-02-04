package DoublyLinkedList;

class Linked
{
	public int data;
	public Linked next;
	public Linked prev;
	
	public Linked(int data)
	{
		this.data = data;
	}
	
	public void displayLink()
	{
		System.out.println(data);
	}
}

class LinkList
{
	public Linked first;
	public Linked last;
	
	public LinkList()
	{
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public void insertFirst(int data)
	{
		Linked newLink = new Linked(data);
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
		Linked newLink = new Linked(data);
		if(isEmpty())
		{
			first = newLink;
		}
		else
		{
			newLink.prev = last;
			last.next = newLink;	
		}
		last = newLink;
	}
	
	public boolean insertAfter(int key, int data)
	{
		Linked current = first;
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
				return false;
		}
		
		Linked newLink = new Linked(data);
		if(current == last)
		{
			newLink.next = null;
			current.next = newLink;
			newLink.prev = last;
			last = newLink;
		}
		else
		{
			newLink.next = current.next;
			current.next.prev = newLink;
			current.next = newLink;
			newLink.prev = current;
		}
		return true;
	}
	
	public Linked deletefirst()
	{
		Linked temp = first;
		first = first.next;
		first.prev = null;
		return temp;
	}
	
	public Linked deleteLast()
	{
		Linked temp = last;
		last = last.prev;
		last.next = null;
		return temp;
	}
	
	public Linked delete(int key)
	{
		Linked current = first;
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
			{
				System.out.println("key not found");
			}
		}
		if(current == first)
		{
			first = current.next;
			current.next.prev = null;
		}
		else
		{
			current.prev.next = current.next;
		}
		
		if(current == last)
		{
			last = current.prev;
			current.prev.next = null;
		}
		else
		{	
			current.next.prev = current.prev;
		}
		return current;
	}
	
	public void displayForward()
	{
		Linked current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
	}
	
	public void displayBackword()
	{
		Linked current = last;
		while(current != null)
		{
			current.displayLink();
			current = current.prev;
		}
	}
}

public class DoublyLinkedList1
{
	public static void main(String[] args)
	{
		LinkList list = new LinkList();
		list.insertFirst(10);
		list.insertFirst(20);
		list.insertFirst(30);
		
		list.insertLast(40);
		list.insertLast(50);
		list.insertLast(60);
		
		list.insertAfter(60,70);
		list.displayBackword();
		
	/*	Linked link = list.deletefirst();
		System.out.println("deleted first number = "+link.data);
	//	list.displayForward();
		
		Linked link1 = list.deleteLast();
		System.out.println("delted last number = "+link1.data);*/
		
		Linked link2 = list.delete(40);
		System.out.println("deleted number = "+link2.data);
		list.displayBackword();
				
	}
}
