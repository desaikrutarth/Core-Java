package program;
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
	 6
   /  \
  2    8
 / \  / \
0   4 7  9
   / \
  3   5
  
Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 0, q = 5
Output: 2
Explanation: The LCA of nodes 0 and 5 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorTree
{
	 Node root = null; 
	 
	 public Node lowestCommonAncestor(Node root, Node p, Node q)
	 {
		 int pVal = p.data;
         int qVal = q.data;
         Node current = root;

         while (current != null)
	     {
        	 int parentVal = current.data;

	         if (pVal > parentVal && qVal > parentVal) 		// If both p and q are greater than parent
	             current = current.right;
	         else if (pVal < parentVal && qVal < parentVal) 	// If both p and q are lesser than parent
	             current = current.left;
	         else											// We have found the split point, i.e. the LCA node.
	             return current;
	     }
	     return null;
	 }
	 
	 //Method 2:
/*	 public Node lowestCommonAncestor(Node root, Node p, Node q)
	 {
		 int parentVal = root.data;
	     int pVal = p.data;
	     int qVal = q.data;

	     if (pVal > parentVal && qVal > parentVal)				// If both p and q are greater than parent
	    	 return lowestCommonAncestor(root.right, p, q);		 
	     else if (pVal < parentVal && qVal < parentVal)			// If both p and q are lesser than parent
	         return lowestCommonAncestor(root.left, p, q);		 
	     else													// We have found the split point, i.e. the LCA node
	         return root;										
	 }*/
	 
	 public static void main(String[] args)
	 {
		 LowestCommonAncestorTree tree1 = new LowestCommonAncestorTree();
		 tree1.root = new Node(6);
		 tree1.root.left = new Node(2);
		 tree1.root.right = new Node(8);
		 tree1.root.left.left = new Node(0);
		 tree1.root.left.right = new Node(4);
		 tree1.root.right.left = new Node(7);
		 tree1.root.right.right = new Node(9);
		 tree1.root.left.right.left = new Node(3);
		 tree1.root.left.right.right = new Node(5);
			
		 Node node = tree1.lowestCommonAncestor(tree1.root, tree1.root.left.left,  tree1.root.left.right.right);
		 System.out.println(node.data);
	 }
}
