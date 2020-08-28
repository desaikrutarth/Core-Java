package program;

/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
 	1
   / \
  2   3
   \   \
    4   5

Input: root = [1,2,3,4,5], x = 4, y = 5
Output: true

Input: root = [1,2,3,4,5], x = 4, y = 3
Output: false
 */
public class CheckCousinNodesTree
{
	TreeNode xParent = null;
    TreeNode yParent = null;
    TreeNode root = null;
    
    int xDepth = -1, yDepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y)
    {
        getDepthAndParent(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    public void getDepthAndParent(TreeNode current, TreeNode parent, int x, int y, int depth)
    {
        if(current == null)
            return;
        
        if(current.data == x)
        {
            xParent = parent;
            xDepth = depth;
        }
        else if(current.data == y)
        {
            yParent = parent;
            yDepth = depth;
        }       
        getDepthAndParent(current.leftChild, current, x, y, depth + 1);
        getDepthAndParent(current.rightChild, current, x, y, depth + 1);
    }
    
    public static void main(String[] args)
    {
    	CheckCousinNodesTree tree = new CheckCousinNodesTree();
		 tree.root = new TreeNode(1);
		 tree.root.leftChild = new TreeNode(2);
		 tree.root.rightChild = new TreeNode(3);
		 tree.root.leftChild.rightChild = new TreeNode(4);
		 tree.root.rightChild.rightChild = new TreeNode(5);
			
		 System.out.println(tree.isCousins(tree.root, 5, 4));
	}
}
