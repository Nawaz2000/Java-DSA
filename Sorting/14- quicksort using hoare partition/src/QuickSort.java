import java.util.Arrays;
/*
 * Quick Sort
 * implementation of quick sort algorithm using algorithm using hoare partition
 * Stability: unstable
 * 
 * Worst time complexity: O(n^2)
 * Average time complexity: O(nlogn)
 * Auxiliary space: O(1)
 */
public class QuickSort {

	public static int hoarePartition(int[] arr, int left, int right) {
		int i = left-1;
		int j = right+1;
		int pivot = arr[left];
		
		while (i<j) {
			while (arr[++i] < pivot);
			while (arr[--j] > pivot);
			
			if (i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		return j;
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int partitionIndx = hoarePartition(arr, left, right);
			quickSort(arr, left, partitionIndx);
			quickSort(arr, partitionIndx+1, right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {90, 23, 5, 109, 12, 22, 67, 34, 67};
		int left = 0;
		int right = arr.length-1;
		quickSort(arr, left, right);;
		System.out.println(Arrays.toString(arr));

	}

}
