package program;
/*
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as,
the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         3
       /   \
      2     4
     / \   / \
    3   1 6   5
    
Output: 1
Explanation: 
Tilt of node 3 : 0
Tilt of node 1 : 0
Tilt of node 2 : 3 + 1 
Tilt of node 3 : 3 + 1 + 2 = 6

Tilt of node 6 : 0
Tilt of node 5 : 0
Tilt of node 4 : 6 + 5
Tilt of node 3 : 6 + 5 + 4 = 15

Tilt of binary tree : root + |sumOfleftSubTree - sumOfRightSubTree|
                    = 3 + |6-15|
                    = 12

 */
public class BinaryTreeTilt
{	
	Node root = null;
	int tilt = 0;
	
    public int findTilt(Node root)
    {
        traverse(root);
        return tilt;
    }
    
    public int traverse(Node root)
    {
        if (root == null )
            return 0;
        
        int left = traverse(root.left);
        int right = traverse(root.right);
        
        tilt += Math.abs(left-right);
        
        return left + right + root.data;
    }

    public static void main(String[] args)
    {
    	BinaryTreeTilt tree = new BinaryTreeTilt();
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(1);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(5);
		
		System.out.println(tree.findTilt(tree.root));
	}
}
