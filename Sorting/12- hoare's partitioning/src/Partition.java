import java.util.Arrays;
/*
 * Hoare's partition
 * 
 * Idea: 
 * Traverse the array while i<j. Use two loops inside the main loop using two pointers form 
 * left(i) and from right(j) until the first inner loop finds the element that is > pivot and
 * the second inner loop finds elements that is < pivot.
 * Swap the elements
 * 
 * Time complexity: O(n) but does upto 3x less comparisions than lomuto partition
 * Auxiliary space: O(1)
 */
public class Partition {

	public static void hoarePartition(int[] arr) {
		int pivot = arr[0];
		int i=-1; // for traversing arr from left to right
		int j=arr.length; // for traversing arr from right to left
		
		while (i<j) {
			while(arr[++i]<pivot);// finds the next element that is > pivot
			while(arr[--j]>pivot);// finds the preceding element that is < pivot
			// once it finds the above, it swaps them
			if (i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		// j becomes the index at whose left are all the elements that are < pivot
		// and on right are the elements that are >= pivot
		System.out.println("j = " + j);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,3,8,4,2,7,1,10};
//		int[] arr = {10,4,1,2,9,4,7,8,3};
		hoarePartition(arr);

	}

}
