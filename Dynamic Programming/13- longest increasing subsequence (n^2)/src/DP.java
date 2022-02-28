/*
 * Given an array of integers, find the length of the longest (strictly) increasing subsequence 
 * from the given array.
 * 
 * Input:
 * N = 16
 * A[]={0,8,4,12,2,10,6,14,1,9,5
 *      13,3,11,7,15}
 * Output: 6
 * Explanation:Longest increasing subsequence
 * 0 2 6 9 13 15, which has length 6
 * 
 * Idea:
 * 1. use an memory array of size n where memo[i] stores the number of elements smaller than a[i]
 * on it's left
 * 2. set memo[0] = 1 (as there are no smaller elements on the left of the first element)
 * 2. use a for loop from i=1 to n
 * 		use inner for loop from 0 to i and store the max value found in memo on the left of i
 * 	  a. if max is not found in the inner loop, that means there are no smaller elements than the
 * 	  	 current element on the left of current element. So set memo[i] = 1
 * 	  b. else set memo[i] = max + 1
 * 3. use a for loop in memo, to find the max value and return it
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(n)
 */
public class DP {
	static int longestSubsequence(int size, int a[])
    {
		// memo[i] stores the number of elements smaller a[i] on the left of it
        int[] memo = new int[size];
        memo[0] = 1; // as there are no smaller element on the left of first element
        
        for (int i=1; i<size; i++){
        	int currMaxLIS = Integer.MIN_VALUE;
        	
        	// finds the LIS on the left of current element
            for (int j=i-1; j>=0; j--){
                if (a[j] < a[i]){
                	if (memo[j] > currMaxLIS)
                		currMaxLIS = memo[j];
                }
            }
            
            // if LIS is found
            if (currMaxLIS != Integer.MIN_VALUE)
            	memo[i] = currMaxLIS + 1;
            // if largest LIS is not found that means it is the smallest element so far
            // so set memo[i] to 1
            else
            	memo[i] = 1;
        }

        
        int maxLIS = Integer.MIN_VALUE;
        
        // finds the LIS in memo
        for (int i : memo){
            if (i > maxLIS)
                maxLIS = i;
        }
        
        return maxLIS;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,4,2,8,10,5,1};
		int size = a.length;
		System.out.println(longestSubsequence(size, a));

	}

}
