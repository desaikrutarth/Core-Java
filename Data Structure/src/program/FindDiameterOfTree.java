package program;
/*
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class FindDiameterOfTree
{
	 int ans;
	 Node root = null;
	 
	 public int findLongestPath(Node root)
	 {
		 ans = 0;
		 if(root == null)
			 return ans;
		 
	     depth(root);
	     return ans - 1;	// Numbers of edges are one less than their nodes
	 }
	 
	 public int depth(Node node)
	 {
		 if (node == null)
	        return 0;
		 
	     int L = depth(node.left);
	     int R = depth(node.right);
	     ans = Math.max(ans, L+R+1);		// If diameter passes from the root, then +1 is including a root
	     
	     return Math.max(L, R) + 1;			// Find maximum height of a subtree
	 }
    
    public static void main(String[] args)
    {
    	FindDiameterOfTree tree = new FindDiameterOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		System.out.println(tree.findLongestPath(tree.root));
    }
}
