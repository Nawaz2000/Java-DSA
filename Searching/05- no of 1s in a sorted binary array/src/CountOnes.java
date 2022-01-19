/*
 * Given a binary array, we have to find the number of 1s present in the array
 * 
 * Ex-
 * 
 * i/p
 * arr = {0,0,1,1,1}
 * 
 * o/p: 3 (number of 1s present)
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 */
public class CountOnes {

	public static int count(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int indx = -1;
		boolean zeroFound = false; // used in the return statement
		
		while(start < end) {
			int mid = (start+end)/2;
			if (arr[mid] == 1) {
				indx = mid;
				end = mid-1;
			}
			
			if (arr[mid] == 0)
			{
				start = mid+1;
				zeroFound = true;
			}
			else
				end = mid-1;
		}
		
		if (indx != -1)
		{
			if (zeroFound == true)
				return arr.length-indx;
			else
				return arr.length;
		}
		else
			return indx;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,1,1,1,1,1};
		System.out.println(count(arr));

	}

}
