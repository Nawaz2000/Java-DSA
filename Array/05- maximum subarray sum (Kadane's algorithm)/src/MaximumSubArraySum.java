/*
 * Given an array, find the maximum contiguous subarray sum possible
 * 
 * Ex-
 * i/p: {-6,2,3,-1,9,4,-7,-1,9}
 * o/p: 18
 * 
 * Idea:
 * The idea is to use two variables maxSum (for storing result), sum (for storing
 * current sum)
 * 
 * Traverse through the array,
 * 		sum = sum + arr[i]
 * 		if sum > maxSum
 * 			maxSum = sum
 * 		if sum < 0
 * 			sum = 0 as negative sum can never contribute to an answer
 * 
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class MaximumSubArraySum {

	public static int KadaneAlgo(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
			if (sum > maxSum)
				maxSum = sum;
			if (sum < 0)
				sum=0;
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-6,2,3,-1,9,4,-7,-1,9};
		System.out.println("Maximum subarray sum is: " + KadaneAlgo(arr));

	}

}
