// Java program to extract leaf nodes of a binary search tree in a doubly linked list
// using double linked list

// A binay tree node

package program;

class Node 
{
	int data;
	Node left, right;

	Node(int item) 
	{
		data = item;
		right = left = null;
	}
}
public class TreeDoublyLinkedList
{
	Node root;
	Node head; // will point to head of DLL 
	Node prev; // temporary pointer 

	// The main fuction that links the list list to be traversed
	public Node extractLeafList(Node root) 
	{
		Node current = root;
		if (root == null)
			return null;
		if (current.left == null && current.right == null) 
		{
			if (head == null) 
			{
				head = current;
				prev = current;
			} 
			else
			{
				prev.right = current;    //Saving leaf node and point to the next node of DLL  -->
				current.left = prev;     //Saving leaf node and point to the previous node of DLL  <--
				prev = current;
			}
			return null;
		}
		current.left = extractLeafList(current.left);
		current.right = extractLeafList(current.right);
		return current;
	}

	//Prints the DLL in both forward and reverse directions.
	public void printDLL(Node head) 
	{
		/*Node last = null;
		while (head != null) 
		{
			System.out.print(head.data + " ");
			last = head;
			head = head.right;
		}*/
		
		Node current = head;
		while(current != null)
		{
			System.out.println(current.data + " ");
			current = current.right;
		}
	}

	void inorder(Node node) 
	{
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	// Driver program to test above functions
	public static void main(String args[]) 
	{
		TreeDoublyLinkedList tree = new TreeDoublyLinkedList();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.right = new Node(8);
		tree.root.right.right.left = new Node(9);
		tree.root.right.right.right = new Node(10);

		System.out.println("Inorder traversal of given tree is : ");
		tree.inorder(tree.root);
		tree.extractLeafList(tree.root);
		
		System.out.println("");
		System.out.println("Extracted double link list is : ");
		tree.printDLL(tree.head);
		
		System.out.println("");
		System.out.println("Inorder traversal of modified tree is : ");
		tree.inorder(tree.root);
	}
}
/*
Let the following be input binary tree
       1
     /   \
    2     3
   / \     \
  4   5     6
 / \       / \
7   8     9   10


Output:

Doubly Linked List
7<->8<->5<->9<->10

Modified Tree:
       1
     /   \
    2     3
   /       \
  4         6           */
