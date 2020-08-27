package program;

import java.util.Arrays;
import java.util.HashMap;

/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:

    1
   / \
  2   2
 / \ / \
3  4 4  5
 

return [2,4].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeBST
{
	TreeNode root = null;
	HashMap<Integer, Integer> map = new HashMap<>();
    int maxval = Integer.MIN_VALUE;
    
    public int[] findMode(TreeNode root)
    {
    	dfs(root);
        int[] result = new int[map.size()];
        int index=0;
        
        if(map.size() == 1)
        {
            result[index++] = root.data;
            return result;
        }
        
        for(int val : map.values())
        {
            maxval = Math.max(val, maxval);
        }
        
        for(int key : map.keySet())
        {
            if(map.get(key) == maxval)
                result[index++] = key;
        }
        
        result = Arrays.copyOf(result, index);
        return result;
    }
    
    public void dfs(TreeNode node)
    {
        if(node == null)
            return;
        
        map.put(node.data, map.getOrDefault(node.data, 0)+1);
        
        dfs(node.leftChild);
        dfs(node.rightChild);
    }
    
    public static void main(String[] args)
    {
    	FindModeBST tree1 = new FindModeBST();
		tree1.root = new TreeNode(1);
		tree1.root.leftChild = new TreeNode(2);
		tree1.root.rightChild = new TreeNode(2);
		tree1.root.leftChild.leftChild = new TreeNode(3);
		tree1.root.leftChild.rightChild = new TreeNode(4);
		tree1.root.rightChild.leftChild = new TreeNode(4);
		tree1.root.rightChild.rightChild = new TreeNode(5);
		
		System.out.println(Arrays.toString(tree1.findMode(tree1.root)));
	}
}
