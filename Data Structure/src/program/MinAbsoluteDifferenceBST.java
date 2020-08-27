package program;

import java.util.ArrayList;
/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

    236
   /   \
  104  701
   \    \
   227  911

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */
public class MinAbsoluteDifferenceBST
{
	TreeNode root = null;
	int mindiff = Integer.MAX_VALUE;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
    public int getMinimumDifference(TreeNode root)
    {
        dfs(root); 
        
        for(int i=1; i<list.size(); i++)
        {
        	int diff = list.get(i) - list.get(i-1);
        	mindiff = Math.min(diff, mindiff);
        }
        return mindiff;      
    }
    
    public void dfs(TreeNode current)
    {
        if(current == null)
            return;
        
        dfs(current.leftChild);
        list.add(current.data);
        dfs(current.rightChild);
    }
    
    public static void main(String[] args)
    {
    	MinAbsoluteDifferenceBST tree1 = new MinAbsoluteDifferenceBST();
		tree1.root = new TreeNode(236);
		tree1.root.leftChild = new TreeNode(104);
		tree1.root.rightChild = new TreeNode(701);
		tree1.root.leftChild.rightChild = new TreeNode(227);
		tree1.root.rightChild.rightChild = new TreeNode(911);
		
		System.out.println();
		System.out.println(tree1.getMinimumDifference(tree1.root));
	}
}
