package program;

import java.util.LinkedList;
import java.util.Queue;
/*
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

Tree1:
  		 3
       /   \
      5     1
     / \   / \
    6   2 9   8
    
Tree2:
  		 4
       /   \
      3     5
     / \   / \
    6   2 9   8


For example, in the given tree above, the leaf value sequence is (6, 2, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilarTrees
{
	Node root = null;
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public boolean leafSimilar(Node n1, Node n2)
	{
	    dfs(n1,n2);
	    return q1.equals(q2);
	}

	public void dfs(Node root1, Node root2)
	{
	    if(root1 == null || root2 == null)
	      return;
	      
	    if(root1.left == null && root1.right == null)
	      q1.add(root1.data);
	      
	    if(root2.left == null && root2.right == null)
	      q2.add(root2.data);
	      
	    dfs(root1.left, root2.left);
	    dfs(root1.right, root2.right);
	}
	
/*	public boolean leafSimilar(Node root1, Node root2)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }
    
    public void dfs(Node node, List<Integer> list)
    {
        if(node == null)
            return;
        
        if(node.left == null && node.right == null)
            list.add(node.data);
        
        dfs(node.left, list);
        dfs(node.right, list);
    }
 */   
    public static void main(String[] args)
    {
    	LeafSimilarTrees tree1 = new LeafSimilarTrees();
		tree1.root = new Node(3);
		tree1.root.left = new Node(5);
		tree1.root.right = new Node(1);
		tree1.root.left.left = new Node(6);
		tree1.root.left.right = new Node(2);
		tree1.root.right.left = new Node(9);
		tree1.root.right.right = new Node(8);
		
		LeafSimilarTrees tree2 = new LeafSimilarTrees();
		tree2.root = new Node(4);
		tree2.root.left = new Node(3);
		tree2.root.right = new Node(5);
		tree2.root.left.left = new Node(6);
		tree2.root.left.right = new Node(2);
		tree2.root.right.left = new Node(9);
		tree2.root.right.right = new Node(8);
		
		System.out.println(tree1.leafSimilar(tree1.root, tree2.root));
	}
}
