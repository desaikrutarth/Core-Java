package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
	Node root = null;
	Map<Integer, List<Integer>> map = new HashMap<>();
	
	public List<List<Integer>> zigzagLevelOrder(Node root)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(root, 0);
		
		boolean toggle = false;
		for(List<Integer> values : map.values())
		{
			if(toggle)
			{
				Collections.reverse(values);
				toggle = false;
			}
			else
				toggle = true;
			
			result.add(values);
		}
		return result;
    }
	
	public void dfs(Node root, int level)
	{
		if(root != null)
		{
			map.computeIfAbsent(level, (list) -> new ArrayList<>());
			map.get(level).add(root.data);
			
			dfs(root.left, level+1);
			dfs(root.right, level+1);
		}
	}
	
	public static void main(String[] args)
	{
		BinaryTreeZigzagLevelOrderTraversal tree1 = new BinaryTreeZigzagLevelOrderTraversal();
		tree1.root = new Node(3);
		tree1.root.left = new Node(9);
		tree1.root.right = new Node(20);
		tree1.root.right.left = new Node(15);
		tree1.root.right.right = new Node(7);
		
		System.out.println(tree1.zigzagLevelOrder(tree1.root));
	}
}
