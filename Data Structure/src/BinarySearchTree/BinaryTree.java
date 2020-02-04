package BinarySearchTree;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree 
{
	//Insert a node in binary tree
	Node root = null;
    public Node insertCompleteTree(int data)
    {
    	Node newNode = new Node();
    	newNode.data = data;
        if(root == null)
        {
        	root = newNode;
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                Node current = queue.remove();
                if(current.leftChild == null)
                {
                    current.leftChild = newNode;
                    return root;
                }
                else
                {
                    queue.add(current.leftChild);
                }
                
                if(current.rightChild == null)
                {
                    current.rightChild = newNode;
                    return root;
                }
                else
                {
                    queue.add(current.rightChild);
                }
            }
        }
        return null;
    }
    
    public void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.rightChild);
		}
	}
    
    public ArrayList<ArrayList<Integer>> levelOrder(Node root)
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                Node cur = q.remove();
                list.add(cur.data);
                if(cur.leftChild != null){
                    q.add(cur.leftChild);
                }
                
                if(cur.rightChild != null){
                    q.add(cur.rightChild);
                }
            }
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args)
    {
    	BinaryTree tree = new BinaryTree();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        for(int num : nums)
        {
        	tree.root = tree.insertCompleteTree(num);
          //  System.out.println(tree.levelOrder(root));
        }
        System.out.print("Inorder Traversal: ");
        tree.inOrder(tree.root);
    }
}
