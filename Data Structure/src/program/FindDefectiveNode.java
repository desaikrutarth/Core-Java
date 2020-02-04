package program;

import java.util.HashSet;
import java.util.Set;


/*
 * You are provided a BST, which is corrupted. One of the nodes in it has 2 parents. 
Let’s say those are parent 1 and parent 2. It is ensured that none 
of these parents will be the ancestor of the other. Identify the node, 
and remove the link of the wrong parent.
 */

public class FindDefectiveNode 
{
	private static Set<Node> visitedSet = new HashSet<>();   
    void fixTreeHelper(Node current, Node parent)
    {
        if (current == null) 
            return;
        
        if (!visitedSet.contains(current))
        {     
        	visitedSet.add(current);
            fixTreeHelper(current.left, current);        
            fixTreeHelper(current.right, current);
        } 
        else
        {
            if (parent.left == current) 
                parent.left = null;
            else if (parent.right == current) 
                parent.right = null;
            
        }
    }

	private void print(Node root)
	{
		if(root==null)
			return;

		print(root.left);
		System.out.print(root.data+"\t");
		print(root.right);
	}
	
	public static void main(String args[])
	{
		Node root= new Node(3);
		root.left = new Node(1);
		root.right = new Node(6);
		root.left.right = new Node(2);
		root.right.left = root.left.right;

		FindDefectiveNode f = new FindDefectiveNode();
		f.print(root);
	//	f.fix(root, Integer.MIN_VALUE, Integer.MAX_VALUE, null);
		f.fixTreeHelper(root,null);
		System.out.println();
		f.print(root);

	}
}


