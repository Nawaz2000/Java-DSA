import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * You are given n activities with their start and finish times. Select the 
 * maximum number of activities that can be performed by a single person, assuming 
 * that a person can only work on a single activity at a time. 
 * 
 * Example:
 * i/p: activity[]  =  {(2,3), (1,4), (5,8), (6,10)};
 * o/p: {(2,3), (5,8)};
 * 
 * Idea:
 * 1. sort the array according to its 2nd elements
 * 2. initialize the res with the first element of the sorted array
 * 3. for every element of the remaining array
 * 	a. if the curr.start >= last.end, insert it into the res
 * 
 * TIme complexity: O(nlogn)
 * Auxiliary space: O(1)
 */
class Pair implements Comparable<Pair>{
	int start;
	int end;
	Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Pair o) {
		return this.end - o.end;
	}

	@Override
	public String toString() {
		return "Pair [start=" + start + ", end=" + end + "]";
	}
	
}
public class Greedy {
	static ArrayList<Pair> activitySelect(ArrayList<Pair> activity) {
		Collections.sort(activity);
		ArrayList<Pair> res = new ArrayList<Pair>();
		int n = activity.size();
		res.add(activity.get(0));
		
		for (int i=1; i<n; i++) {
			// select
			Pair curr = activity.get(i);
			Pair last = res.get(res.size()-1);
			// feasibility
			if (curr.start >= last.end)
				res.add(curr);
		}
		// return
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pair> activity = new ArrayList<Pair>();
		activity.add(new Pair(1, 3));
		activity.add(new Pair(2, 4));
		activity.add(new Pair(3, 8));
		activity.add(new Pair(10, 11));
		
		ArrayList<Pair> res = activitySelect(activity);
		System.out.println("Number of pairs selected: " + res.size());
		System.out.println(Arrays.toString(res.toArray()));

	}

}
