/*
 * Given an array of integers nums, you start with an initial positive value 
 * startValue.
 * In each iteration, you calculate the step by step sum of startValue plus elements 
 * in nums (from left to right).
 * Return the minimum positive value of startValue such that the step by step sum is 
 * never less than 1.
 * 
 * Input: nums = [-3,2,-3,4,2]
 * Output: 5
 * Explanation: If you choose startValue = 4, in the third iteration your step by 
 * step sum is less than 1.
 * 
 * Idea:
 * Use prefix sum
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class StayPositive {
	public static int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        for (int i=1; i<nums.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        
        int res=1;
        
        int min = Integer.MAX_VALUE;
        for (int curr : prefixSum){
            if (curr < min)
                min = curr;
        }
        
        if (min < 0)
            res = Math.abs(min) + 1;
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3,2,-3,4,2};
		System.out.println(minStartValue(nums));
	}

}
