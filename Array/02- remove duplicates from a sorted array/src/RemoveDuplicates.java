import java.util.Arrays;
/*
 * Remove duplicate elements from an array
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class RemoveDuplicates {

	public static int[] removeDuplicates(int[] arr, int n) {
		int[] res = new int[n];
		int marker = -1;

		for (int i = 0; i < n; i++) {
			if (marker == -1) {
				res[++marker] = arr[i];
			} else {
				if (arr[i] != res[marker]) {
					res[++marker] = arr[i];
				}
			}
		}

		return Arrays.copyOfRange(res, 0, marker + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 2, 3, 4, 4 };
		int n = arr.length;
		System.out.println(Arrays.toString(removeDuplicates(arr, n)));

	}

}
