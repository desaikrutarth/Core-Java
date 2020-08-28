package program;

import java.util.HashSet;
import java.util.Set;
/*
Given a Binary Search Tree and a target number,
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class FindTargetSumBST
{
	 TreeNode root = null;
	 Set<Integer> set = new HashSet<>();

	 public boolean findTarget(TreeNode root, int k)
	 {
	     if (root == null)
	         return false;
	     
	     if (set.contains(k - root.data))
	         return true;
	     set.add(root.data);
	     
	     return findTarget(root.leftChild, k)
	    		 || findTarget(root.rightChild, k);
	 }
	 
	 public static void main(String[] args)
	 {
		 FindTargetSumBST tree = new FindTargetSumBST();
		 tree.root = new TreeNode(5);
		 tree.root.leftChild = new TreeNode(3);
		 tree.root.rightChild = new TreeNode(6);
		 tree.root.leftChild.leftChild = new TreeNode(2);
		 tree.root.leftChild.rightChild = new TreeNode(4);
		 tree.root.rightChild.rightChild = new TreeNode(7);
			
		 System.out.println(tree.findTarget(tree.root, 9));
	 }
}
