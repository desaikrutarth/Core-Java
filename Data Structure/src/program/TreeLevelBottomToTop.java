package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class TreeLevelBottomToTop
{
	Node root = null;
	Map<Integer, List<Integer>> levels = new HashMap<>();
	
	public List<List<Integer>> levelOrderBottom(Node root)
	{
        traverseLevels(root, 0);
        
        return levels.entrySet()
            .stream().sorted(Map.Entry.<Integer, List<Integer>>comparingByKey().reversed())
            .map(entry -> entry.getValue())
            .collect(Collectors.toList());
    }
    
    public void traverseLevels(Node root, int level)
    {
        if(root == null) 
            return;
        
        traverseLevels(root.left, level+1);
        
        levels.computeIfAbsent(level, (list) -> new ArrayList<>());
        levels.get(level).add(root.data);
        
        traverseLevels(root.right, level+1);
    }
    
    public static void main(String[] args)
    {
    	TreeLevelBottomToTop tree = new TreeLevelBottomToTop();
		tree.root = new Node(3);
		tree.root.left = new Node(9);
		tree.root.right = new Node(20);
		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(7);
		
		List<List<Integer>> list= tree.levelOrderBottom(tree.root);
    	System.out.println(list);
	}
}
