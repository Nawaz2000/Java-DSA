import java.util.HashMap;
/*
 * Given an unsorted array of integers, find the number of subarrays having sum 
 * exactly equal to a given number k.
 * 
 * Input:
 * Arr = {10 , 2, -2, -20, 10}
 * k = -10
 * 
 * Output: 3
 * Explanation: 
 * Subarrays: arr[0...3], arr[1...4], arr[3..4]
 * have sum exactly equal to -10.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class CountSubarrayWithGivenSum {
	public static int countSubarrayWithSum(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = 0;
		int currSum = 0;
		
		for(int i=0; i<arr.length; i++) {
			currSum += arr[i];
			if(currSum-sum == 0)
				res++;
			
			if(map.containsKey(currSum-sum))
				res += map.get(currSum-sum);
			
			if (map.containsKey(currSum))
                map.put(currSum, map.get(currSum) + 1);
            else
                map.put(currSum, 1);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10 , 2, -2, -20, 10};
        int sum = -10;
        System.out.println(countSubarrayWithSum(arr, sum));

	}

}
