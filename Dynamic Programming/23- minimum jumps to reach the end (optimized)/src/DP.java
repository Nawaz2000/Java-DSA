import java.util.Arrays;

/*
 * Given an positive integer N and a list of N integers A[]. Each element in the array 
 * denotes the maximum length of jump you can cover. Find out if you can make it to the last 
 * index if you start at the first index of the list.
 * 
 * Input:
 * N = 6
 * A[] = {1, 2, 0, 3, 0, 0} 
 * Output:
 * 1
 * Explanation:
 * Jump 1 step from first index to
 * second index. Then jump 2 steps to reach 
 * 4th index, and now jump 2 steps to reach
 * the end.
 * 
 * Time complexity: O(n)
 */
public class DP {
	static int minJumps(int[] arr) {
		// if first element is 0 and there is only one element we need 0 steps
		if (arr[0] == 0 && arr.length == 1)
			return 0;
		// if the first element is 0, we cannot move further
		if (arr[0] == 0)
			return -1;
		int jumps = 0, currEnd = 0, currFarthest = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			currFarthest = Math.max(currFarthest, i + arr[i]);
			if (i == currEnd) {
				if (i == currFarthest)
					return -1;
				jumps++;
				currEnd = currFarthest;
			}
		}
		return jumps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 1, 5, 3, 1, 3, 2, 1, 8 };
		System.out.println("Min jumps: " + minJumps(arr));

	}

}
