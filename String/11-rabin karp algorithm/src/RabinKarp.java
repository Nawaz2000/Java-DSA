/*
 * Rabin-Karp algorithm implementation
 * 
 * Idea: 
 * the idea is to traverse through the array, use sliding window and check for
 * pattern in windows.
 * 
 * But instead of checking for pattern in each window, we take out the hash of each
 * window (using rolling hash to save time complexity) and match it with the hash of
 * the pattern.
 * 
 * if the hash matches, then only we match each character of the current window with
 * that of in the pattern.
 * 
 * Time complexity: 
 * Worst case: O((n-m+1)*m)
 * But in average it works better than the naive algorithm
 * 
 */


public class RabinKarp {
	
	public static void searchRabinKarp(String str, String pat, int n, int m) {
		int d = 256;
		int p = 0; // hash value for pattern
		int t = 0; // hash value for window of current text
		int q = 100003;
		int h = 1;
		
		// calculates (d^(m-1))%q
		h = (int) ((Math.pow(d, m-1))%q);
		
		// hash of pattern
		for (int i=0; i<m; i++) {
			p = (p*d + pat.charAt(i))%q;
			t = (t*d + str.charAt(i))%q;
		}
		
		for (int i=0; i<n-m; i++) {
			// hash of pattern == if hash of current window 
			if (p==t) {
				boolean flag = true;
				
				// checks each character of both pattern and current window
				for (int j=0; j<m; j++) {
					if (str.charAt(i+j) != pat.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if (flag == true)
					System.out.println(i);
			}
			
			if (i < n-m) {
				// calculating the hash of next window by removing the last character
				// and inserting the next character
				t = (d*(t - str.charAt(i)*h) + str.charAt(i+m))%q; // hash formula
				if (t<0)
					t = t+q;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "University Institute of Technology, The University of Burdwan is a government engineering college located in West Bengal, India.";
        String pat = "en";
        
        int n = str.length();
        int m = pat.length();
        
        searchRabinKarp(str, pat, n, m);

	}

}
