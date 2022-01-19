/*
 * Find a given number, find the floor of square root of that number
 * 
 * Ex-
 * 
 * i/p: 4
 * o/p: 2
 * 
 * i/p: 8
 * o/p: 2
 * 
 * i/p: 14
 * o/p: 3
 * 
 * Time complexity: O(logn)
 * Auxliary space: O(1)
 */
public class SquareRoot {

	public static int findSquareRoot(int num) {
		int res = -1;
		int low = 1;
		int high = num;
		
		while(low<=high) {
			int mid = (low+high)/2;
			int sqr = mid*mid;
			if (sqr == num)
				return mid;
			if (sqr > num)
				high = mid-1;
			else
			{
				low = mid+1;
				res = mid;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 14;
		System.out.println(findSquareRoot(num));

	}

}
