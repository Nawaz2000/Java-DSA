import java.util.Arrays;
/*
 * Given an array containing zeros, move all the zeros to the end of the array
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class MoveAllZeros {

	public static int[] moveZeros(int[] arr, int n) {
		int count = 0;
		for (int i=0; i<n; i++) {
			if (arr[i] != 0) {
				// swap
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				
				count++;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,0,1,0,2,4};
		int n = arr.length;
		System.out.println(Arrays.toString(moveZeros(arr, n)));

	}

}
