import java.util.Arrays;

/*
 * Given a string, find its rank among all its permutations sorted lexicographically. 
 * For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6. 
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */

public class LexicographicRank {

	public static int rank(String str) {
		str = str.toUpperCase();
		int res = 0;
		
		int[] count = new int[256];
				
		int n = str.length();
		int mul = fact(n);
		
		for (int i=0; i<n; i++)
			count[str.charAt(i)]++;
		
//		System.out.println(Arrays.toString(count));
		
		for (int i=1; i<256; i++)
			count[i] += count[i-1];
		
//		System.out.println(Arrays.toString(count)+"\n");
		
		for (int i=0; i<n-1; i++) {
			mul = mul/(n-i);
			res = res + count[str.charAt(i)-1]*mul;
			System.out.println("res " + i + " = " + res + ", char = "+str.charAt(i));
			
			for (int j=str.charAt(i); j<256; j++)
				count[j]--;
//			System.out.println(Arrays.toString(count));
		}
		
		return res+1;
	}
	
	public static int fact(int num) {
		int res = num;
		while(true) {
			res = res*(--num);
			if (num<=1)
				break;
					
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "STRING";
		System.out.println("Rank of " + str + " is: " + rank(str));

	}

}
