package program;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 */
public class CheckMirrorTree
{
	Node root = null;
	
	public boolean isSymmetric(Node root)
	{
	    return isMirror(root, root);
	}

	public boolean isMirror(Node t1, Node t2)
	{
	    if (t1 == null && t2 == null)
	    	return true;
	    
	    if (t1 == null || t2 == null)
	    	return false;
	    
	    if((t1.data == t2.data)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right)) {
	    	return true;
	    }
	    return false;
	}
	
	// Method 2:
/*	public boolean isSymmetric(Node root)
	{
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    
	    while (!q.isEmpty())
	    {
	    	Node t1 = q.poll();
	    	Node t2 = q.poll();
	    	
	        if (t1 == null && t2 == null)
	        	continue;
	        if (t1 == null || t2 == null)
	        	return false;
	        if (t1.data != t2.data) 
	        	return false;
	        
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    return true;
	}*/
	
	public static void main(String[] args)
	{
		CheckMirrorTree tree1 = new CheckMirrorTree();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(2);
		tree1.root.left.left = new Node(3);
		tree1.root.left.right = new Node(4);
		tree1.root.right.left = new Node(4);
		tree1.root.right.right = new Node(3);
		
		System.out.println(tree1.isSymmetric(tree1.root));
	}
}
