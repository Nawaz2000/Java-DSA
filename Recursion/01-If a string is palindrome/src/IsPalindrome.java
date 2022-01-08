
public class IsPalindrome {

	public static boolean isPalindrome(String str, int start, int end) {
		if (start == end || start > end)
			return true;
		
		if (str.charAt(start) == str.charAt(end))
			return isPalindrome(str, start+1, end-1);
		else
			return false;
		
		
	}

	public static void main(String[] args) {
		String str = "12321";
		int start = 0;
		int end = str.length()-1;
		System.out.println(isPalindrome(str, start, end));

	}
	
}
