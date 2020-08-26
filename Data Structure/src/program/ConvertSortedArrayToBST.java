package program;
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class ConvertSortedArrayToBST
{
	public Node convert(int[] nums)
	{
        if(nums.length == 0 || nums == null)
        	return null;
        return constructTree(nums, 0, nums.length-1);
    }

    private Node constructTree(int[] nums, int start, int end) 
    {
        //Breaking condition
        if(start > end)
        	return null;
        //Root is at the middle
        int mid = start + (end-start)/2;
        Node root = new Node(nums[mid]);
        
        root.left = constructTree(nums, start, mid-1);
        root.right = constructTree(nums, mid+1, end);

        return root;
    }
	
	public void inOrder(Node root)
	{
		if(root != null)
		{
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public static void main(String[] args)
	{
		ConvertSortedArrayToBST tree = new ConvertSortedArrayToBST();
		int[] arr = {-10,-3,0,5,9};
		Node node = tree.convert(arr);
		tree.inOrder(node);
	}
}
