import java.util.Arrays;

public class DP {
	static int[] memo;
	static int minJumps(int[] arr, int n, int indx) {
		if (memo[n] != -1)
			return memo[n];
//		System.out.println(n);
		if (n == 1)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for (int i=1; i<=arr[indx]; i++) {
			if (i<n)
				min = Math.min(min, minJumps(arr, n-i, indx+i));
		}
		
		if (min != Integer.MAX_VALUE) {
			memo[n] = min+1;
			return min+1;
		}
		memo[n] = min;
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,5,3,1,3,2,1,8};
		int indx = 0;
		int n = arr.length;
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		System.out.println("Min jumps: " + minJumps(arr, n, indx));

	}

}
