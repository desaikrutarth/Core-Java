package FaceBook;

import java.util.Stack;
/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.
For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}.
The largest possible rectangle possible is 12 (see the below figure, the max area rectangle is highlighted in red)
| 
|  _				 _
| |6|    _     _    |6|
| | |   |5| _ |5|   | |
| | | _ | ||4|| |   | |
| | ||2|| || || | _ | |
| | || || || || ||1|| |
---------------------------
 */
public class LargestRectangularAreaHistogram
{
	static int getMaxArea(int height[])  
    { 
		int n = height.length;
        // Create an empty stack. The stack holds indexes of hist[] array, 
        // The bars stored in stack are always in increasing order of their heights. 
        Stack<Integer> stack = new Stack<>(); 
          
        int maxArea = 0;
        int top; 
        int area_with_top; // To store area with top bar as the smallest bar 
       
        // Run through all bars of given histogram 
        int index = 0; 
        while (index < n) 
        { 
            // If this bar is higher than the bar on top stack, push it to stack 
            if (stack.empty() || height[stack.peek()] <= height[index]) 
                stack.push(index++); 
       
            // If this bar is lower than top of stack,  
            // then calculate area of rectangle with stack top as the smallest (or minimum height) bar.   
            // 'index' is 'right index' for the top and element before top in stack is 'left index' 
            else
            { 
                top = stack.peek();  // store the top index 
                stack.pop();  		 // pop the top 
       
                // Calculate the area with hist[top] stack as smallest bar 
                area_with_top = height[top] * (stack.empty() ? index : index - stack.peek() - 1); 
       
                // update max area, if needed 
                if (maxArea < area_with_top) 
                    maxArea = area_with_top; 
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar 
        while (stack.empty() == false) 
        { 
            top = stack.peek(); 
            stack.pop(); 
            area_with_top = height[top] * (stack.empty() ? index : index - stack.peek() - 1); 
       
            if (maxArea < area_with_top) 
                maxArea = area_with_top; 
        } 
       
        return maxArea; 
    } 
	
	//Method 2:
/*	public static int getMaxArea(int[] heights)
	{
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++)
        {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()])
                stack.push(i);
            else
            {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
*/	
	public static void main(String[] args)  
    { 
        int height[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is " + getMaxArea(height)); 
    } 
}
