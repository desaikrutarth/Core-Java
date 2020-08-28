package program;
/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()".
And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originally it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class ConstructStringFromBinaryTree
{
	Node root = null;
	
	public String construct(Node root)
	{
		if(root==null)
	        return "";
		
	    if(root.left==null && root.right==null)
	        return root.data+"";
	    
	    if(root.right==null)
	        return root.data+"("+construct(root.left)+")";
	    
	    return root.data+"("+construct(root.left)+")("+construct(root.right)+")"; 
	}
	
	
	public static void main(String[] args)
	{
		ConstructStringFromBinaryTree tree1 = new ConstructStringFromBinaryTree();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.left = new Node(4);
		
		System.out.println(tree1.construct(tree1.root));
	}
}
