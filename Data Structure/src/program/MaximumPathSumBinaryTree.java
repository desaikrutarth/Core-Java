package program;

/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6 (= 2 + 3 + 1)
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42 (= 15 + 7 + 20)
 */
public class MaximumPathSumBinaryTree
{
	Node root = null;
	int maxValue = Integer.MIN_VALUE;
	
    public int maxPathSum(Node root)
    {
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(Node node)
    {
        if (node == null)
        	return 0;
        
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        
        maxValue = Math.max(maxValue, left + right + node.data);
        
        return Math.max(left, right) + node.data;
    }
    
    public static void main(String[] args)
    {
    	MaximumPathSumBinaryTree tree1 = new MaximumPathSumBinaryTree();
		tree1.root = new Node(-10);
		tree1.root.left = new Node(9);
		tree1.root.right = new Node(20);
		tree1.root.right.left = new Node(15);
		tree1.root.right.right = new Node(7);
		
		System.out.println(tree1.maxPathSum(tree1.root));
	}
}
