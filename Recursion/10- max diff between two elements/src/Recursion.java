
/*
 * Maximum difference between two elements such that larger element appears after the 
 * smaller number
 * 
 * Time complexiy: O(2^n)
 * Auxiliary space: O(1)
 * Space complexity: O(n)
 */
public class Recursion {
	static int maxDiff;
	static void maxDiff(String num, int left, int right) {
		if (left >= right)
			return;
		int currDiff = Integer.valueOf(num.charAt(right)) - Integer.valueOf(num.charAt(left));
		if (currDiff > maxDiff)
			maxDiff = currDiff;
		maxDiff(num, left + 1, right);
		maxDiff(num, left, right-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "7289";
		int left = 0, right = num.length()-1;
		maxDiff(num, left, right);
		System.out.println("Max Diff: " + maxDiff);
	}

}
