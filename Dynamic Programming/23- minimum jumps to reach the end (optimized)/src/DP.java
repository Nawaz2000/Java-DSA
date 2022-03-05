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
 * Time complexity: O(n^2)
 */
public class DP {
	static int minJumps(int[] A, int idx, int N) {
		if (idx == N - 1) {
			return 1;
		}

		if (idx >= N) {
			return 0;
		}

		int jumps = A[idx];

		for (int i = 1; i <= jumps; i++) {
			int ans = minJumps(A, idx + i, N);
			if (ans == 1) {
				return ans;
			}
		}

		return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 1, 5, 3, 1, 3, 2, 1, 8 };
		int indx = 0;
		System.out.println("Min jumps: " + minJumps(arr, 0, arr.length));

	}

}
