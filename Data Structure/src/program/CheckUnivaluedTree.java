package program;

import java.util.HashSet;
import java.util.Set;
/*
A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.
Example 1:

	1
   / \
  1   1
 / \ / \
1  1 1  1
Input: [1,1,1,1,1,1,1]
Output: true

Example 2:
	
	1
   / \
  1   1
 / \ / \
2  1 1  1
Input: [1,1,2,1,1,1,1]
Output: false
 */
public class CheckUnivaluedTree
{
	TreeNode root = null;
	Set<Integer> set = new HashSet<Integer>();
	public boolean isUnivalTree(TreeNode root)
    {
        if(root == null)
            return false;
        
        dfs(root);
        return set.size() == 1;
    }
    
    public void dfs(TreeNode node)
    {
        if(node != null)
        {
        	set.add(node.data);
        	dfs(node.leftChild);
        	dfs(node.rightChild);
        }
    }
    
    public static void main(String[] args)
    {
    	CheckUnivaluedTree tree = new CheckUnivaluedTree();
		tree.root = new TreeNode(1);
		tree.root.leftChild = new TreeNode(1);
		tree.root.rightChild = new TreeNode(1);
		tree.root.rightChild.leftChild = new TreeNode(1);
		tree.root.rightChild.rightChild = new TreeNode(1);
		
		System.out.println(tree.isUnivalTree(tree.root));
	}
}
