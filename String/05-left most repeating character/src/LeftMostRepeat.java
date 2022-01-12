import java.util.HashSet;

/*
 * Given a string, find the repeated character present first in the string.
 * 
 * Input  : geeksforgeeks
 * Output : 0 (the character at 0th index)
 */
public class LeftMostRepeat {
	
	public static int leftMostRepeatingCharacter(String str) {
		char[] arr = str.toCharArray();
		int[] count = new int[256];
		
		// store the count of every character
		for (char c : arr)
			count[c]++;
		
		// traverse arr and find it's corresponding value in count
		for (int i=0; i<arr.length; i++) {
			if (count[(char)arr[i]] > 1)
				return i;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Nawaz";
		System.out.println(leftMostRepeatingCharacter(str));

	}

}
