import java.util.Arrays;
/*
 * Left rotate an array by d elements
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class LeftRotateByD {
	
	public static int[] leftRotate(int[] arr, int d) {
		StringBuilder sb = new StringBuilder("");
		for (int i : arr)
			sb.append(i);
		
		String x = sb.toString();
		StringBuilder sb2 = new StringBuilder(x.substring(0, d));
		x = sb.substring(d,x.length()) + sb2.reverse();
		
		for (int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(x.substring(i, i+1));
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		int d = 2;
		int[] res = leftRotate(arr, d);
		System.out.println(Arrays.toString(res));
	}

}
