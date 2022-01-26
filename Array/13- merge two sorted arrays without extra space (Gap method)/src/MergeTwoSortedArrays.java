import java.util.Arrays;

/*
 * Merge two sorted arrays without extra space
 * 
 * Input: 
 * n = 4, arr1[] = [1 3 5 7] 
 * m = 5, arr2[] = [0 2 6 8 9]
 * Output: 
 * arr1[] = [0 1 2 3]
 * arr2[] = [5 6 7 8 9]
 * 
 * Idea: Gap method
 * 
 * Time complexity: O((n+m)log(n+m))
 * Auxiliary space: O(1)
 */
public class MergeTwoSortedArrays {

	public static void swap(int[] a, int[] b, int i, int j) {
		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}
	
	public static void merge(int[] a, int[] b, int n, int m) {
		int gap = (int) Math.ceil((((double)m+(double)n)/2));
		while (gap>0) { // this makes the loop run logn times
			int i = 0;
			int j = gap;
			
			// makes the loop run n times
			while (j<(n+m)) {
				// checks if i,j lie in the first array
				if (i<n && j<n && a[i]>a[j])
					swap(a, a, i, j);
				// checks if i lie in a[] and j lie in b[]
				else if (i<n && j>=n) {
					if (a[i] > b[j-n])
						swap(a, b, i, j-n);
				}
				// checks if both i,j lie in b[]
				else if (i>=n) {
					if (b[i-n] > b[j-n])
						swap(b, b, i-n, j-n);
				}
				
				i++;
				j++;				
				
			}

			if (gap != 1)
				gap = (int)Math.ceil((double)gap/2);
			else
				gap = 0;
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,7};
		int[] b = {0,2,6,8,9};
		int n = a.length;
		int m = b.length;
		merge(a, b, n, m);

	}

}
