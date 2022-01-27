import java.util.HashMap;
/*
 * Given an array of integers, find anyone combination of four elements in the array 
 * whose sum is equal to a given value X.
 * 
 * Input: 
 * array = {10, 2, 3, 4, 5, 9, 7, 8} 
 * X = 23 
 * Output: true(3 5 7 8)
 * 
 * Idea: 
 * Store sums of all pairs in a hash table
 * Traverse through all pairs again and search for X – (current pair sum) in the hash 
 * table.
 * If a pair is found with the required sum, then make sure that all elements are 
 * distinct array elements and an element is not considered more than once.
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(n^2)
 */
public class FourSum {

	public static boolean findFourSum(int[] arr, int sum) {
		int n = arr.length;
		HashMap<Integer, Integer[]> map = new HashMap<>();
		
		// stores the sums of all possible pairs this reduces the time complexity
		// by O(n^2)
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (j != i) {
					int currSum = arr[i] + arr[j];
					Integer[] digits = {i,j};
					map.put(currSum, digits);
				}
			}
		}
		
		// uses the 3 sum concept O(n^2) to find the other two numbers
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				int currSum = arr[i] + arr[j];
				if (map.containsKey(sum-currSum)) {
					Integer[] digits = map.get(sum-currSum);
//					System.out.println("currSum=" + currSum + ", sum-currSum=" + (sum-currSum));
					if (i != digits[0] && j != digits[1] && i != digits[1] && j != digits[0])
					{
						System.out.println(arr[i] + " " + arr[j] + " " + arr[digits[0]] + " " + arr[digits[1]]);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,2,3,4,5,7,8};
		int sum = 23;
		System.out.println(findFourSum(arr, sum));

	}

}
