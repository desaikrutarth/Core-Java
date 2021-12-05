package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Stack;
/*
 Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names.
The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

Example 1:
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:
Input: "/a/./b/../../c/"
Output: "/c"

Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */ 
public class AbsolutePathLinux
{
	public static String simplifyPath(String path)
	{
		Stack<String> stack = new Stack<>();
		
		for(String split : path.split("/"))
		{
			if(split.equals("")||split.equals("."))
				continue;
			else if(split.equals(".."))
			{
				if(!stack.isEmpty())
					stack.pop();
			}
			else
				stack.push(split);
		}
		
		StringBuilder resultPath = new StringBuilder();
		while(!stack.isEmpty())
			resultPath.insert(0, "/").insert(1, stack.pop());
		
		return resultPath.toString();
	}
	
	/*public static String simplifyPath(String path)
	{
		LinkedList<String> linkList = new LinkedList<String>();
	    for (String split : path.split("/"))
	    {
	        if (split.equals(""))
	            continue;
	        else if (split.equals("."))
	            continue;
	        else if (split.equals(".."))
	        {
	        	if(!linkList.isEmpty())
	        		linkList.removeLast();
	        }
	        else
	            linkList.addLast(split);
	    }
	    
	    String result = "";
	    
	    while (!linkList.isEmpty())
	        result += "/" + linkList.removeFirst();
	    
	    if (result.length() == 0)
	        return "/";
	    
	    return result;
	}*/
	
	public static void main(String[] args) 
	{
		String path = "../a//b////c/d//././/..";
		System.out.println(simplifyPath(path));
	}
}
