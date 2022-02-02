import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * Given an integer array nums sorted in non-decreasing order, return an array of the 
 * squares of each number sorted in non-decreasing order.
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * Idea: Use stack
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class SquaresOfASortedArray {
	public static int[] sortedSquares(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        int arrIndx = 0;
        
        for (int i=0; i<nums.length; i++){
            int currSq = (int)Math.pow(nums[i],2);
            
            if (stack.isEmpty())
                stack.push(currSq);
            else if (currSq <= stack.peek())
                stack.push(currSq);
            else{
                while (!stack.isEmpty() && stack.peek()<currSq)
                    res[arrIndx++] = stack.pop();
                stack.push(currSq);
            }
        }
        
        while (!stack.isEmpty())
            res[arrIndx++] = stack.pop();
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-7,-3,2,3,11};
		int[] res = sortedSquares(nums);
		System.out.println(Arrays.toString(res));

	}

}
