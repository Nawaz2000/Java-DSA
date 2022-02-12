import java.util.Arrays;

/*
 * Given a max heap, an index(i) and a value(x), replace the value at index i with
 * x in such a way that the max heap condition persists
 * 
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class MaxHeap {
	public static int parent(int i) {
		return (i-1)/2;
	}
	
	public static void decreaseKey(int[] arr, int i, int x) {
		arr[i] = x;
		while (i>=0 && arr[parent(i)] < arr[i]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			
			i = parent(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1};
		System.out.println("Before:");
		System.out.println(Arrays.toString(arr));
		
		int i = 4;
		int x = 16;
		decreaseKey(arr, i, x);
		System.out.println("After replacing arr["+i+"] with: "+x);
		System.out.println(Arrays.toString(arr));

	}

}
