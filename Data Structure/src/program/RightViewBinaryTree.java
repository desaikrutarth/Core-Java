package program;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \   / \
  5 6   4       <---
 */
public class RightViewBinaryTree
{
	Node root = null;
	List<Integer> result = new ArrayList<Integer>();
	public List<Integer> rightSideView(Node root)
	{
        rightView(root, 0);
        return result;
    }
    
    public void rightView(Node curr, int currDepth)
    {
        if(curr == null)
            return;
        
        if(currDepth == result.size())
            result.add(curr.data);
        
        rightView(curr.right, currDepth + 1);
        rightView(curr.left, currDepth + 1);
    }
    
    public static void main(String[] args)
    {
    	RightViewBinaryTree tree1 = new RightViewBinaryTree();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.right = new Node(5);
		tree1.root.right.left = new Node(6);
		tree1.root.right.right = new Node(4);
		
		System.out.println(tree1.rightSideView(tree1.root));
	}
}
