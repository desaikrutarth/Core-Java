package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
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
public class Practice { // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static void main(String[] args) {
		int a=20;
		List<List<Integer>> ff =new ArrayList<>();
		ff.add(Arrays.asList(1,8));
		ff.add(Arrays.asList(2,15));
		ff.add(Arrays.asList(3,9));
		
		List<List<Integer>> rr =new ArrayList<>();
		rr.add(Arrays.asList(1,8));
		rr.add(Arrays.asList(2,11));
		rr.add(Arrays.asList(3,12));
		
		Practice p=new Practice();
		List<List<Integer>> res=p.optimalUtilization(a, ff, rr);
		System.out.println(res);
	}
	
	List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		// WRITE YOUR CODE HERE
		List<List<Integer>> ff = forwardRouteList, rr = returnRouteList;
		int lenF = forwardRouteList.size(), lenR = returnRouteList.size();

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < lenF; i++)
			map.put(ff.get(i).get(1), ff.get(i).get(0));

		int maxSum = 0;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < lenR; i++) {
			System.out.println(i + "  --   "+ rr.get(i).get(1) +"  --  " + maxTravelDist);
			if (rr.get(i).get(1) > maxTravelDist)
				continue;
			Entry<Integer, Integer> et = map.floorEntry(maxTravelDist - rr.get(i).get(1));
			if (et == null)
				continue;
			int sum = et.getKey() + rr.get(i).get(1);
			System.out.println(sum);
			if (sum > maxSum) {
				maxSum = sum;
				List<Integer> sub = new ArrayList<>();
				sub.add(et.getValue());
				sub.add(rr.get(i).get(0));
				res.clear();
				res.add(sub);
			} else if (sum == maxSum) {
				List<Integer> sub = new ArrayList<>();
				sub.add(et.getValue());
				sub.add(rr.get(i).get(0));
				res.add(sub);
			}
		}
		return res;
	}

}
