package Google_3;

import java.util.Random;

/*
 * Select a random point uniformly within a rectangle, (The side of rectangle is parallel to the x/ y grid). 

Follow-up:
Given multiple non-overlapped rectangles on the 2D grid, uniformly select a random point from the rectangles.
 */
class Rectangle
{
    int x1, x2;		 //top left (x1, y1)
    int y1, y2; 	 // bottom right (x2, y2)
}

class Point
{
    int x, y;
    public Point(int a, int b)
    {
        x = a;
        y = b;
    }
}
public class RandomPointRectangle 
{
	static final Random rand = new Random();

    //Round2
    static Point randomSelectFrom(Rectangle rectangle)
    {
        return new Point(rectangle.x1 + rand.nextInt(rectangle.x2 - rectangle.x1 + 1),
                        rectangle.y2 + rand.nextInt(rectangle.y1 - rectangle.y2 + 1));
    }

    //Round2 follow-up
    //first of all decide which rectangle yields the point (randomly select a rectangle based on area as the weight)
    //then apply randomSelectFrom(rectangle) on the selected rectangle
    static Point randomSelectFrom(Rectangle[] rectangles)
    {
        int selected = -1, total = 0;
        for(int i = 0; i < rectangles.length; i++) 
        {
            int area = (rectangles[i].x2 - rectangles[i].x1) * (rectangles[i].y1 - rectangles[i].y2);
            if(rand.nextInt(total + area) >= total) {
                selected = i;
            }
            total += area;
        }
        return randomSelectFrom(rectangles[selected]);
    }
	    
	    public static void main(String[] args)
	    {
	    	Rectangle rect = new Rectangle();
	    	Point p = randomSelectFrom(rect);
	    	System.out.println(p.x+" "+p.y);
	    }
}
