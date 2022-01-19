import java.util.Arrays;

/*
 * Given a string s, find the length of the longest prefix, which is also a suffix. 
 * The prefix and suffix should not overlap.
 * 
 * Ex- 
 * i/p = "abca"
 * 
 * here,
 * proper prefix set = {"","a","ab","abc"}
 * suffix set = {"","a","ca","bca","abca"}
 * 
 * we have to find the longest proper prefix which is also a suffix
 * 
 * here,
 * o/p = "a"
 * 
 */
public class LPS {
	
	public static int[] findLPSArray(String str) {
		int[] lps = new int[str.length()];
		int i = 1; // loop starts from here
		int n = str.length();
		int len = 0; // stores the max value for lps[i]
		
		while(i<n) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len==0) {
					lps[i]=0;
					i++;
				}else {
					len=lps[len-1];
				}
			}
		}
		
		return lps;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abacabad";
		System.out.println(Arrays.toString(findLPSArray(str)));
		
	}

}
