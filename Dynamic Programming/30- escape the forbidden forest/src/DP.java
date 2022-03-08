/*
 * Penelope and her classmates are lost in the Forbidden Forest and the Devil is out to get 
 * them. But Penelope has magical powers that can build bridges across the dangerous river 
 * and take her friends to safety. The only bridges that can withstand the Devil's wrath are 
 * the ones built between two similar trees in the forest. 
 * 
 * Given str1 and str2 denoting the order of trees on either side of the river, find the 
 * maximum number of bridges that Penelope can build and save everyone from the Devil. 
 * 
 * Note: Each tree in the forest belongs to one of the 3 categories represented by 
 * * or # or @. Also, the bridges can not cross each other.
 * 
 * Input:
 * str1 = "*@#*" 
 * str2 = "*#"
 * Output:
 * 2
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(n*m)
 */
public class DP {
	public static int build_bridges(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] memo = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					memo[i][j] = 1 + memo[i - 1][j - 1];
				else
					memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
			}
		}

		return memo[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "*@#*";
		String str2 = "*#";	
		System.out.println(build_bridges(str1, str2));

	}

}
