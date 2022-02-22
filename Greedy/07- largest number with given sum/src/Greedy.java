/*
 * Geek lost the password of his super locker. He remembers the number of digits N 
 * as well as the sum S of all the digits of his password. He know that his password 
 * is the largest number of N digits that can be made with given sum S. As he is 
 * busy doing his homework, help him retrieving his password.
 * 
 * Input:
 * N = 5, S = 12
 * Output:
 * 93000
 * Explanation:
 * Sum of elements is 12. Largest possible 
 * 5 digit number is 93000 with sum 12.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class Greedy {
	static String largestNumber(int n, int sum) {
		int prevCount = 1;
		String finalStr = "";

		// if the maximum possible sum of n digits is greater than sum, return -1
		if (sum > 9 * n)
			return "-1";

		while (sum > 0 && prevCount <= n) {
			if (sum >= 9) {
				finalStr += '9';
				sum -= 9;
			} else if (sum < 9 && sum != 0) {
				finalStr += sum;
				sum = 0;
			}
			prevCount++;
		}
		while (prevCount <= n) {
			finalStr += '0';
			prevCount++;
		}
		return finalStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 3, S = 29;
		System.out.println(largestNumber(N, S));

	}

}
