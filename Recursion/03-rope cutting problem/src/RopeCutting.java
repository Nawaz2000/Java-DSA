/*
 * Given a rope of length n, you need to find maximum number of pieces you can make
 * such that the length of every piece is in set {a,b,c} for given three values
 * a,b,c
 * 
 * i/p: n=5, a=2,b=5,c=1
 * o/p: 5
 * 
 * i/p: n=23, a=12,b=9,c=11
 * o/p: 2
 */


public class RopeCutting {

	public static int max(int a, int b, int c) {
		return (a>b)?(a>c?a:c):(b>c?b:c);
	}
	
	public static int maxCuts(int n, int a, int b, int c) {
		if (n==0)
			return 0;
		if (n<0)
			return -1;
		int res = max(maxCuts(n-a, a,b,c),
						  maxCuts(n-b, a,b,c),
						  maxCuts(n-c, a,b,c));
		
		if (res == -1)
			return -1;
		return res+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=23, a=12, b=9, c=11;
		System.out.println(maxCuts(n,a,b,c));

	}

}
