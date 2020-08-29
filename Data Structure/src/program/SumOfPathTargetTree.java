package program;
import java.util.ArrayList;
import java.util.List;
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class SumOfPathTargetTree
{
	Node root = null;
	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(Node root, int sum)
    {
		dfs(root, sum, 0, new ArrayList<Integer>());
		return resultList;
    }
	
	private void dfs(Node root, int target, int sum, List<Integer> list)
	{
		if(root == null)
			return;
		
		sum += root.data;
		list.add(root.data);
		
		if(root.left == null && root.right == null)
		{
			if(sum == target)
				resultList.add(new ArrayList<Integer>(list));
		}
		dfs(root.left, target, sum, list);
		dfs(root.right, target, sum, list);
		
		//BackTrack
		list.remove(list.indexOf(root.data));
	}

	public static void main(String[] args)
	{
		SumOfPathTargetTree tree1 = new SumOfPathTargetTree();
		tree1.root = new Node(5);
		tree1.root.left = new Node(4);
		tree1.root.right = new Node(8);
		tree1.root.left.left = new Node(11);
		tree1.root.right.left = new Node(13);
		tree1.root.right.right = new Node(4);
		tree1.root.left.left.left = new Node(7);
		tree1.root.left.left.right = new Node(2);
		tree1.root.right.right.left = new Node(5);
		tree1.root.right.right.right = new Node(1);
		
		System.out.println(tree1.pathSum(tree1.root, 22));
	}
}
