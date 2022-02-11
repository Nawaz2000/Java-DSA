import java.util.Arrays;
import java.util.HashMap;
/*
 * Given an unsorted array of integers, find a sub-array that adds to a given number. 
 * If there is more than one sub-array with the sum of the given number, print any of 
 * them.
 * 
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 * 
 * Idea:
 * the problem can be viewed as
 * 	currSum = (currSum-sum) + (sum)
 * 	if (currSum-sum) is found in map then the subarray is from that found index + 1
 * 	to i
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class SubarraySum {
	public static void subarrayWithGivenSum(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int start = 0; // start index of the subarray
		int currSum = 0;
		int end = -1; // end index of the subarray
		
		for (int i=0; i<arr.length; i++) {
			currSum += arr[i];
			// currSum == sum, then the required sub-array starts from 0 to i
			if (currSum - sum == 0)
			{
				end = i;
				break;
			}
			
			// if map contains currSum-sum, then the required sub-array is found
			// from the next index of map.get(currSum-sum)
			if (map.containsKey(currSum-sum)) {
				start = map.get(currSum-sum) + 1;
				end = i;
				break;
			}
			else
				map.put(currSum, i);
		}
		
		if (end == -1)
			System.out.println("Subarray not found!");
		else {
			for (int i=start; i<=end; i++)
				System.out.print(arr[i] + " ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 20, 3, 10, 5};
		int sum = 33;
		System.out.println("Input array: " + Arrays.toString(arr) + ", sum = " + sum);
		System.out.print("Output: ");
		subarrayWithGivenSum(arr, sum);

	}

}
