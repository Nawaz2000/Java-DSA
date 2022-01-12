import java.util.ArrayList;

/*
 * Search for a given pattern in a given string and return their indexes
 * 
 * i/p = "amsterdam"
 * o/p = 0, 7 
 * 
 * Time complexity = O(n-m+1)
 * Space complexity = O(m)
 */

public class PatternSearch {

	public static void search(String str, String pattern) {
		char[] arr = str.toCharArray();
		char[] patt = pattern.toCharArray();
		
		int n = arr.length;
		int m = patt.length;
		
		if ((n-m) >1) {
			for (int i=0; i<=(n-m); i++) {
				
				int j=0;
				for (j=0; j<m; j++) {
					System.out.println("arr["+(j+i)+"] = " + arr[j+i] + " || patt["+j+"] = "+patt[j]);
					if (arr[j+i] != patt[j])
						break;
				}
				System.out.println();
				
				if (j == m)
					System.out.println(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "amsterdam";
		String pattern = "am";
		search(str, pattern);

	}

}
