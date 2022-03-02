/*
 * You are given weights and values of N items, put these items in a knapsack of capacity 
 * W to get the maximum total value in the knapsack. Note that we have only one quantity 
 * of each item. In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which 
 * represent values and weights associated with N items respectively. Also given an integer 
 * W which represents knapsack capacity, find out the maximum value subset of val[] such 
 * that sum of the weights of this subset is smaller than or equal to W. You cannot break 
 * an item, either pick the complete item or dont pick it (0-1 property).
 * 
 * Input:
 * N = 3
 * W = 4
 * values[] = {1,2,3}
 * weight[] = {4,5,1}
 * Output: 3
 * 
 * Idea:
 * 1. if W is less then wt[n-1], skip it
 * 2. if it is not, skip or use it
 * 
 * Time complexity: O(2^n)
 */
public class DP {
	static int knapSack(int W, int[] wt, int[] val, int n) {
		if (n<1 || W==0)
			return 0;
		if (W < wt[n-1])
			return knapSack(W, wt, val, n-1);
		else
			return Math.max(knapSack(W, wt, val, n-1), knapSack(W-wt[n-1], wt, val, n-1) + val[n-1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {60,100,120};
		int[] wt = {10,20,30};
		int w = 50;
		System.out.println("Max val in knacpsack: " + knapSack(w, wt, val, val.length));

	}

}
