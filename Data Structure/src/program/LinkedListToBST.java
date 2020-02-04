package program;
//Java program to create complete Binary Search Tree from its Linked List
//representation

import java.util.*;

//A linked list node
class LinkedListNode 
{
	int data;
	LinkedListNode next;
	LinkedListNode(int d)
	{
		data = d;
		next = null;
	}
}

//A binary tree node
class TreeNode 
{
	int data;
	TreeNode leftChild, rightChild = null;
	TreeNode(int data)
	{
		this.data = data;
		leftChild = rightChild = null;
	}
}

public class LinkedListToBST 
{
	LinkedListNode head;
	TreeNode root;

	// Function to insert a node at the beginning of
	// the Linked List
	void insert(int data) 
	{
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = head;
		head = newNode;
	}

	// converts a given linked list representing a 
	// complete binary tree into the linked 
	// representation of binary tree.
	TreeNode convertList2Binary(TreeNode node) 
	{
		// queue to store the root nodes
		Queue<TreeNode> q = new LinkedList<>();

		// Base Case
		if (head == null) 
		{
			node = null; 
			return null;
		}

		// 1.) The first node is always the root node, and
		//	 add it to the queue
		
		node = new TreeNode(head.data);
		q.add(node);

		while (head.next != null) 
		{
			root = q.peek();
			head = head.next;
	
			TreeNode newNode = new TreeNode(head.data);
			TreeNode current = root;
			TreeNode parent;
			
			if(root == null)
			{
				root = newNode;
			}				
			else
			{
				while(true)
				{
					parent = current;
					if(head.data < current.data)
					{
						current = current.leftChild;
						if(current == null)
						{
							parent.leftChild = newNode;
							break;
						}
							
					}
					else
					{
						current = current.rightChild;
						if(current == null)
						{
							parent.rightChild = newNode;
							break;
						}
							
					}
				}
			}
			
			
		}
		return node;
	}

	// Utility function to traverse the binary tree 
	// after conversion
	void inorderTraversal(TreeNode node) 
	{
		if (node != null) 
		{
			inorderTraversal(node.leftChild);
			System.out.print(node.data + " ");
			inorderTraversal(node.rightChild);
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) 
	{
		LinkedListToBST tree = new LinkedListToBST();
		tree.insert(50); /* Last node of Linked List */
		tree.insert(30);
		tree.insert(60);
		tree.insert(35);
		tree.insert(25);
		tree.insert(55); 
		tree.insert(65);/* First node of Linked List */
		
		TreeNode node = tree.convertList2Binary(tree.root);

		System.out.println("Inorder Traversal of the"+
						" constructed Binary Tree is:");
		tree.inorderTraversal(node);
	}
}
