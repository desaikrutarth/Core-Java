package program;

import java.util.LinkedList;
import java.util.Queue;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBinaryTree
{
	Node root = null;
	
	public Node invertTree(Node root)
	{
	    if (root == null)
	    	return null;
	    
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.add(root);
	    
	    while (!queue.isEmpty())
	    {
	    	Node current = queue.poll();
	    	
	    	//Swap leftNode and rightNode
	    	Node temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        
	        if (current.left != null)
	        	queue.add(current.left);
	        if (current.right != null)
	        	queue.add(current.right);
	    }
	    return root;
	}
	
	//Method 2:
/*	public Node invertTree(Node root)
	{
	    if (root == null)
	        return null;

	    Node left = invertTree(root.left);
	    Node right = invertTree(root.right);
	   
	    root.left = right;
	    root.right = left;
	    
	    return root;
	}*/
	
	public void inOrder(Node root)
	{
		if(root != null)
		{
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public static void main(String[] args)
	{
		InvertBinaryTree tree1 = new InvertBinaryTree();
		tree1.root = new Node(4);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(7);
		tree1.root.left.left = new Node(1);
		tree1.root.left.right = new Node(3);
		tree1.root.right.left = new Node(6);
		tree1.root.right.right = new Node(9);
		
		Node node = tree1.invertTree(tree1.root);
		tree1.inOrder(node);
	}
}
