package program;
/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
   
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
  */
public class SwapAndRecoverBST
{
	TreeNode root = null;
	TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root)
    {
        // In order traversal to find the two elements
        traverse(root);
        
        // Swap the values of the two nodes
        int temp = firstElement.data;
        firstElement.data = secondElement.data;
        secondElement.data = temp;
    }
    
    private void traverse(TreeNode root)
    {
        
        if (root == null)
            return;
            
        traverse(root.leftChild);
        
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.data >= root.data)
            firstElement = prevElement;
    
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.data >= root.data)
            secondElement = root;

        prevElement = root;

        traverse(root.rightChild);
	}
    
    public void inOrder(TreeNode localRoot)
   	{
   		if(localRoot != null)
   		{
   			inOrder(localRoot.leftChild);
   			System.out.print(localRoot.data+" ");
   			inOrder(localRoot.rightChild);
   		}
   	}
    
    public static void main(String[] args)
    {
    	SwapAndRecoverBST tree = new SwapAndRecoverBST();
		tree.root = new TreeNode(3);
		tree.root.leftChild = new TreeNode(1);
		tree.root.rightChild = new TreeNode(4);
		tree.root.rightChild.leftChild = new TreeNode(2);
		
		System.out.println("Original Tree:");
		tree.inOrder(tree.root);
		
		tree.recoverTree(tree.root);
		
		System.out.println();
		System.out.println("Updated Tree:");
		tree.inOrder(tree.root);
		
	}
}
