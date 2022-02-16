/*
 * Given an array nums of n integers where nums[i] is in the range [1, n], return 
 * an array of all the integers in the range [1, n] that do not appear in nums.
 * 
 * Idea:
 * 1. loop through 0 to n
 * 2. keep negating the values at arr[arr[i]-1] if they are positive
 * 4. the indexes which remain positive means that they are absent
 * 3. loop through it again and print those index+1 which are positive
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class Missing {
	static void findMissing(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n; i++) {
			int temp = Math.abs(arr[i]);
			if (arr[temp-1] > 0)
				arr[temp-1] = -arr[temp-1];
		}
		
		for (int i=0; i<n; i++) {
			if (arr[i] >= 0)
				System.out.print((i+1) + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,2,7,8,2,3,1};
		findMissing(arr);

	}

}
