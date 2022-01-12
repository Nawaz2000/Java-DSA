
public class Palindrome {

	public static boolean isPalindrome(String str) {
		int left = 0, right = str.length()-1;
		for (;;) {
			if (left >= right)
				break;
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "madam";
		System.out.println(isPalindrome(str));
		

	}

}
