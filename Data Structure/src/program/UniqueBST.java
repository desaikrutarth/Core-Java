package program;

import java.util.LinkedList;
import java.util.List;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBST
{
	public List<Node> generateTrees(int n)
	{
		return generateSubtrees(1, n);
	}

	private List<Node> generateSubtrees(int s, int e)
	{
		List<Node> res = new LinkedList<Node>();
		if (s > e)
		{
			res.add(null); // empty tree
			return res;
		}

		for (int i = s; i <= e; i++)
		{
			List<Node> leftSubtrees = generateSubtrees(s, i - 1);
			List<Node> rightSubtrees = generateSubtrees(i + 1, e);

			for (Node left : leftSubtrees)
			{
				for (Node right : rightSubtrees)
				{
					Node root = new Node(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
	
	private void print(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.data+" ");
			print(root.left);
			print(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		UniqueBST tree = new UniqueBST();
		List<Node> nodeList = tree.generateTrees(3);
		
		for(Node node : nodeList)
		{
			tree.print(node);
			System.out.println();
		}
	}
}
