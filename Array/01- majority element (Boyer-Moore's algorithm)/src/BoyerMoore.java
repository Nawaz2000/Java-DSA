/*
 * Given an array A of N elements. Find the majority element in the array. A majority 
 * element in an array A of size N is an element that appears more than N/2 times in 
 * the array.
 * 
 * Input:
 * N = 3 
 * A[] = {1,2,3} 
 * Output:
 * -1
 * 
 * Input:
 * N = 5 
 * A[] = {3,1,3,3,2} 
 * Output:
 * 3
 * 
 * Algorithm: Boyer-Moore's majority element algorithm
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class BoyerMoore {

	public static int BoyerMoore(int[] arr, int n) {
		int count = 0;
		int candidate = -1;
		
		// finds out the element occurring in majority (candidate)
		for (int i=0; i<n; i++) {
			if (count == 0) {
				candidate = arr[i];
				count++;
			}else {
				if (arr[i] == candidate)
					count++;
				else
					count--;
			}
		}
		
		count = 0;
		
		// counts the occurrence of candidate
		for (int x : arr) {
			if (x == candidate)
				count++;
		}
		
		if (count > (n/2))
			return candidate;
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,3,3,2};
		int n = arr.length;
		System.out.println(BoyerMoore(arr, n));

	}

}
