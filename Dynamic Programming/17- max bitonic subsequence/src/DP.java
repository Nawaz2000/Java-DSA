/*
 * Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
 * A subsequence of array is called Bitonic if it is first increasing, then decreasing.
 * 
 * Input: nums = [1, 11, 2, 10, 4, 5, 2, 1]
 * Output: 6
 * Explanation: The bitonic sequence 
 * {1, 2, 10, 4, 2, 1} has length 6.
 * 
 * Idea:
 * 1. find the lis and lds for the given array.
 * 2. find the max in (lis+lds-1) and return it.
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(n)
 */
public class DP {
	static int LongestBitonicSequence(int[] arr)
    {
        int n = arr.length;
        int[] lis = new int[n]; // holds the lis till ith index
        int[] lds = new int[n]; // holds the lds till ith index
        
        lis[0] = 1;
        lds[n-1] = 1;
        
        // finds the lis from 0 to n-1
        for (int i=1; i<n; i++){
            int max = Integer.MIN_VALUE;
            for (int j=0; j<i; j++){
                if (arr[j] < arr[i]){
                    if (lis[j] > max)
                        max = lis[j];
                }
            }
            
            if (max != Integer.MIN_VALUE)
                lis[i] = max+1;
            else
                lis[i] = 1;
        }
        
        // finds the lds by finding LIS from n-1 to 0
        for (int i=n-1; i>=0; i--){
            int max = Integer.MIN_VALUE;
            for (int j=n-1; j>i; j--){
                if (arr[j] < arr[i]){
                    if (lds[j] > max)
                        max = lds[j];
                }
            }
            
            if (max != Integer.MIN_VALUE)
                lds[i] = max+1;
            else
                lds[i] = 1;
        }
        
        // the result resides in finding the max of (lis+lds-1) for every index from i to n
        int maxBitonic = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            if ((lis[i] + lds[i] - 1) > maxBitonic)
                maxBitonic = lis[i] + lds[i] - 1;
        }
        
        return maxBitonic;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println(LongestBitonicSequence(nums));

	}

}
