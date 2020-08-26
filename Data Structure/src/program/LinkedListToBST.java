package program;
//Java program to create complete Binary Search Tree from its Linked List representation


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
	LinkedListNode first;
	TreeNode root;

	// Function to insert a node at the beginning of the Linked List
	void insert(int data) 
	{
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = first;
		first = newNode;
	}
	
	// Method of converting Binary Search Tree from LinkedList
	public void convertList2Binary() 
	{
		LinkedListNode currentLink = first;
		
		while(currentLink != null)
		{
			TreeNode newNode = new TreeNode(currentLink.data);
			
			if(root == null)
				root = newNode;
			else
			{
				TreeNode currentNode = root;
				TreeNode parentNode;
				
				while(true)
				{
					parentNode = currentNode;
					
					if(currentLink.data < currentNode.data)
					{
						currentNode = currentNode.leftChild;
						if(currentNode == null)
						{
							parentNode.leftChild = newNode;
							break;
						}
					}
					else
					{
						currentNode = currentNode.rightChild;
						if(currentNode == null)
						{
							parentNode.rightChild = newNode;
							break;
						}
					}
				}
			}
			
			currentLink = currentLink.next;
		}
	}

	// Utility function to traverse the binary tree after conversion
	void inorderTraversal(TreeNode node) 
	{
		if (node != null) 
		{
			inorderTraversal(node.leftChild);
			System.out.print(node.data + " ");
			inorderTraversal(node.rightChild);
		}
	}
	
	// Method to print LinkedList
	public void printLinkedList() 
	{
		LinkedListNode current = first;
		while(current != null)
		{
			System.out.print((current.next != null)?current.data + " -> " : current.data);
			current = current.next;
		}
		System.out.println();
	}

	// Driver program to test above functions
	public static void main(String[] args) 
	{
		LinkedListToBST listTotree = new LinkedListToBST();
		listTotree.insert(50); /* Last node of Linked List */
		listTotree.insert(30);
		listTotree.insert(60);
		listTotree.insert(35);
		listTotree.insert(25);
		listTotree.insert(55); 
		listTotree.insert(65);/* First node of Linked List */
		
		System.out.println("Singly LinkedList:");
		listTotree.printLinkedList();
		
		listTotree.convertList2Binary();
		
		System.out.println();
		System.out.println("Inorder Traversal of the constructed Binary Search Tree is:");
		listTotree.inorderTraversal(listTotree.root);
	}
}
