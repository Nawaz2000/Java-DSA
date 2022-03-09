/*
 * Given an array of integers. Find the Inversion Count in the array. 
 * 
 * Inversion Count: For an array, inversion count indicates how far (or close) the 
 * array is from being sorted. If array is already sorted then the inversion count 
 * is 0. If an array is sorted in the reverse order then the inversion count is the 
 * maximum. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] 
 * and i < j.
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(n+m)
 */
public class Array {
	static long inversionCount(long arr[], long N) {
		return sort(arr, 0, (int) N - 1);
	}

	static long sort(long[] arr, int l, int r) {

		long count = 0;
		if (l < r) {
			int m = l + (r - l) / 2;
			count += sort(arr, l, m);
			count += sort(arr, m + 1, r);
			count += merge(arr, l, m, r);
		}
		return count;
	}

	static long merge(long[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		long left[] = new long[n1];
		long right[] = new long[n2];

		for (int i = 0; i < n1; ++i)
			left[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			right[j] = arr[m + 1 + j];

		int i = 0, j = 0, k = l;
		long count = 0;
		while (i < n1 && j < n2) {

			if (left[i] <= right[j])
				arr[k++] = left[i++];
			else {
				arr[k++] = right[j++];
				count += n1 - i;
			}
		}
		while (i < n1)
			arr[k++] = left[i++];
		while (j < n2)
			arr[k++] = right[j++];

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = { 2, 4, 1, 3, 5 };
		long n = arr.length;
		System.out.println(inversionCount(arr, n));

	}

}
