import java.util.Arrays;

/*
 * Find the leftmost non-repeating character's index
 * 
 * i/p = "nnnbcdd"
 * o/p = 3
 */

/*
 * The idea is to create an auxiliary array count[256] and fill it up with -1
 * We traverse arr and if count[arr[i]] == -1 (describing that we are first visiting the
 * element), we set count[arr[i]] = i (storing the index of the non-repeating element)
 * else count[arr[i]] = -2 (marking that the element has appeared multiple times
 */
public class LeftNonRepeat {

	public static int leftMostNonRepeating(String str) {
		char[] arr = str.toCharArray();
		int[] count = new int[256];
		Arrays.fill(count,-1);
		
		int res = Integer.MAX_VALUE;
		for (int i=0; i<arr.length; i++) {
			if (count[arr[i]] == -1)
				count[arr[i]] = i;
			else
				count[arr[i]] = -2;
		}
		
		for (int i=0; i<count.length; i++) {
			if (count[i] >= 0 && count[i]<res)
				res = count[i];
		}
		System.out.println("res: " + res);
		return (res==Integer.MAX_VALUE)?-1:res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaac";
		System.out.println(leftMostNonRepeating(str));

	}

}
