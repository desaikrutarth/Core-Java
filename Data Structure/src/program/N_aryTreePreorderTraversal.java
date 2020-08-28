package program;

import java.util.ArrayList;
import java.util.List;
/*
Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Input: [1,null,3,2,4,null,5,6]

		   1
         / | \
        3  2  4
       / \     
      5   6   

Output: [1,3,5,6,2,4]

Follow up:

Recursive solution is trivial, could you do it iteratively?
 */
public class N_aryTreePreorderTraversal
{
	//Pre-Order Traversal
	List<Integer> preorderList = new ArrayList<>();
    public List<Integer> preorder(Nodde root)
    {
    	if(root == null)
    		return preorderList;
    	
        preorderList.add(root.val);
        if(root.children != null)
        {
        	for(Nodde node : root.children){
        		preorder(node);
        	}
        }
        return preorderList;
    }
    
    //Post-Order Traversal
    List<Integer> postorderList = new ArrayList<>();
    public List<Integer> postorder(Nodde root)
    {
    	if(root == null)
    		return postorderList;
    	
        if(root.children != null)
        {
        	for(Nodde node : root.children){
        		postorder(node);
        	}
        }
        postorderList.add(root.val);
        return postorderList;
    }
    
    public static void main(String[] args)
	{
		List<Nodde> children = new ArrayList<Nodde>();		
		children.add(new Nodde(3));
		children.add(new Nodde(2));
		children.add(new Nodde(4));
		Nodde node1 = new Nodde(1, children);
		
		Nodde node2 = node1.children.get(0);
		node2.children = new ArrayList<Nodde>();
		node2.children.add(new Nodde(5));
		node2.children.add(new Nodde(6));
		
		N_aryTreePreorderTraversal tree = new N_aryTreePreorderTraversal();
		
		System.out.println("Pre-Order: "+tree.preorder(node1));
		System.out.println("Post-Order: "+tree.postorder(node1));
	}
}
