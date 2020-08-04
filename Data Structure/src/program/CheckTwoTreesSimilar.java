package program;
/*
 * Two binary tree, to determine whether the two trees "similar", similar refers to the corresponding node in each tree in the left child and right child can be the same or in the opposite order, such as the following two trees, D, E where DE And DE can also be DE and ED, BC is the same, but the parent child relationship must be the same. 
Followup is if left and right can be the same how to do,

Tree1:
	A
   / \
  B   C
 / \
D   E

Tree2:
    A
   / \
  C   B
     / \
    D   E
 */


public class CheckTwoTreesSimilar
{
	Node root = null;
	
	static boolean isSimilar(Node root1, Node root2)
	{

		if( root1 == null && root2 == null )
			return true;
		
		if( root1 == null || root2 == null )
			return false;
	
		if((root1.data == root2.data))
		{
			if(isSimilar(root1.left, root2.left) && isSimilar(root1.right, root2.right))
				return true;
			
			if(isSimilar(root1.left, root2.right) && isSimilar(root1.right, root2.left ))
				return true;
		}
		return false;
	}
	
/*	static boolean isSimilar(Node root1, Node root2)
	{

		if( root1 == null && root2 == null )
			return true;
		else if( root1 == null || root2 == null )
			return false;
	
		if( (root1.data == root2.data) 
				&& ( ( isSimilar(root1.left, root2.left) && isSimilar(root1.right, root2.right) ) 
						|| ( isSimilar(root1.left, root2.right) && isSimilar(root1.right, root2.left )) )){
	
			return true;	
		}
		
		return false;
	}*/
	
	public static void main(String[] args)
	{
		CheckTwoTreesSimilar tree1 = new CheckTwoTreesSimilar();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.left = new Node(4);
		tree1.root.left.right = new Node(5);
		
		CheckTwoTreesSimilar tree2 = new CheckTwoTreesSimilar();
		tree2.root = new Node(1);
		tree2.root.left = new Node(3);
		tree2.root.right = new Node(2);
		tree2.root.right.left = new Node(4);
		tree2.root.right.right = new Node(5);
		
		System.out.println(isSimilar(tree1.root, tree2.root));

	}
}
