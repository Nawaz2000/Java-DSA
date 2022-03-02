
public class DP {
	static int knapSack(int W, int wt[], int val[], int n) 
    {
		if (n<1 || W==0)
			return 0;
		System.out.println("Mod wt: " + W + ", wt[]: " + wt[n-1] + ", n: " + n);
		if (W < wt[n-1])
			return knapSack(W, wt, val, n-1);
		else {
			return Math.max(knapSack(W, wt, val, n-1), knapSack(W-wt[n-1], wt, val, n-1) + val[n-1]);
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = {60,100,120};
		int[] wt = {10,20,30};
		int w = 50;
		System.out.println("Max val in knacpsack: " + knapSack(w, wt, val, val.length));

	}

}
