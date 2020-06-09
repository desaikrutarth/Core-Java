package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class Node
{
	public int data;
	int vd; //vertical distance diagonally
	public Node leftChild;
	public Node rightChild;
	
	public void display()
	{
		System.out.println(data);
	}
}

class Tree
{
	public Node root;
	
	public Tree()
	{
		root = null;
	}
	
	public void insert(int data)
	{
		Node newNode = new Node();
		newNode.data = data;
		
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			Node current = root;
			Node parent;
			
			while(true)
			{
				parent = current;
				
				if(data < current.data)
				{
					current = current.leftChild;
					if(current == null)
					{
						parent.leftChild = newNode;
						break;
					}
				}
				else
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						break;
					}
				}
			}
		}
	}
	
	public Node find(int key)
	{
		Node current = root;
		while(current.data != key)
		{
			if(key < current.data)
			{
				current = current.leftChild;
			}
			else
			{
				current = current.rightChild;
			}
			
			if(current == null)
			{
				System.out.println("nuber not found");
			}
		}
		return current;
	}
	
	public boolean delete(int key)
	{
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.data != key)
		{
			parent = current;
			if(key < current.data)
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else
			{
				isLeftChild = false;
				current = current.rightChild;
			}
		}
		
		if(current.leftChild == null && current.rightChild == null)   // delete leaf node
		{
			if(current == root)
			{
				root = null;
			}
			else if(isLeftChild)
			{
				parent.leftChild = null;
			}
			else
			{
				parent.rightChild = null;
			}
		}
		
		if(current.rightChild == null)				// node having one left child 
		{
			if(current == root)
			{
				root = current.leftChild;
			}
			else if(isLeftChild)
			{
				parent.leftChild = current.leftChild;
			}
			else
			{
				parent.rightChild = current.rightChild;
			}
		}
		
		if(current.leftChild == null)				// node having one right child 
		{
			if(current == root)
			{
				root = current.rightChild;
			}
			else if(isLeftChild)
			{
				parent.leftChild = current.leftChild;
			}
			else
			{
				parent.rightChild = current.rightChild;
			}
		}
		return true;
	}
	
	//Delete a tree
	 void deleteTree(Node node) 
	 {
	        if (node == null)
	            return;
	  
	        /* first delete both subtrees */
	        deleteTree(node.leftChild);
	        deleteTree(node.rightChild);
	  
	        /* then delete the node */
	        System.out.println("The deleted node is " + node.data);
	        node = null;
	 }
	 
	 //Print the shortest path from root to leaf
	 int minLength = Integer.MAX_VALUE;
	 List<Integer> resultList = new ArrayList<Integer>();
	 
	 public void printShortestPathRootToLeaf(Node root)
	 {
		 dfs(root, new ArrayList<Integer>(), 0);
		 System.out.println("Shortest Path from root to Leaf = "+resultList);
	 }
	 
	 public void dfs(Node root, List<Integer> path, int length)
	 {
		 if(root == null)
			 return;
		 
		 path.add(root.data);
		 length++;
		 
		 if(root.leftChild == null && root.rightChild == null)
		 {
			 if(length < minLength)
			 {
				 resultList = new ArrayList<Integer>();
				 resultList.addAll(path);
				 minLength = length;
			 }
		 }
		 
		 dfs(root.leftChild, path, length);
		 dfs(root.rightChild, path, length);
		 //backtrack
		 path.remove(path.indexOf(root.data));
	 }
	 
	 /*Check if two nodes have same parents*/
	 boolean sameParents(Node root, int x, int y)
	 {
			if(root==null)
				return false;
			
			if(root.leftChild==null || root.rightChild == null)
				return false;
			
			if((root.leftChild.data==x && root.rightChild.data==y) || root.leftChild.data==y && root.rightChild.data==x)
				return true;
			
			return (sameParents(root.leftChild,x,y) ||
					sameParents(root.rightChild,x,y));
	 }
	 
	 /*Given a binary tree, output the maximum EVEN sum along any path*/
	 int maxSum = 0;
	 int add = 0;
	 int maxEvenSum(Node node)
	 {
		 if(node != null)
		 {
			 add += node.data;
			 if(add %2 == 0)
			 {
				 if(add > maxSum)
					 maxSum = add;
			 }
			 else
				 add -= node.data;
			 
			 maxEvenSum(node.leftChild);
			 maxEvenSum(node.rightChild);
			 
		 }
		 return maxSum;
	 }
	 
	 /* Write a function to return next largest number form a BST*/
	 int result = 0;
	 int nextLargestVal(Node parentNode, Node childNode)				
	 {	
		 if(parentNode == null || childNode == null)
			 return result;
		 
		 nextLargestVal(parentNode.leftChild, childNode.leftChild);
		 
		 if(childNode.leftChild == null && childNode.rightChild == null)
		 {
			 result = parentNode.data;
			 return result;
		 }
		 
		 nextLargestVal(parentNode.rightChild, childNode.rightChild);
		 
		 return result;
	 }
	 
	 
	 /* find out the n-th node of inorder traversal.*/
	 static int count = 0;
	 void findNthNodeInorder(Node node, int n)
	 {
		 if(node == null)
			 return;
		 
		 if(count <= n)
		 {
			 findNthNodeInorder(node.leftChild, n);
			 count++;
			 
			 if(count == n)
			 {
				 System.out.println(n+"th Node is = "+node.data);
				 return;
			 }
			 findNthNodeInorder(node.rightChild, n);
		 }
		 
	 }
	
	
	/* computes number of nodes in tree */
	int size()
	{
		return size(root);
	}

	int size(Node node)
	{
		if (node == null)
			return 0;
		
		return(size(node.leftChild) 
					+ 1 + size(node.rightChild));
	}
	
	/*Sum of all the numbers that are formed from root to leaf paths*/
	 int treePathsSumUtil(Node node, int val) 
	 {
	        // Base case
	        if (node == null)
	            return 0;
	  
	        // Update val
	        val = (val * 100 + node.data);
	  
	        // if current node is leaf, return the current value of val
	        if (node.leftChild == null && node.rightChild == null)
	            return val;
	  
	        // recur sum of values for left and right subtree
	        return treePathsSumUtil(node.leftChild, val)
	                + treePathsSumUtil(node.rightChild, val);
	   }
	  
	    // A wrapper function over treePathsSumUtil()
	 int treePathsSum(Node node) 
	 {
	        // Pass the initial value as 0 as there is nothing above root
	      return treePathsSumUtil(node, 0);
	 }
	
	/* Sum of all leaf nodes */
	int sum = 0;
	public int sumOfLeafNode(Node root)
	{
		Node current = root;
		
		if (root == null)
			return sum;
		if(current.leftChild == null && current.rightChild == null)
		{
			sum += current.data;
		}
		sum = sumOfLeafNode(current.leftChild);
		sum = sumOfLeafNode(current.rightChild);
		return sum;
	}
	
	/* Sum of all left leaves in a given binary tree */
    boolean isLeaf(Node node) 
    {
        if (node == null)
            return false;
        if (node.leftChild == null && node.rightChild == null)
            return true;
        return false;
    }
    
    int leftLeavesSum(Node node) 
    {
        int sum = 0;
  
        if (node != null) 
        {
            // If left of root is NULL, then add key of left child
            if (isLeaf(node.leftChild))
                sum += node.leftChild.data;
            else // Else recur for left child of root
                sum += leftLeavesSum(node.leftChild);
  
            // Recur for right child of root and update res
            sum += leftLeavesSum(node.rightChild);
        }
  
        return sum;
    }
    
    /*Diagonal Sum of a Binary Tree */
    public void diagonalSum()
    {
        // Queue which stores tree nodes
        Queue<Node> queue = new LinkedList<Node>();
 
        // Map to store sum of node's data lying diagonally
        Map<Integer, Integer> map = new TreeMap<>();
 
        root.vd = 0;
        queue.add(root);
 
        while (!queue.isEmpty())
        {
        	Node current = queue.remove();
            int vd = current.vd;
 
            while (current != null)
            {
                int prevSum = (map.get(vd) == null)? 0: map.get(vd);
                map.put(vd, prevSum + current.data);
 
                if (current.leftChild != null)
                {
                    current.leftChild.vd = vd+1;
                    queue.add(current.leftChild);
                }
 
                current = current.rightChild;
            }
        }
 
      System.out.println("Diagonal sum : ");
      for(int val: map.values())
      {
    	  System.out.println(val);
      }
    }
    

     
    /*find the sum of leaf nodes at minimum level */
    int sumOfLeafNodesAtMinLevel(Node root)
    {
        if (root == null)
            return 0;
     
        if (root.leftChild == null && root.rightChild == null)
            return root.data;
     
        Queue<Node> queue = new LinkedList<Node>();
        int sum = 0; 
        boolean flag = false;
     
        queue.add(root);
     
        while (flag == false) 
        {   
            while (queue.size() != 0)
            { 
                // get front element from 'q'
                Node top = queue.peek();
                queue.remove();
     
                // if it is a leaf node
                if (top.leftChild == null && top.rightChild == null)
                {
                    sum += top.data;
                    flag = true;
                }
                else 
                {
                    if (top.leftChild != null)
                        queue.add(top.leftChild);
                    if (top.rightChild != null)
                        queue.add(top.rightChild);
                }
            }
        }
     
        return sum;
    }
    
    private static Set<Node> visitedSet = new HashSet<>();   

    void fixTreeHelper(Node node)
    {
    	Node parent = root;
        if (node == null) 
            return;
        
        if (!visitedSet.contains(node))
        {
            visitedSet.add(node);
            fixTreeHelper(node.leftChild);
            fixTreeHelper(node.rightChild);
        } 
        else
        {
            if (parent.leftChild == node) 
                parent.leftChild = null;
            else if (parent.rightChild == node) 
                parent.rightChild = null;
            
        }
    }
    
  /*  Print Left View of a Binary Tree */
    static int  max_level = 0;
    void leftView(Node node, int level)
    {
        if (node==null)
        	return;
 
        if (level > max_level)
        {
            System.out.print(" " + node.data);
            max_level = level;
        }
 
        leftView(node.leftChild, level+1);
        leftView(node.rightChild, level+1);
    }
	
    /* In order Traversal*/
	public void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.rightChild);
		}
	}
	
	 /* Pre order Traversal*/
	public void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.data+" ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	 /* Post order Traversal*/
	public void postOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.data+ " ");
		}
	}
	
}
public class BinarySearchTree 
{
	public static void main(String[] args)
	{
		Tree tree = new Tree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(60);
		tree.insert(25);
		tree.insert(35);
		tree.insert(55);
		tree.insert(65);
		tree.insert(31);
		tree.insert(57); 
		System.out.println("The size of binary tree is : "+ tree.size());
		System.out.println("Inorder Traversal:");
		tree.inOrder(tree.root);
		System.out.println();
		
		tree.printShortestPathRootToLeaf(tree.root);
		System.out.println("Are Siblings = "+tree.sameParents(tree.root, 55, 65));
		
		System.out.println();
		System.out.println("Maximum even sum = "+tree.maxEvenSum(tree.root));
		
		System.out.println("Next Largest val = "+tree.nextLargestVal(tree.root, tree.root.leftChild));
		
		
		/*tree.fixTreeHelper(tree.root);
		System.out.println("Inorder Traversal:");
		tree.inOrder(tree.root);*/
		
		System.out.println("sum of leaf node at minimum level = "+tree.sumOfLeafNodesAtMinLevel(tree.root));
		
		tree.diagonalSum();
		System.out.println("Sum of all paths is =" +tree.treePathsSum(tree.root));
		
		tree.findNthNodeInorder(tree.root, 2);
		
		tree.leftView(tree.root, 1);
		System.out.println("The size : "+ tree.size());
		
		System.out.println("The sum of all left leaves is " + tree.leftLeavesSum(tree.root));
		
		int sum = tree.sumOfLeafNode(tree.root);
		System.out.println("Sum of all leaf nodes:"+sum);
		
		tree.deleteTree(tree.root);
		tree.root = null;
        System.out.println("Tree deleted");
		
        System.out.println("The size of binary tree is : "+ tree.size());

		
		
	}
}
