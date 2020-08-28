package program;
/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees
{	
	 Node root = null;
	 
	 public Node mergeTrees(Node t1, Node t2)
	 {
	     if (t1 == null)
	         return t2;
	     
	     if (t2 == null)
	         return t1;
	     
	     t1.data += t2.data;
	     
	     t1.left = mergeTrees(t1.left, t2.left);
	     t1.right = mergeTrees(t1.right, t2.right);
	     
	     return t1;
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
		 MergeTwoBinaryTrees tree1 = new MergeTwoBinaryTrees();
		 tree1.root = new Node(1);
		 tree1.root.left = new Node(3);
		 tree1.root.right = new Node(2);
		 tree1.root.left.left = new Node(5);
		 
		 MergeTwoBinaryTrees tree2 = new MergeTwoBinaryTrees();
		 tree2.root = new Node(2);
		 tree2.root.left = new Node(1);
		 tree2.root.right = new Node(3);
		 tree2.root.left.right = new Node(4);
		 tree2.root.right.right = new Node(7);
			
		 Node node = tree1.mergeTrees(tree1.root, tree2.root);
		 tree1.inOrder(node);
	 }
}	
