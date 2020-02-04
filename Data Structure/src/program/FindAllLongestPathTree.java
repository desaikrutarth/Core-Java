package program;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a binary tree, return all the longest path between any two nodes in a tree. This path may or may not pass through the root. 
Example: 
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5  
Return [4,2,1,3] and [5,2,1,3].
 */



public class FindAllLongestPathTree 
{
	TreeNode root = null;
    public static List<List<Integer>> helperFindPath(TreeNode root, List<List<Integer>> result)
    {
          List<List<Integer>> answer = new ArrayList<>();
          if(root==null)
          {
              List<Integer> list = new ArrayList<>();
              answer.add(list);
              return answer;
          }
          if(root.leftChild==null && root.rightChild==null)
          {
              List<Integer> temp = new ArrayList<>();
              temp.add(root.data);
              answer.add(temp);
              return answer;
          }
        
          List<List<Integer>> left_list = helperFindPath(root.leftChild,result);
          List<List<Integer>> right_list = helperFindPath(root.rightChild,result);
         
          for(List<Integer> left:left_list)
          {
              for(List<Integer> right:right_list)
              {
                  List<Integer> temp = new ArrayList<>();
                  temp.addAll(left);
                  temp.add(root.data);
                  temp.addAll(right);
                  if(result.size()!=0 && result.get(0).size()<temp.size())
                  {
                      result.clear();
                      result.add(temp);
                  }
                  else if(result.size()==0 || result.get(0).size()==temp.size())
                  {
                      result.add(temp);
                  }
                  
                  if(left.size()>right.size())
                  {
                      List<Integer> list = new ArrayList<>();
                      list.add(root.data);
                      list.addAll(left);
                      answer.add(list);
                  }
                  else if(left.size()<right.size())
                  {
                      List<Integer> list = new ArrayList<>();
                      list.add(root.data);
                      list.addAll(right);
                      answer.add(list);
                  }
                  else
                  {
                      List<Integer> list1 = new ArrayList<>();
                      List<Integer> list2 = new ArrayList<>();
                      list1.add(root.data);
                      list1.addAll(left);
                      list2.add(root.data);
                      list2.addAll(right);
                      answer.add(list1);
                      answer.add(list2);
                  }
              }
          }          
          return answer;          
    }
    
    public static List<List<Integer>> findLongestPath(TreeNode root)
	{
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        
        helperFindPath(root,res);
        return res;
    }
    
    public static void main(String[] args)
    {

    	FindAllLongestPathTree tree = new FindAllLongestPathTree();
		tree.root = new TreeNode(1);
		tree.root.leftChild = new TreeNode(2);
		tree.root.rightChild = new TreeNode(3);

		tree.root.leftChild.leftChild = new TreeNode(4);
		tree.root.leftChild.rightChild = new TreeNode(5);
		
		List<List<Integer>> list = findLongestPath(tree.root);
		System.out.println(list);
    	
    }
}
