package program;

import java.util.ArrayList;
import java.util.List;
/*
Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Input: [1,null,3,2,4,null,5,6]

		   1
         / | \
        3  2  4
       / \     
      5   6   

Output: 3
 */
class Nodde
{
    public int val;
    public List<Nodde> children;

    public Nodde() {}

    public Nodde(int _val)
    {
        val = _val;
    }

    public Nodde(int _val, List<Nodde> _children)
    {
        val = _val;
        children = _children;
    }
}

public class MaxDepthOfN_aryTree
{
	public int maxDepth(Nodde root)
	{
	    if(root == null) return 0;
	    int max = 0;
	    for(Nodde node : root.children)
	    {
	         if(node != null)
	             max = Math.max(max, maxDepth(node));
	    }
	    return 1 + max;
	}
	 
	public static void main(String[] args)
	{
		List<Nodde> children = new ArrayList<Nodde>();
		children.add(new Nodde(3));
		children.add(new Nodde(2));
		children.add(new Nodde(4));
		Nodde node1 = new Nodde(1, children);
		
		List<Nodde> children2 = new ArrayList<Nodde>();
		children2.add(new Nodde(5));
		children2.add(new Nodde(6));
		
		node1.children.addAll(0, children2);
		
		System.out.println(new MaxDepthOfN_aryTree().maxDepth(node1));
	}
}
