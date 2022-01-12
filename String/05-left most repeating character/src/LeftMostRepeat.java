import java.util.HashSet;

/*
 * Given a string, find the repeated character present first in the string.
 * 
 * Input  : geeksforgeeks
 * Output : 0 (the character at 0th index)
 */
public class LeftMostRepeat {
	
	//method 1
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

	//method 2 (efficient)
	// the main idea is to use a boolean array. Traverse the array from right once
	// if character is not visited before, bArr[arr[i]] = true;
	// else store the index in a variable
	public static int leftMostEfficient(String str) {
		char[] arr = str.toCharArray();
		boolean[] bArr = new boolean[256];
		
		int res = -1;
		for (int i=arr.length-1; i>=0; i--) {
			if (bArr[arr[i]] == false)
				bArr[arr[i]] = true;
			else
				res = i;
		}
		
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdcef";
//		System.out.println(leftMostRepeatingCharacter(str));
		System.out.println(leftMostEfficient(str));
	}

}
