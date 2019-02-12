package Google_2;

/*
 * given a list of points in a rectangular coordinate system, seeking any two points, 
 * such that all the remaining points will be in only one side of the line.
 */
class Point 
{
    int x;
    int y;
    Point (int xx, int yy) 
    {
        x = xx;
        y = yy;
    }
}
public class GrahamScan
{
	public static Point[] func(Point[] points)
	{
        if (points == null || points.length <= 1) 
        	return null;
        Point[] answer = new Point[2];
        int length = points.length;
        Point firstPoint = points[0];
        int j = 0;
        for (int i = 1; i < length; i++) 
        {
            Point tempPoint = points[i];
            if (tempPoint.x < firstPoint.x) 
            {
                firstPoint = tempPoint;
                j = i;
            }
        }
        answer[0] = firstPoint;
        answer[1] = points[(j+1)%length];
        for (int i = 0; i < length; i++) 
        {
            boolean flag = checkDirection(answer[0], points[i], answer[1]);
            if (flag) {
                answer[1] = points[i];
            }
        }
        return answer;
}

private static boolean checkDirection(Point p1, Point p2, Point p3) 
{
        int value = ((p3.y - p2.y)*(p2.x-p1.x)) - ((p2.y - p1.y)*(p3.x-p2.x));
        if (value > 0) return true;
        return false;
}

	
	public static void main(String[] args)
	{
		Point point1 = new Point(3, 1);
		Point point2 = new Point(2, 2);
		Point point3 = new Point(2, 4);
		
		Point[] pointArray = {point1,point2,point3};
		
		Point[] result = func(pointArray);
		
		for(Point point : result)
			System.out.println(point.x+","+point.y);
	}
}
