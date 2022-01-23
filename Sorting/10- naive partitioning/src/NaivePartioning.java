import java.util.Arrays;
/*
 * Given an array(arr) and an index(idx), we need to partition the array based on the index such
 * that all the elements smaller than arr[idx] are on the left, arr[idx] on the middle and elements
 * greater than arr[idx] are on the right of arr[idx]
 * 
 * i/p:
 * arr = {3,8,6,12,10,7}
 * idx = 5
 * 
 * o/p: [3, 6, 7, 8, 12, 10]
 * 
 * Idea: create an auxiliary array (res), traverse the array 3 times.
 * On first iteration, fill res with elements < arr[idx]
 * On second iteration, fill res with elements == arr[idx]
 * On third iteration, fill res with elements > arr[idx]
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class NaivePartioning {

	public static int[] partition(int[] arr, int idx) {
		int[] res = new int[arr.length];
		int partitioner = arr[idx];
		
		int i=0;
		
		for (int j=0; j<arr.length; j++) {
			if (arr[j] < partitioner)
				res[i++] = arr[j];
		}
		
		for (int j=0; j<arr.length; j++) {
			if (arr[j] == partitioner)
				res[i++] = arr[j];
		}
		
		
		for (int j=0; j<arr.length; j++) {
			if (arr[j] > partitioner)
				res[i++] = arr[j];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,8,6,12,10,7};
		int partitionIndx = 5;
		int[] res = partition(arr, partitionIndx);
		System.out.println(Arrays.toString(res));

	}

}
