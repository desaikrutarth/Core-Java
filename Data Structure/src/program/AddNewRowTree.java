package program;
/*
Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input: 
A binary tree as following:
       4
     /   \
    2     6
   / \   / 
  3   1 5   

v = 1

d = 2

Output: 
       4
      / \
     1   1
    /     \
   2       6
  / \     / 
 3   1   5   

Example 2:
Input: 
A binary tree as following:
      4
     /   
    2    
   / \   
  3   1    

v = 1

d = 3

Output: 
      4
     /   
    2
   / \    
  1   1
 /     \  
3       1
 */
public class AddNewRowTree
{
	Node root = null;
	public Node addOneRow(Node root, int v, int d)
	{
		return dfs(root, null, v, d);
    }
	
	int level=1;
	public Node dfs(Node current, Node parent, int v, int d)
	{
		if(current == null)
			return null;
		
		if(level == d)
		{
			Node leftNewNode = new Node(v);
			Node rightNewNode = new Node(v);

			leftNewNode.left = parent.left;
			rightNewNode.right = parent.right;
			
			parent.left = leftNewNode;
			parent.right = rightNewNode;	
		}
		level++;
		dfs(current.left, current, v, d);
		dfs(current.right, current, v, d);
		
		return current;
	}
	
	//Method 2:
/*	 public TreeNode addOneRow(TreeNode t, int v, int d) {
	        if (d == 1) {
	            TreeNode n = new TreeNode(v);
	            n.left = t;
	            return n;
	        }
	        insert(v, t, 1, d);
	        return t;
	    }

	    public void insert(int val, TreeNode node, int depth, int n) {
	        if (node == null)
	            return;
	        if (depth == n - 1) {
	            TreeNode t = node.left;
	            node.left = new TreeNode(val);
	            node.left.left = t;
	            t = node.right;
	            node.right = new TreeNode(val);
	            node.right.right = t;
	        } else {
	            insert(val, node.left, depth + 1, n);
	            insert(val, node.right, depth + 1, n);
	        }
	    }
*/	
	private void print(Node root)
	{
		if(root==null)
			return;

		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
	
	public static void main(String[] args)
	{
		AddNewRowTree tree1 = new AddNewRowTree();
		tree1.root = new Node(4);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(6);
		tree1.root.left.left = new Node(3);
		tree1.root.left.right = new Node(1);
		tree1.root.right.left = new Node(5);
		
		Node node = tree1.addOneRow(tree1.root, 1, 2);
		tree1.print(node);
	}
}
