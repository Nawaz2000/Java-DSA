// program to check if two strings are anagrams or not
public class Anagram {

	public static boolean isAnagram(String s1, String s2) {
		int[] count = new int[256];
		
		if (s1.length() != s2.length())
			return false;
		
		for (int i = 0; i<s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		
		for (int i = 0; i<256; i++) {
			if (count[i] != 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Nawaz";
		String s2 = "azwaN";
		System.out.println(isAnagram(s1, s2));

	}

}
