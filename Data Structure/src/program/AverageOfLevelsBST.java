package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
   
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class AverageOfLevelsBST
{
	TreeNode root = null;
	HashMap<Integer, List<Integer>> map = new HashMap<>();
	
    public List<Double> averageOfLevels(TreeNode root)
    {
        List<Double> result = new ArrayList<>();
        if(root == null)
            return result;
        dfs(root, 0);
        
        for(List<Integer> list : map.values())
        {
            double total = list.stream().mapToDouble(i -> i).sum(); // Calculate sum of all the element on ArrayList
            double avg = total / list.size();
            result.add(avg);
        }
        return result;
    }
    
    public void dfs(TreeNode node, int level)
    {
        if(node == null)
            return;
        
        map.computeIfAbsent(level, (list) -> new ArrayList<>());
        map.get(level).add(node.data);
        
        dfs(node.leftChild, level + 1);
        dfs(node.rightChild, level + 1);        
    }
    
    
    public static void main(String[] args)
    {
    	AverageOfLevelsBST tree = new AverageOfLevelsBST();
		tree.root = new TreeNode(3);
		tree.root.leftChild = new TreeNode(9);
		tree.root.rightChild = new TreeNode(20);
		tree.root.rightChild.leftChild = new TreeNode(15);
		tree.root.rightChild.rightChild = new TreeNode(7);
		
		System.out.println(tree.averageOfLevels(tree.root));
	}
}
