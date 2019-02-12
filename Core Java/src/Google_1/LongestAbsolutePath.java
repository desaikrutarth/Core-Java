package Google_1;

import java.util.Stack;
/*
 *
 The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
            
  the longest absolute path is "dir/subdr2/subsubdir2/file.ext", and its length is 29.
 */
public class LongestAbsolutePath 
{

   public int getLongestAbsolutePath(String input)
   {
      if (input == null || input.length() == 0)
         return 0;
      Stack<String> stack = new Stack<String>();
      int prevTabs = 0;
      for (String path : input.split("\n"))
      {
         String editedPath = path.replaceAll("\t", "");
         int noOfTabs = path.length() - editedPath.length();

         int pops = prevTabs - noOfTabs;

         for (int i = 0; i <= pops && stack.size() > 0; i++) {
            stack.pop();
         }

         stack.push(editedPath);

         prevTabs = noOfTabs;
      }
      
     String str = "";
     while(stack.size() != 0)
    	 str += stack.pop();
     
      return str.length();
   }
   
   public static void main(String[] args)
   {
      String input1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
      String input2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
      LongestAbsolutePath longestAbsolutePath = new LongestAbsolutePath();
//      System.out.println(longestAbsolutePath.getLongestAbsolutePath(input1));
      System.out.println(longestAbsolutePath.getLongestAbsolutePath(input2));
   }
}