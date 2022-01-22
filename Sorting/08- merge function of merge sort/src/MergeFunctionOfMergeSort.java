import java.util.Arrays;
/*
 * Merge function of Merge Sort algorithm
 * 
 * Time Complexity: O(n)
 * Auxiliary space: O(n);
 */
public class MergeFunctionOfMergeSort {

	public static int[] merge(int[] a, int low, int mid, int high) {
		int[] left = Arrays.copyOfRange(a, low, mid+1);
		int[] right = Arrays.copyOfRange(a, mid+1, high+1);
		int lenL = left.length;
		int lenR = right.length;
		
		int i=0, j=0, k=low;
		while(i<lenL && j<lenR) {
			if (left[i] <= right[j])
				a[k++] = left[i++];
			else
				a[k++] = right[j++];
		}
		
		// fill up the remaining array elements
		// although there are two while loops, only one of them will get executed
		// because of the above loop, one array (left or right) is already traversed
		while (i<lenL)
			a[k++] = left[i++];
		while(j<lenR)
			a[k++] = right[j++];
		
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,40,20,30};
		int low = 0;
		int mid = 2;
		int high = 4;
		int[] res = merge(arr, low, mid, high);
		System.out.println(Arrays.toString(res));

	}

}
