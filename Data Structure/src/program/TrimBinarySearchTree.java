package program;
/*
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
       
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 */
public class TrimBinarySearchTree
{
	TreeNode root = null;
	public TreeNode trimBST(TreeNode root, int L, int R)
	{
        if (root == null)
        	return root;
        
        if (root.data > R)
        	return trimBST(root.leftChild, L, R);		//Trim right node
        
        if (root.data < L)
        	return trimBST(root.rightChild, L, R);		//Trim left node

        root.leftChild = trimBST(root.leftChild, L, R);
        root.rightChild = trimBST(root.rightChild, L, R);
        
        return root;
    }
	
	private void inorder(TreeNode root)
	{
		if(root!=null)
		{
			inorder(root.leftChild);
			System.out.print(root.data+" ");
			inorder(root.rightChild);
		}
	}
	
	public static void main(String[] args)
	{
		TrimBinarySearchTree tree = new TrimBinarySearchTree();
		 tree.root = new TreeNode(3);
		 tree.root.leftChild = new TreeNode(0);
		 tree.root.rightChild = new TreeNode(4);
		 tree.root.leftChild.rightChild = new TreeNode(2);
		 tree.root.leftChild.rightChild.leftChild = new TreeNode(1);
			
		 TreeNode node = tree.trimBST(tree.root, 1, 3);
		 tree.inorder(node);
	}
}
