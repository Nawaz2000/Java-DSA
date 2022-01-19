import java.util.Arrays;

/*
 * Search for pattern in a string and print the indexes where the pattern matches
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(m)
 */

public class KMP {

	public static int[] findLPSArray(String pat) {
		int[] lps = new int[pat.length()];
		int i = 1; // stores the index for iteration, lps[0] is always 0
		int len = 0; // stores the value for lps[i]
		int n = pat.length();
		
		// we iterate till i<n
		while(i<n) {
			// if str[i] == pat[len], we increase len value and set lps[i] = len 
			// and the loop starts again from i = i+1
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				// if the above doesn't match and len == 0, then we set lps[i]=0,
				// set i=i+1 and then start the next iteration
				if (len == 0) {
					lps[i] = 0;
					i++;
				}else
					len = lps[len-1];// if len is not 0, we move to the left of lps
									 // until any of the above two condition matches
			}
		}
		
		return lps;
		
	}
	
	public static void solveKMP(String str, String pat) {
		int i = 0; // for traversing str
		int j = 0; // for traversing pat
		int n = str.length();
		int m = pat.length();
		int[] lps = findLPSArray(pat);
		System.out.println(Arrays.toString(lps));
		
		while (i<n) {
			// we start off from i=0, j=0 and match str[i] and pat[j]
			// if they match, we increment i and j
			if (str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			
			// now if j reaches the end index of pat, that means that the pattern is
			// found. So we print (i-j) as the index where the pattern occurrence is
			// found and as j == m, we set j as the last (j-1)th index of lps array 
			if (j == m) {
				System.out.print((i-j) + " ");
				j = lps[j-1];
			}else if ((i<n) && (str.charAt(i) != pat.charAt(j))) {
				// if the pattern doesn't fully match,
				// if j==0 (i.e., the first element of pat didn't match with str[i],
				// we increment i and start the next loop
				if (j == 0)
					i++;
				else
					j = lps[j-1]; // else we keep on going left of pat until any of
								  // the above condition match
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaaab";
		String pat = "aaaa";
		solveKMP(str, pat);

	}

}
