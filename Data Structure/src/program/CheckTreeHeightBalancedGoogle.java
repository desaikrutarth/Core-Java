package program;
/*
Please write code that checks if a given binary tree happens to satisfy the following balance condition:
at any node in the tree, the height of its two subtrees differ in height by no more than 1. Your function should take a tree Node as input.

 	 *
    / \
   *   *

     *
    / \
   *   *
  /
 *

     *
    / \
   *   *
  /     \
 *       *

     *
    /
   *
  /
 *

not balanced

     *
    / \
   *   *
  /     \
 *       *
          \
           *

not balanced

 */
public class CheckTreeHeightBalancedGoogle
{
	Node root = null;
	private int helper(Node root, int height)
	{
	    if (root == null)
	    {
	        return height;
	    }
	    
	    int leftTree = helper(root.left, height + 1);
	    int rightTree = helper(root.right, height + 1);
	    
	    if (leftTree < 0 || rightTree < 0 || Math.abs(leftTree - rightTree) > 1)
	    {
	        return -1;
	    }
	    
	    return Math.max(leftTree, rightTree);
	}

	public boolean isBalanced(Node root)
	{
	    return helper(root, 0) >= 0;
	}
	
	public static void main(String[] args)
	{
		CheckTreeHeightBalancedGoogle tree = new CheckTreeHeightBalancedGoogle();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.right = new Node(5);
		tree.root.right.right.right = new Node(6);
		
		System.out.println(tree.isBalanced(tree.root));
	}
}
