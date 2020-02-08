package program;


class TreeList
{
	Node root;
	Node first;
	Node last = null;
	
	public void insertTree(int data)
	{
		Node newNode = new Node(data);
		Node current = root;
		
		if(root == null)
			root = newNode;
		else
		{
			Node parent;
			while(true)
			{
				parent = current;
				if(data < current.data)
				{
					current = current.left;
					if(current == null)
					{
						parent.left = newNode;
						break;
					}
				}
				else
				{
					current = current.right;
					if(current == null)
					{
						parent.right = newNode;
						break;
					}
				}
			}
		}		
	}
	
	public void convertTreeToList(Node root)
	{		
		if(root != null)
		{
			convertTreeToList(root.left);
			
			if(last == null)
			{
				first = root;
				last = root;
			}
			else
			{				
				last.right = root;
				root.left = last;
			}
			last = root;
			
			convertTreeToList(root.right);
		}
		
	}
	
	public void printLinkedList()
	{
		Node current = first;
		while(current != null)
		{
			System.out.print((current.right != null)?current.data + " <-> " : current.data);
			current = current.right;
		}
	}
	
	public void inOrderTraversal(Node root)
	{
		if(root != null)
		{
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
		
	}
	
	
}


public class BSTtoLinkedList
{
	public static void main(String[] args)
	{
		TreeList tree = new TreeList();
		tree.insertTree(50);
		tree.insertTree(30);
		tree.insertTree(60);
		tree.insertTree(25);
		tree.insertTree(35);
		tree.insertTree(55);
		tree.insertTree(65);
		
		System.out.println("Binary Tree :");
		tree.inOrderTraversal(tree.root);
		
		System.out.println();
		System.out.println();
		
		tree.convertTreeToList(tree.root);
		System.out.println("Doubly LinkedList:");
		tree.printLinkedList();
		
		
	}
}
