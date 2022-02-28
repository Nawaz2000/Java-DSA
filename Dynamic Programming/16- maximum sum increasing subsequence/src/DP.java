import java.util.Arrays;
/*
 * Given an array arr of N positive integers, the task is to find the maximum sum increasing 
 * subsequence of the given array.
 * 
 * Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
 * Output: 106
 * Explanation:The maximum sum of a
 * increasing sequence is obtained from
 * {1, 2, 3, 100}
 * 
 * Idea:
 * use a memo[], whose each index stores the sum of the maximum increasing subsequence
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(n)
 */
public class DP {
	public static int maxSumIS(int arr[], int n)  
	{  
	    // stores the sum of the maximum increasing subsequence
		int[] memo = new int[n];
	    memo[0] = arr[0]; // as sum to the left of first element is 0, so sum = arr[0]
	    
	    for (int i=1; i<n; i++){
	        // stores the value of the index that stores the maximum sum of increasing subsequence
	    	int max = Integer.MIN_VALUE;
	        
	        for (int j=0; j<i; j++){
	            if (arr[j] < arr[i]) {
	            	if (memo[j] > max)
	            		max = memo[j];
	            }
	        }
	        
	        
	        if (max != Integer.MIN_VALUE)
	            memo[i] = max + arr[i];
	        else // if no max sum is found that means the element is the smallest so far
	            memo[i] = arr[i];
	    }
	    
	    int maxSum = Integer.MIN_VALUE;
	    
	    for (int i : memo){
	        if (i > maxSum)
	            maxSum = i;
	    }
	    
//	    System.out.println(Arrays.toString(memo));
	    
	    return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 101, 2, 3, 100};
		int n = arr.length;
		System.out.println(maxSumIS(arr, n));

	}

}
