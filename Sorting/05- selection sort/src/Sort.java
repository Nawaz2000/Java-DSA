import java.util.Arrays;
/*
 * Selection sort algorithm
 * 
 * Idea:
 * Traverse the array from i, (n-1) times.
 * Each time find the index of the min element and swap it with arr[i]
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 */
public class Sort {

	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n-1; i++) {
			int minIdx = i;
			for (int j=i+1; j<n; j++) {
				if (arr[j] < arr[minIdx])
					minIdx = j;
			}
			
			// swap
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,1,4,3,8,9,7};
		int[] res = selectionSort(arr);
		System.out.println(Arrays.toString(res));

	}

}
