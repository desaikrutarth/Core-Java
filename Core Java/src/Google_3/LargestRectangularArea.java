package Google_3;

public class LargestRectangularArea
{
	static class Point
	{
		int x;
		int y;

		public Point(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
	}

	public static int area(Point[] points, Point p, boolean matchx, boolean matchy, int l, int b, int area, int x, int y) {

		if (matchx && matchy)
		{
			boolean r = matchXY(points, l, b, area, x, y);
			if(r){
				area = Math.max(area, l*b);
			}
			return area;
		}
		
		if (matchx)
			area = matchX(points, p, l, b, area, x, y);
		if (matchy)
			area = matchY(points, p, l, b, area, x, y);

		return area;

	}

	public static int matchX(Point[] points, Point p, int l, int b, int area, int x, int y) {
		int n = points.length;
		for (int i = 0; i < n; i++) {
			Point pn = points[i];
			if (pn.x == p.x && pn.y != p.y)
				area = area(points, pn, false, true, Math.abs(pn.y - p.y), b, area, x, p.y);
		}
		return area;
	}

	public static int matchY(Point[] points, Point p, int l, int b, int area, int x, int y) {
		int n = points.length;
		for (int i = 0; i < n; i++) {
			Point pn = points[i];
			if (pn.y == p.y && pn.x != p.x)
				area = area(points, pn, true, true, l, Math.abs(pn.x - p.x), area, p.x, y);
		}
		return area;
	}

	public static boolean matchXY(Point[] points, int l, int b, int area, int x, int y) {
		int n = points.length;
		for (int i = 0; i < n; i++) {
			Point pn = points[i];
			if (pn.x == x && pn.y == y)
				return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		Point[] points = { new Point(0, 0), new Point(0, 3), new Point(0, 6), new Point(2, 0), new Point(2, 3) };
		int area = -1;
		for (int i = 0; i < points.length; i++)
		{
			area = Math.max(area, area(points, points[0], true, false, -1, -1,-1, Integer.MAX_VALUE, Integer.MAX_VALUE));	
		}
		System.out.println(area);
	}
}
