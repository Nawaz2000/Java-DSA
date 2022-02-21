import java.util.Arrays;

/*
 * Greedy Algorithm to find Minimum number of Coins
 * 
 * Given a value V, if we want to make a change for V Rs, and we have an infinite 
 * supply of each of the denominations in Indian currency, i.e., we have an 
 * infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
 * what is the minimum number of coins and/or notes needed to make the change?
 * 
 * Input: V = 70
 * Output: 2
 * We need a 50 Rs note and a 20 Rs note.
 * 
 * Time complexity: O(num)
 */
public class Greedy {
	static int[] findMinCoins(int[] deno, int num) {
		int i = deno.length-1;
		int[] res = new int[i+1];
		
		while (deno[i] > num)
			i--;
		
		while (num != 0) {
			if (num == deno[i]) {
				res[i]++;
				return res;
			}
			
			if (num < deno[i])
				i--;
			else{
				num = num-deno[i];
				res[i]++;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int num = 121;
		int[] res = findMinCoins(deno, num);
		System.out.println(Arrays.toString(res));

	}

}
