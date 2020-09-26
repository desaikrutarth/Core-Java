package program;
/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
 
Output: true
 
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Output: false.
 */
public class SubtreeOfAnotherTree
{
	 TreeNode root;
	 public boolean traverse(TreeNode s,TreeNode t)
	 {
	     return  s!=null && (equals(s,t)
	    		 			|| traverse(s.leftChild,t)
	    		 			|| traverse(s.rightChild,t));
	 }
	 
	 public boolean equals(TreeNode x,TreeNode y)
	 {
	     if(x==null && y==null)
	         return true;
	     if(x==null || y==null)
	         return false;
	     if(x.data==y.data
	    		 && equals(x.leftChild,y.leftChild)
	    		 && equals(x.rightChild,y.rightChild))
	    	 return true;
	     
	     return false;
	 }
	 
/*	 public boolean isSubtree(TreeNode n1, TreeNode n2)
	 {
	     String s1 = buildString(n1,"");
	     String s2 = buildString(n2,"");
	       
	     return s1.contains(s2);
	 }
	    
	 public String buildString(TreeNode node, String append)
	 {
	     if(node != null)
	     {
	         append = buildString(node.leftChild, append);
	         append += String.valueOf(node.data);
	         append = buildString(node.rightChild, append);
	     }
	     return append;
	 }
*/	 
	 public static void main(String[] args)
	 {
		 SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();
		 tree.root = new TreeNode(3);
		 tree.root.leftChild = new TreeNode(4);
		 tree.root.rightChild = new TreeNode(5);
		 tree.root.leftChild.leftChild = new TreeNode(1);
		 tree.root.leftChild.rightChild = new TreeNode(2);
		 tree.root.leftChild.rightChild.leftChild = new TreeNode(0);
		 
		 SubtreeOfAnotherTree tree1 = new SubtreeOfAnotherTree();
		 tree1.root = new TreeNode(4);
		 tree1.root.leftChild = new TreeNode(1);
		 tree1.root.rightChild = new TreeNode(2);
		 
		 System.out.println(tree.traverse(tree.root, tree1.root));
	 }
}
