/*
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in the list. One of the integers is missing in the list. 
 * Write an efficient code to find the missing integer.
 * 
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 * Explanation: The missing number from 1 to 8 is 5
 * 
 * Input: arr[] = {1, 2, 3, 5}
 * Output: 4
 * Explanation: The missing number from 1 to 5 is 4
 */
public class MissingNumber {

	public static int findMissing(int[] arr, int n) {
		int expectedSum = n*(n+1)/2;
		int actualSum = 0;
		
		for (int i : arr)
			actualSum+=i;
		
		return expectedSum-actualSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 4, 6, 3, 7, 8};
		int n = 8;
		System.out.println(findMissing(arr, n));

	}

}
