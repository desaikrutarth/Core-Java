package program;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

      5
     /  \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
 */
public class IncreasingOrderBST
{
	Node root = null;
	
	public Node increasingBST(Node root)
    {
		Queue<Node> queue = new LinkedList<Node>();
		dfs(root, queue);
		
		Node dummyNode = new Node(0);
		Node current = dummyNode;
		
		while(!queue.isEmpty())
		{
			Node node = queue.remove();
			current.right = new Node(node.data);
			current = current.right;
		}
		return dummyNode.right;
    }
	
	public void dfs(Node root, Queue<Node> queue)
	{
		if(root == null)
			return;
		
		dfs(root.left, queue);
		queue.add(root);
		dfs(root.right, queue);
	}
	
	public void inOrder(Node root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void main(String[] args)
	{
		IncreasingOrderBST tree = new IncreasingOrderBST();
		tree.root = new Node(5);
		tree.root.left = new Node(3);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(4);
		tree.root.right.right = new Node(8);	
		tree.root.left.left.left = new Node(1);
		tree.root.right.right.left = new Node(7);
		tree.root.right.right.right = new Node(9);
		
		Node node = tree.increasingBST(tree.root);
		tree.inOrder(node);
	}
}
