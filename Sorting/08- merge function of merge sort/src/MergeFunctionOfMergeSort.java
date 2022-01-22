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
		int n = a.length;
		int lenL = left.length;
		int lenR = right.length;
		int[] res = new int[n];
		
		int i=0, j=0, k=0;
		while(i<lenL && j<lenR) {
			if (left[i] <= right[j])
				res[k++] = left[i++];
			else
				res[k++] = right[j++];
		}
		
		// fill up the remaining array elements
		// although there are two while loops, only one of them will get executed
		// because of the above loop, one array (left or right) is already traversed
		while (i<lenL)
			res[k++] = left[i++];
		while(j<lenR)
			res[k++] = right[i++];
		
		return res;
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
