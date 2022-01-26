import java.util.Arrays;

/*
 * Given two sorted arrays, A and B, where A has a large enough buffer at the end to 
 * hold B. Merge B into A in sorted order.
 * 
 * Input : 
 * a[] = {10, 12, 13, 14, 18, NA, NA, NA, NA, NA}   
 * b[] = {16, 17, 19, 20, 22}
 * 
 * Output : 
 * a[] = {10, 12, 13, 14, 16, 17, 18, 19, 20, 22}
 * 
 * Idea:
 * traverse the both the array from last valid index (index that actually has a value)
 * towards the front and compare the last elements of the arrays. The larger one gets
 * moved to the end of the larger array
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class SortedMerge {
	
	public static int[] sortedMerge(int[] a, int[] b, int n, int m) {
		n--;
		m--;
		int lastIndxA = a.length-1;
		
		while (n>=0 && m>=0) {
			if (b[m] > a[n])
				a[lastIndxA--] = b[m--];
			else
				a[lastIndxA--] = a[n--];
		}
		
		// empty the non traversed array in b into a
		while(m >= 0)
			a[lastIndxA--] = b[m--];
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10,40,80,-1,-1,-1};
        int n = 3;
        int b[] = {4,6,50};
        int m = 3;
        int[] res = sortedMerge(a, b, n, m);
        System.out.println(Arrays.toString(res));

	}

}
