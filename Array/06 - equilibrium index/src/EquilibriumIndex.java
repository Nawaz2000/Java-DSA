/*
 * Equilibrium index of an array is an index such that the sum of elements at lower 
 * indexes is equal to the sum of elements at higher indexes. We are given an Array 
 * of integers, 
 * 
 * We have to find out the first index i from left such that -
 * A[0] + A[1] + ... A[i-1] = A[i+1] + A[i+2] ... A[n-1]
 * 
 * Input
 * [-7, 1, 5, 2, -4, 3, 0]
 * Output
 * 3
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * 
 * Idea:
 * The idea is to traverse through the array and calculate sum of all elements and
 * store it in a variable called sum
 * 
 * now traverse through the array again and in each iteration, calculate the left sum
 * as lSum = lSum + arr[i] and right sum as rSum = sum-arr[i]
 * 
 * if lSum == rSum, return the index i
 * 
 * Time Complexity: O(n)
 * Auxiliary space: O(1)
 */
public class EquilibriumIndex {

	public static int findEqIndex(int[] arr) {
		int sum = 0;
		int leftsum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		for (int i = 0; i < n; i++) {
			sum -= arr[i];
			if (sum == leftsum)
				return i;
			leftsum += arr[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(findEqIndex(arr));

	}

}
