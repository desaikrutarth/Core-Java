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
public class GoogleInterview
{
	class Node {
		  Node left;
		  Node right;
		}
	
	public boolean isBalanced(Node node)
	{
		int lh;  // for height of left subrtree
		int rh;   // for height of right subtree

		//base case if the tree is empty then return true
		if(node == null) {
			return true;
	}

	// Get the height of left and right sub trees
	lh = height(node.left);
	rh = height(node.right);

	if(Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
		return true;
	}

	// if we reach here tree is not height balnced.
	return false;
	}

	private int height(Node node)
	{
		//base case
		if(node == null) {
			return 0;
	}

	//if tree is not empty then height = 1 + max of left height and right heights.
	return 1 + Math.max(height(node.left), height(node.right));
	}
}
