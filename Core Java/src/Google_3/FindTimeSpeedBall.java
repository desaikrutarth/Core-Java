package Google_3;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
 * A table has some number of balls at various positions on a line segment. 
All are moving with same speed in one or the other direction. 
Wherever a collision occurs they change direction. 
A ball falls from the edges of the table. 
Find the time when all balls fall of the table 
given initial position of each ball and speeds
 */
/*
I assume the question is, find the first moment in time when all balls
have fallen from the table (like max time).
--
First this is more of a physics than a C/S question, because we have
to understand what happens at collision very well. If the balls were
of volume lim->0 and it's an elastic collision as described and if we
couldn't distinguish balls we would just observe the balls moving "through"
each other. But if the balls get bigger, they would travel "through"
each other in "no time" or "bounce of" each other.
From the point of view of the ball, every time you hit a ball that
runs in opposite direction you travel "light speed" for the distance
of a balls diameter.

So, it's about choosing units we can easily calculate here. I would
suggest to use:
- ball diameter: d
- speed: 1d / time unit
- position: in d: 0, d, 2d, etc...

illustration (zero: zero volume case; even,odd: volume case with even
                                                and odd distance)
case    | zero  | even  | odd
---------------------------------
position| 12345 | 12345 | 12345
---------------------------------
|  1    |_.___._|_O___O_|_O__O__
t  1.5  |       |       |
i  2    |__._.__|__O_O__|__OO___
m  2.5  |       |  -*-  |
e  3    |___.___|__O_O__|_O__O__
|  3.5  |       |       |
v  4    |__._.__|_O___O_|O____O_

having this definitions in place the table may look like this
(< left moving, >right moving)
          12 15         26  30  34
          |  |          |   |   |
____<__<__>__>___<___<__>___>___>_____
|   |  |         |   |               |
5   9  11        19  23              40

table: 5..40
left moving: 9, 11, 19, 23
right moving: 12, 15, 26, 30, 34

t = time for a ball to reach table edge = distance to edge - #balls encountered
which ball takes the longest? either the most right left-running,
or the most left right-running (the ball 23 or 12 in the example)

O(n + m) solution (n number of left running, m number of right running)
1. traverse the two arrays to find the most left right-running and the most
   right left-running
2. traverse the arrays again to find how many balls those will encounter
3. calculate, build the max, done
*/
public class FindTimeSpeedBall 
{
	public static int lastBallFalling(int tableStart, int tableEnd, List<Integer> leftRunningBallPos, List<Integer> rightRunningBallPos) 
	{
		// TODO, verify corner cases for null, empty arrays, start > end,
		// balls not in range etc.
		int rightRunning = tableEnd - Collections.min(rightRunningBallPos) + 1;
		int leftRunning = Collections.max(leftRunningBallPos) - tableStart + 1;
		for(int rr : leftRunningBallPos) {
			if(rr < leftRunning) leftRunning--;
		}
		for(int ll : rightRunningBallPos) {
			if(ll > rightRunning) rightRunning--;
		}
		return Math.max(leftRunning, rightRunning);
	}

	public static void main(String[] args)
	{
		System.out.println(lastBallFalling(5, 40, Arrays.asList(9, 11, 19, 23), Arrays.asList(12, 15, 26, 30, 34)));
		// output 27: = max(40 - 12 + 1 - 2, 23 - 5 - 2)
	}
}
