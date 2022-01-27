import java.util.HashSet;

/*
 * Given an array and a value, find if there is a triplet in array whose sum is equal 
 * to the given value. If there is such a triplet present in array, then print the 
 * triplet and return true. Else return false.
 * 
 * Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
 * Output: 12, 3, 9 
 * 
 * Idea: traverse the whole array in a single loop and apply the two sum concept
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 */
public class ThreeSum {
	
	public static boolean findThreeSum(int[] arr, int sum) {
		
		int n = arr.length;
		for (int i=0; i<n; i++) {
			int fEle = arr[i];
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j=0; j<n; j++) {
				if (j != i) {
					int currSum = fEle + arr[j];
					if (set.contains(sum-currSum))
						return true;
					else
						set.add(arr[j]);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, 3, 4, 1, 6, 9};
		int sum = 24;
		System.out.println(findThreeSum(arr, sum));

	}

}
