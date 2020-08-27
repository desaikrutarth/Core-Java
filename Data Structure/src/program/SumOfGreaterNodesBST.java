package program;
/*
Given the root of a binary search tree with distinct values,
modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.


Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */
public class SumOfGreaterNodesBST
{
	Node root = null;
	private int sum = 0;
	
	public Node convertBST(Node root)
	{
		if (root != null)
		{
			convertBST(root.right);
			
	        sum += root.data;
	        root.data = sum;
	        
	        convertBST(root.left);
	    }
	    return root;
	}
	
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
		SumOfGreaterNodesBST tree1 = new SumOfGreaterNodesBST();
		tree1.root = new Node(5);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(13);
		
		Node node = tree1.convertBST(tree1.root);
		tree1.inOrder(node);
	}
}
