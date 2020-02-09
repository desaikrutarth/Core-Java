package program;
/* Java program to extract leaf nodes of a binary search tree in a doubly linked list using double linked list
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

Modified Tree after removing leaf nodes:
      1
    /   \
   2     3
  /       \
 4         6      */

//A Binary Tree node
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
	Node root = null;		// Root of Binary Tree
	Node first = null;		// First of Doubly LinkedList 
	Node last = null;		// Last of Doubly LinkedList
	
	// Method of extracting leaf nodes of a Binary Tree in a Doubly LinkedList
	public Node extractLeafList(Node treeNode) 
	{
		if(treeNode == null)
			return null;
		
		if(treeNode.left == null && treeNode.right == null)
		{
			if(first == null)
			{
				first = treeNode;
				last = treeNode;
			}
			else
			{
				last.right = treeNode;		//Saving leaf node and point to the next node of DLL  -->
				treeNode.left = last;		//Saving leaf node and point to the previous node of DLL  <--
				last = treeNode;
			}
			return null;
		}
		
		treeNode.left = extractLeafList(treeNode.left);		
		treeNode.right = extractLeafList(treeNode.right);
		
		return treeNode;
	}

	//Prints the DLL in both forward and reverse directions.
	public void printDLL(Node first) 
	{
		Node current = first;
		while(current != null)
		{
			System.out.print((current.right != null)?current.data + " <-> " : current.data);
			current = current.right;
		}
		System.out.println();
	}

	void inorder(Node root) 
	{
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
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
		System.out.println();
		Node node = tree.extractLeafList(tree.root);
		
		System.out.println("");
		System.out.println("Extracted Double LinkedList is : ");
		tree.printDLL(tree.first);
		
		System.out.println("");
		System.out.println("Modified Tree after removing leaf nodes : ");
		tree.inorder(node);
	}
}
/*
     */
