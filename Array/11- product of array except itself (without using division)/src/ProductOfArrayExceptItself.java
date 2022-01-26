import java.util.Arrays;
/*
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) 
 * such that prod[i] is equal to the product of all the elements of arr[] except 
 * arr[i]. Solve it without division operator in O(n) time.
 * 
 * Input: arr[]  = {10, 3, 5, 6, 2}
 * Output: prod[]  = {180, 600, 360, 300, 900}
 * 
 * Idea: 
 * create a left array in whose indexes are the product of all elements from index 0 
 * to i
 * create a right array in whose indexes are the product of all elements from index n-1 
 * to i
 * 
 * now res[i] = left[i-1]* right[i+1]
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class ProductOfArrayExceptItself {

	public static int[] prodArray(int[] arr) {
		int n = arr.length;
		int[] left = new int[n]; //stores the product of all elements of arr from 0 till i
		int[] right = new int[n]; //stores the product of all elements of arr from n-1 till i
		int[] res = new int[n];
		
		left[0] = arr[0];
		right[n-1] = arr[n-1];
		
		for (int i=1; i<n; i++)
			left[i] = arr[i]*left[i-1];
		
		for (int i=n-2; i>=0; i--)
			right[i] = arr[i]*right[i+1];
		
//		System.out.println(Arrays.toString(left));
//		System.out.println(Arrays.toString(right));
		
		res[0] = right[1];
		res[n-1] = left[n-2];
		
		for (int i=1; i<n-1; i++)
			res[i] = left[i-1] * right[i+1];
		
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr  = {10, 3, 5, 6, 2};
		int[] res = prodArray(arr);
		System.out.println(Arrays.toString(res));
	}

}
