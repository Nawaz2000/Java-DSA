import java.util.Vector;
/*
 * You are given a binary string str. In a single operation, you can choose two 
 * indices L and R such that 1 <= L <= R <= N and complement the characters between 
 * L and R i.e strL, strL+1, …, strR. By complement, we mean change character 
 * 0 to 1 and vice-versa.
 * 
 * You task is to perform ATMOST one operation such that in final string number of 
 * 1s is maximized. If there is no need to complement, i.e., string contains all 
 * 1s, return -1. Else, return the two values denoting L and R. If there are multiple 
 * solutions, return the lexicographically smallest pair of L and R.
 * 
 * Input:
 * str = "111"
 * 
 * Output: -1
 * Explanation: As all characters are '1', 
 * so don't need to complement any.
 * 
 * Input:
 * N = 2
 * str = "01"
 * 
 * Output: 1 1
 * Explanation: After complementing [1, 1] 
 * the string becomes "11".
 * 
 * Time complexity: O(n)
 * Auxiliary complexity: O(1)
 */
public class ContiguousSubarray {
	static Vector<Integer> findRange(String str, int n) {

		int currsum = 0;
		int totalsum = 0;

		int start = -1;
		int end = -1;

		int s = 0;

		for (int i = 0; i < n; i++) {
			int val = str.charAt(i) - '0';

			if (val == 1) {

				val = -1;
			} else {
				val = 1;
			}

			currsum = Math.max(currsum + val, val);

			if (totalsum < currsum) {
				start = s;
				end = i;
				totalsum = currsum;
			}

			if (currsum < 0) {
				currsum = 0;
				s = i + 1;
			}

		}

		Vector<Integer> ans = new Vector<>();
		if (start == -1) {
			ans.add(-1);
		} else {
			ans.add(start + 1);
			ans.add(end + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "0010001100001";
		Vector<Integer> res = findRange(str, str.length());
		for (Integer x : res)
			System.out.print(x + " ");

	}

}
