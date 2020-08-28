package program;

/*
Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.
For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
Return the sum of these numbers.
 
Example 1:
 	1
   / \
  0   1
 / \ / \
0  1 0  1


Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */
public class SumRootToLeafBinaryNumbers
{
	int sum = 0;
    Node root = null;
    
    public int sumRootToLeaf(Node root)
    {
        dfs(root,"");
        return sum;
    }
    
    public void dfs(Node root, String binary)
    {
        if(root == null)
            return;
        
        binary += "" + root.data;
        
        if(root.left == null && root.right == null)
        {
            int decimal = Integer.parseInt(binary, 2);	//Convert binary to decimal
            sum += decimal;
        }
        dfs(root.left, binary);
        dfs(root.right, binary);
    }
    
    public static void main(String[] args)
    {
    	SumRootToLeafBinaryNumbers tree1 = new SumRootToLeafBinaryNumbers();
		tree1.root = new Node(1);
		tree1.root.left = new Node(0);
		tree1.root.right = new Node(1);
		tree1.root.left.left = new Node(0);
		tree1.root.left.right = new Node(1);
		tree1.root.right.left = new Node(0);
		tree1.root.right.right = new Node(1);
		
		System.out.println(tree1.sumRootToLeaf(tree1.root));
	}
}
