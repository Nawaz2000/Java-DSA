import java.util.Arrays;

/*
 * Given an unsorted array arr[] of n positive integers. Find the number of triangles that 
 * can be formed with three different array elements as lengths of three sides of triangles.
 * 
 * Input: 
 * n = 5
 * arr[] = {6, 4, 9, 7, 8}
 * 
 * Output: 
 * 10
 * Explanation: 
 * There are 10 triangles
 * possible  with the given elements like
 * (6,4,9), (6,7,8),...
 * 
 * Time complexity: O(n^2)
 */
public class Triangles {

	public static void countTriangles(int[] arr, int n) {
		int count = 0;
		Arrays.sort(arr);
		
		for (int i=n-1; i>=2; i--) {
			int l=0;
			int r=i-1;
			
			while (l<r) {
				if (arr[l] + arr[r] > arr[i]) {
					count += (r-l);
					r--;
				}else
					l++;
			}
		}
		
		System.out.println("Number of triangles found: " + count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 4, 9, 7, 8};
		countTriangles(arr, arr.length);

	}

}
