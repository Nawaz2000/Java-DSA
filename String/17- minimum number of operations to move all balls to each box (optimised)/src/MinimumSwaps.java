import java.util.Arrays;

/*
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] 
 * is '0' if the ith box is empty, and '1' if it contains one ball.
 * 
 * In one operation, you can move one ball from a box to an adjacent box. Box i is 
 * adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more 
 * than one ball in some boxes.
 * 
 * Return an array answer of size n, where answer[i] is the minimum number of 
 * operations needed to move all the balls to the ith box.
 * 
 * Input: boxes = "110"
 * Output: [1,1,3]
 * 
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 * 
 * Idea: 
 * use two loops. First one from 0 to n storing leftSum. 
 * Second loop from n to 0 storing left sum + right sum
 * 
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class MinimumSwaps {

	public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
        	if (boxes.charAt(i) == '1') {
        		for (int j=0; j<i; j++) {
        			res[j] += Math.abs(i-j);
        		}
        	}
        }
        
        for (int i=n-1; i>=0; i--) {
        	if (boxes.charAt(i) == '1') {
        		for (int j=i; j<=(n-1); j++) {
        			res[j] += Math.abs(i-j);
        		}
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String boxes = "001011";
		int[] res = minOperations(boxes);
		System.out.println(Arrays.toString(res));

	}

}
