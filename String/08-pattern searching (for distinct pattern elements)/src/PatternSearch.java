/*
 * Pattern searching algorithm when each character of the pattern is distinct
 * 
 * Time complexity: Theta(n) as every time we execute the inner loop, we use, i=i+j
 * Auxiliary space: O(n)
 */
public class PatternSearch {

	public static void search(String str, String pattern) {
		char[] arr = str.toCharArray();
		char[] patt = pattern.toCharArray();
		
		int n = arr.length;
		int m = patt.length;
		
		for (int i=0; i<=(n-m); ) {
			int j = 0;
			for (j=0; j<m; j++) {
//				System.out.println("arr["+(j+i)+"] = "+arr[j+i] + " patt["+j+"] = "+patt[j]);
				if (arr[j+i] != patt[j])
					break;
				
			}
			
			// if the pattern matches, print the index
			if (j==m)
				System.out.print(i+" ");
			
			// if the first character doesn't match, increase i by 1
			if (j==0)
				i++;
			else // else increment i to the index that didn't match
				i=(i+j);
//			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "stmstrmstr";
		String pattern = "str";
		search(str,pattern);

	}

}
