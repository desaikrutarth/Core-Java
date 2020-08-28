package program;

import java.util.Set;
import java.util.TreeSet;
/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
 

Example 2:

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class SecondMinimumNodeTree
{
	Set<Integer> set = new TreeSet<>();
	Node root = null;
	
    public int findSecondMinimumValue(Node root)
    {
    	dfs(root); 
        
        if(set.size() > 1)
        {
            int count=0;
            for(int element : set)
            {
                if(++count == 2)
                    return element;
            }
        }
        return -1;
    }
    
    public void dfs(Node root)
    {
        if(root != null)
        {
            set.add(root.data);
            dfs(root.left);
            dfs(root.right);
        }
    }
    
    public static void main(String[] args)
    {
    	SecondMinimumNodeTree tree = new SecondMinimumNodeTree();
		tree.root = new Node(2);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(7);
		
		System.out.println(tree.findSecondMinimumValue(tree.root));
	}
}
