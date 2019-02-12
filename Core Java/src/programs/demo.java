package programs;
import java.util.*;
public class demo 
{
		public static void main (String args[])
		{
			int a, b, c;
			double root1, root2, d;
			Scanner s = new Scanner(System.in);
			System.out.print("Input a:");
			a = s.nextInt();
			System.out.print("input b:");
			b = s.nextInt();
			System.out.print("Input c:");
			c = s.nextInt();
			d = b * b - 4 * a * c;
			root1 = (- b + Math.sqrt(d))/(2*a);
			root2 = (- b - Math.sqrt(d))/(2*a);
			System.out.println("Root1:"  +root1);
			System.out.println("Root2:" +root2);
		}
}